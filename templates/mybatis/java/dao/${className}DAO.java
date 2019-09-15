package ${packageBase}.dao;

<#list idJavaTypesImport as idJavaTypeImport>
import ${idJavaTypeImport};
</#list>
import java.util.List;
import java.util.Map;

import ${packageBase}.po.${className}PO;

public interface ${className}DAO {

    ${className}PO insert(${className}PO ${className?uncap_first});

    void update(${className}PO ${className?uncap_first});

    void delete(${className}PO ${className?uncap_first});

    void deleteById(<#list idColumns as column>${column.javaType} ${column.attributeName}<#sep>, </#sep></#list>);

    ${className}PO findById(<#list idColumns as column>${column.javaType} ${column.attributeName}<#sep>, </#sep></#list>);

<#if idColumns?size == 1>
    List<${className}PO> findByIds(List<${idColumns[0].javaTypeSimple}> ids);

</#if>
    List<${className}PO> find(Map<String, Object> conditions);

    int count(Map<String, Object> conditions);

}
