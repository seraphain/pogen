package com.github.seraphain.pogen.vo;

import org.apache.commons.lang3.StringUtils;

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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public boolean isPrimitive() {
        return !nullable && StringUtils.isNotBlank(javaTypePrimitive);
    }

    public String getJavaTypePrimitive() {
        return javaTypePrimitive;
    }

    public void setJavaTypePrimitive(String javaTypePrimitive) {
        this.javaTypePrimitive = javaTypePrimitive;
    }

    public String getJavaTypeSimple() {
        return javaTypeSimple;
    }

    public void setJavaTypeSimple(String javaTypeSimple) {
        this.javaTypeSimple = javaTypeSimple;
    }

    public String getJavaTypeFull() {
        return javaTypeFull;
    }

    public void setJavaTypeFull(String javaTypeFull) {
        this.javaTypeFull = javaTypeFull;
    }

    public String getJavaType() {
        return isPrimitive() ? javaTypePrimitive : javaTypeSimple;
    }

    public String getJavaTypeResultSet() {
        return javaTypeResultSet;
    }

    public void setJavaTypeResultSet(String javaTypeResultSet) {
        this.javaTypeResultSet = javaTypeResultSet;
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

    @Override
    public String toString() {
        return "ColumnVO [columnName=" + columnName + ", columnComment=" + columnComment + ", jdbcType=" + jdbcType
                + ", primary=" + primary + ", autoIncrement=" + autoIncrement + ", nullable=" + nullable
                + ", attributeName=" + attributeName + ", javaTypePrimitive=" + javaTypePrimitive + ", javaTypeSimple="
                + javaTypeSimple + ", javaTypeFull=" + javaTypeFull + ", javaTypeResultSet=" + javaTypeResultSet + "]";
    }

}
