package com.github.seraphain.pogen.vo;

import java.util.ArrayList;
import java.util.List;

public class TableVO {

    private String tableName;

    private String tableComment;

    private String packageBase;

    private String className;

    private List<ColumnVO> columns;

    private List<ColumnVO> idColumns;

    private List<ColumnVO> nonIdColumns;

    private List<String> idJavaTypesImport;

    private List<String> javaTypesImport;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getPackageBase() {
        return packageBase;
    }

    public void setPackageBase(String packageBase) {
        this.packageBase = packageBase;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ColumnVO> getColumns() {
        if (columns == null) {
            columns = new ArrayList<>();
        }
        return columns;
    }

    public void setColumns(List<ColumnVO> columns) {
        this.columns = columns;
    }

    public List<ColumnVO> getIdColumns() {
        if (idColumns == null) {
            idColumns = new ArrayList<>();
        }
        return idColumns;
    }

    public void setIdColumns(List<ColumnVO> idColumns) {
        this.idColumns = idColumns;
    }

    public List<ColumnVO> getNonIdColumns() {
        if (nonIdColumns == null) {
            nonIdColumns = new ArrayList<>();
        }
        return nonIdColumns;
    }

    public void setNonIdColumns(List<ColumnVO> nonIdColumns) {
        this.nonIdColumns = nonIdColumns;
    }

    public List<String> getIdJavaTypesImport() {
        if (idJavaTypesImport == null) {
            idJavaTypesImport = new ArrayList<>();
        }
        return idJavaTypesImport;
    }

    public void setIdJavaTypesImport(List<String> idJavaTypesImport) {
        this.idJavaTypesImport = idJavaTypesImport;
    }

    public List<String> getJavaTypesImport() {
        if (javaTypesImport == null) {
            javaTypesImport = new ArrayList<>();
        }
        return javaTypesImport;
    }

    public void setJavaTypesImport(List<String> javaTypesImport) {
        this.javaTypesImport = javaTypesImport;
    }

    @Override
    public String toString() {
        return "TableVO [tableName=" + tableName + ", tableComment=" + tableComment + ", packageBase=" + packageBase
                + ", className=" + className + ", columns=" + columns + ", idColumns=" + idColumns + ", nonIdColumns="
                + nonIdColumns + ", idJavaTypesImport=" + idJavaTypesImport + ", javaTypesImport=" + javaTypesImport
                + "]";
    }

}
