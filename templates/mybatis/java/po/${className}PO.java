package ${packageBase}.po;

import java.io.Serializable;
<#list javaTypesImport as javaTypeImport>
import ${javaTypeImport};
</#list>

/**
 * ${tableComment}
 * 
 * @author 
 */
@SuppressWarnings("serial")
public class ${className}PO implements Serializable {

<#list columns as column>
    <#if column.primitive>
    /** ${column.columnComment} <#if column.primary>PK </#if>*/
    <#else>
    /** ${column.columnComment} <#if column.primary>PK </#if><#if !column.primary && !column.javaTypePrimitive??>nullable:${column.nullable?string('yes', 'no')} </#if>*/
    </#if>
    private ${column.javaType} ${column.attributeName};

</#list>
<#list columns as column>
    public ${column.javaType} ${column.getterName}() {
        return ${column.attributeName};
    }

    public void ${column.setterName}(${column.javaType} ${column.attributeName}) {
        this.${column.attributeName} = ${column.attributeName};
    }

</#list>
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
<#list columns as column>
    <#if column.javaType == 'boolean'>
        result = prime * result + (${column.attributeName} ? 1231 : 1237);
    <#elseif column.javaType == 'int'>
        result = prime * result + ${column.attributeName};
    <#elseif column.javaType == 'long'>
        result = prime * result + (int) (${column.attributeName} ^ (${column.attributeName} >>> 32));
    <#elseif column.javaType == 'double'>
        long ${column.attributeName}L = Double.doubleToLongBits(${column.attributeName});
        result = prime * result + (int) (${column.attributeName}L ^ (${column.attributeName}L >>> 32));
    <#else>
        result = prime * result + ((${column.attributeName} == null) ? 0 : ${column.attributeName}.hashCode());
    </#if>
</#list>
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ${className}PO other = (${className}PO) obj;
<#list columns as column>
    <#if column.javaType == 'boolean'>
        if (${column.attributeName} != other.${column.attributeName}) {
            return false;
        }
    <#elseif column.javaType == 'int'>
        if (${column.attributeName} != other.${column.attributeName}) {
            return false;
        }
    <#elseif column.javaType == 'long'>
        if (${column.attributeName} != other.${column.attributeName}) {
            return false;
        }
    <#elseif column.javaType == 'double'>
        if (Double.doubleToLongBits(${column.attributeName}) != Double.doubleToLongBits(other.${column.attributeName})) {
            return false;
        }
    <#else>
        if (${column.attributeName} == null) {
            if (other.${column.attributeName} != null) {
                return false;
            }
        } else if (!${column.attributeName}.equals(other.${column.attributeName})) {
            return false;
        }
    </#if>
</#list>
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
<#list columns as column>
        builder.append("${column.attributeName}=").append(${column.attributeName}).append(", ");
</#list>
        if (builder.length() > 0) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return "${className}PO [" + builder.toString()+ "]";
    }

}
