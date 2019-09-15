package ${packageBase}.dal.ibatis;

<#if idColumns?size == 1>
import java.util.ArrayList;
</#if>
import java.util.Collections;
<#if idColumns?size gt 1>
import java.util.HashMap;
</#if>
import java.util.List;
import java.util.Map;

import ${packageBase}.dao.${className}DAO;
import ${packageBase}.po.${className}PO;

import org.mybatis.spring.SqlSessionTemplate;

public class MyBatis${className}DAO extends SqlMapClientDaoSupport implements ${className}DAO {

    private SqlSessionTemplate sqlSessionTemplate;

    @Override
	public ${className}PO insert(${className}PO ${className?uncap_first}) {
		if (${className?uncap_first} == null) {
		    return null;
		}
		sqlSessionTemplate.insert("insert${className}", ${className?uncap_first});
		return ${className?uncap_first};
	}

    @Override
	public void update(${className}PO ${className?uncap_first}) {
        if (${className?uncap_first} == null) {
            return null;
        }
        sqlSessionTemplate.update("update${className}", ${className?uncap_first});
	}

    @Override
    public void delete(${className}PO ${className?uncap_first}) {
        if (${className?uncap_first} == null) {
            return;
        }
        sqlSessionTemplate.delete("delete${className}", ${className?uncap_first});
    }

    @Override
    public void deleteById(<#list idColumns as column>${column.javaType} ${column.attributeName}<#sep>, </#sep></#list>) {
<#if idColumns?size == 1>
    <#if !idColumns[0].primary>
        Assert.assertNotNull(${idColumns[0].attributeName});
    </#if>
        sqlSessionTemplate.delete("delete${className}ById", ${idColumns[0].attributeName});
<#else>
        Map<String, Object> conditions = new HashMap<>();
    <#list idColumns as column>
        conditions.put("${column.attributeName}", ${column.attributeName});
    </#list>
        sqlSessionTemplate.delete("delete${className}ById", conditions);
</#if>
    }

<#if idColumns?size == 1>
    @Override
    public void deleteByIds(List<${idColumns[0].javaTypeSimple}> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }
        return sqlSessionTemplate.queryForList("delete${className}ByIds", ids);
    }

</#if>
    @Override
    public ${className}PO findById(<#list idColumns as column>${column.javaType} ${column.attributeName}<#sep>, </#sep></#list>) {
<#if idColumns?size == 1>
    <#if !idColumns[0].primary>
        Assert.assertNotNull(${idColumns[0].attributeName});
    </#if>
        return sqlSessionTemplate.queryForObject("find${className}ById", ${idColumns[0].attributeName});
<#else>
        Map<String, Object> conditions = new HashMap<>();
    <#list idColumns as column>
        conditions.put("${column.attributeName}", ${column.attributeName});
    </#list>
        return sqlSessionTemplate.queryForObject("find${className}ById", conditions);
</#if>
    }

<#if idColumns?size == 1>
    @Override
    public List<${className}PO> findByIds(List<${idColumns[0].javaTypeSimple}> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        return sqlSessionTemplate.queryForList("find${className}ByIds", ids);
    }

</#if>
    @Override
    public List<${className}PO> find(Map<String, Object> conditions) {
        if (conditions == null) {
            conditions = Collections.emptyMap();
        }
        return sqlSessionTemplate.queryForList("find${className}", conditions);
    }

    @Override
    public int count(Map<String, Object> conditions) {
        if (conditions == null) {
            conditions = Collections.emptyMap();
        }
        Integer count = sqlSessionTemplate.queryForObject("count${className}", conditions);
        return count.intValue();
    }

}
