package com.github.seraphain.pogen.service.type;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class TypeMapperImpl implements TypeMapper, InitializingBean {

    @Value("${pogen.types.configuration}")
    private Resource typesConfiguration;

    private Map<String, String> jdbcTypes;

    private Map<String, String> javaTypePrimitive;

    private Map<String, String> javaTypesSimple;

    private Map<String, String> javaTypesFull;

    private Map<String, String> javaTypesImport;

    private Map<String, String> javaTypesResultSet;

    @Override
    public void afterPropertiesSet() throws Exception {
        String typesJson = FileUtils.readFileToString(typesConfiguration.getFile(), StandardCharsets.UTF_8);
        Type jsonType = new TypeToken<Map<String, Map<String, String>>>() {
        }.getType();
        Map<String, Map<String, String>> types = new Gson().fromJson(typesJson, jsonType);
        jdbcTypes = types.get("jdbcTypes");
        javaTypePrimitive = types.get("javaTypePrimitive");
        javaTypesSimple = types.get("javaTypesSimple");
        javaTypesFull = types.get("javaTypesFull");
        javaTypesImport = types.get("javaTypesImport");
        javaTypesResultSet = types.get("javaTypesResultSet");
    }

    @Override
    public String getJdbcType(String dataType) {
        return jdbcTypes.get(dataType);
    }

    @Override
    public String getJavaTypePrimitive(String dataType) {
        return javaTypePrimitive.get(dataType);
    }

    @Override
    public String getJavaTypeSimple(String dataType) {
        return javaTypesSimple.get(dataType);
    }

    @Override
    public String getJavaTypeFull(String dataType) {
        return javaTypesFull.get(dataType);
    }

    @Override
    public String getJavaTypeImport(String dataType) {
        return javaTypesImport.get(dataType);
    }

    @Override
    public String getJavaTypeResultSet(String dataType) {
        return javaTypesResultSet.get(dataType);
    }

}
