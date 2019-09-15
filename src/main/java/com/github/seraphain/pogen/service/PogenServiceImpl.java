package com.github.seraphain.pogen.service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.github.seraphain.pogen.po.ColumnPO;
import com.github.seraphain.pogen.po.TablePO;
import com.github.seraphain.pogen.repository.ColumnRepository;
import com.github.seraphain.pogen.repository.TableRepository;
import com.github.seraphain.pogen.service.name.NameGenerator;
import com.github.seraphain.pogen.service.type.TypeMapper;
import com.github.seraphain.pogen.vo.ColumnVO;
import com.github.seraphain.pogen.vo.TableVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

@Service
public class PogenServiceImpl implements PogenService, InitializingBean {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private NameGenerator classNameGenerator;

    @Autowired
    private NameGenerator attributeNameGenerator;

    @Autowired
    private TypeMapper typeMapper;

    @Value("${pogen.templates.configuration}")
    private Resource templatesConfiguration;

    @Value("${pogen.table.schema}")
    private String tableSchema;

    @Value("${pogen.table.include}")
    private String tableInclude;

    @Value("${pogen.package.base}")
    private String packageBase;

    private Map<String, String> templates;

    @Override
    public void afterPropertiesSet() throws Exception {
        String templatesJson = FileUtils.readFileToString(templatesConfiguration.getFile(), StandardCharsets.UTF_8);
        Type jsonType = new TypeToken<Map<String, String>>() {
        }.getType();
        templates = new Gson().fromJson(templatesJson, jsonType);
    }

    @Override
    public void generate() {
        List<TableVO> tables = getTables();
        generate(tables);
    }

    private List<TableVO> getTables() {
        List<TablePO> tables = tableRepository.findByTableSchema(tableSchema);
        Set<String> tableNames = getTableInclude();
        return tables.stream().filter(t -> isTableIncluded(tableNames, t)).map(this::convert)
                .collect(Collectors.toList());
    }

    private Set<String> getTableInclude() {
        return Arrays.stream(tableInclude.split(",")).filter(StringUtils::isNotBlank).map(String::trim)
                .collect(Collectors.toSet());
    }

    private boolean isTableIncluded(Collection<String> tableNames, TablePO table) {
        return tableNames.isEmpty() || tableNames.contains(table.getTableName().toLowerCase());
    }

    private TableVO convert(TablePO table) {
        TableVO vo = new TableVO();
        vo.setTableName(table.getTableName());
        vo.setTableComment(table.getTableComment());
        vo.setPackageBase(packageBase);
        vo.setClassName(classNameGenerator.generate(table.getTableName()));

        List<ColumnPO> columns = columnRepository.findByTableSchemaAndTableName(tableSchema, table.getTableName());
        vo.setColumns(columns.stream().map(this::convert).collect(Collectors.toList()));
        vo.setIdColumns(vo.getColumns().stream().filter(ColumnVO::isPrimary).collect(Collectors.toList()));
        vo.setNonIdColumns(vo.getColumns().stream().filter(c -> !c.isPrimary()).collect(Collectors.toList()));
        vo.setJavaTypesImport(getImports(vo.getColumns()));
        vo.setIdJavaTypesImport(getImports(vo.getIdColumns()));
        return vo;
    }

    private ColumnVO convert(ColumnPO column) {
        if (column == null) {
            return null;
        }
        ColumnVO vo = new ColumnVO();
        vo.setColumnName(column.getColumnName());
        vo.setColumnComment(column.getColumnComment());
        vo.setJdbcType(typeMapper.getJdbcType(column.getDataType().toLowerCase()));
        vo.setPrimary("pri".equalsIgnoreCase(column.getColumnKey()));
        vo.setAutoIncrement(StringUtils.contains(column.getExtra().toLowerCase(), "auto_increment"));
        vo.setNullable("yes".equalsIgnoreCase(column.getIsNullable()));
        vo.setAttributeName(attributeNameGenerator.generate(column.getColumnName()));
        vo.setJavaTypePrimitive(typeMapper.getJavaTypePrimitive(column.getDataType().toLowerCase()));
        vo.setJavaTypeSimple(typeMapper.getJavaTypeSimple(column.getDataType().toLowerCase()));
        vo.setJavaTypeFull(typeMapper.getJavaTypeFull(column.getDataType().toLowerCase()));
        vo.setJavaTypeResultSet(typeMapper.getJavaTypeResultSet(column.getDataType().toLowerCase()));
        return vo;
    }

    private List<String> getImports(List<ColumnVO> columns) {
        return columns.stream().map(c -> typeMapper.getJavaTypeImport(c.getJdbcType().toLowerCase()))
                .filter(StringUtils::isNotBlank).distinct().sorted().collect(Collectors.toList());
    }

    private void generate(List<TableVO> tables) {
        templates.entrySet().stream().forEach(e -> generate(tables, e.getKey(), e.getValue()));
    }

    private void generate(List<TableVO> tables, String templateDirectory, String generatedDirectory) {
        File generated = new File(generatedDirectory);
        if (!generated.exists()) {
            generated.mkdirs();
        }
        File basePackage = new File(generated, packageBase.replaceAll("\\.", "/"));
        if (!basePackage.exists()) {
            basePackage.mkdirs();
        }

        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setDirectoryForTemplateLoading(new File(templateDirectory));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setLocale(Locale.US);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            File templateDirectoryFile = new File(templateDirectory);
            tables.stream().forEach(t -> generate(t, basePackage, cfg, templateDirectoryFile.listFiles()));
        } catch (IOException e) {
            throw new PogenServiceException(e);
        }
    }

    private void generate(TableVO table, File generatedDirectory, Configuration cfg, File[] templateFiles) {
        System.out.println("Table: " + table);
        Arrays.stream(templateFiles).forEach(t -> generate(table, generatedDirectory, cfg, StringUtils.EMPTY, t));
    }

    private void generate(TableVO table, File generatedDirectory, Configuration cfg, String relatedPath,
            File templateFile) {
        File generatedFile = new File(generatedDirectory, generateFileName(table, templateFile.getName()));
        if (templateFile.isDirectory()) {
            generatedFile.mkdirs();
            Arrays.stream(templateFile.listFiles())
                    .forEach(f -> generate(table, generatedFile, cfg, relatedPath + templateFile.getName() + "/", f));
        } else {
            System.out.println("Template: " + relatedPath + templateFile.getName());
            try {
                Template template = cfg.getTemplate(relatedPath + templateFile.getName());
                Writer out = new StringWriter();
                template.process(table, out);
                FileUtils.writeStringToFile(generatedFile, out.toString(), StandardCharsets.UTF_8);
            } catch (TemplateException | IOException e) {
                throw new PogenServiceException(e);
            }
        }

    }

    private String generateFileName(TableVO table, String fileNameTemplate) {
        fileNameTemplate = fileNameTemplate.replaceAll("&quest;", "?");
        try {
            Template template = new Template(fileNameTemplate, fileNameTemplate, null);
            Writer out = new StringWriter();
            template.process(table, out);
            return out.toString();
        } catch (TemplateException | IOException e) {
            throw new PogenServiceException(e);
        }
    }

}
