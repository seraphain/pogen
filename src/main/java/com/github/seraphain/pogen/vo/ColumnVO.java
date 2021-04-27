package com.github.seraphain.pogen.vo;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnVO {

    private String columnName;

    private String columnComment;

    private String jdbcType;

    private boolean primary;

    private boolean autoIncrement;

    private boolean nullable;

    private String attributeName;

    private String javaTypePrimitive;

    private String javaTypeSimple;

    private String javaTypeFull;

    private String javaTypeResultSet;

    public boolean isPrimitive() {
        return !nullable && StringUtils.isNotBlank(javaTypePrimitive);
    }

    public String getJavaType() {
        return isPrimitive() ? javaTypePrimitive : javaTypeSimple;
    }

    public String getGetterName() {
        if ("boolean".equals(javaTypePrimitive) || "Boolean".equals(javaTypeSimple)) {
            if (attributeName.toLowerCase().startsWith("is")) {
                return "is" + StringUtils.capitalize(attributeName.substring(2));
            } else {
                return "is" + StringUtils.capitalize(attributeName);
            }
        } else {
            return "get" + StringUtils.capitalize(attributeName);
        }
    }

    public String getSetterName() {
        if ("boolean".equals(javaTypePrimitive) || "Boolean".equals(javaTypeSimple)) {
            if (attributeName.toLowerCase().startsWith("is")) {
                return "set" + StringUtils.capitalize(attributeName.substring(2));
            } else {
                return "set" + StringUtils.capitalize(attributeName);
            }
        } else {
            return "set" + StringUtils.capitalize(attributeName);
        }
    }

}
