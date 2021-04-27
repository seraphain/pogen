package com.github.seraphain.pogen.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COLUMNS", schema = "information_schema")
@IdClass(ColumnPO.PK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnPO {

    @Column(name = "TABLE_CATALOG")
    private String tableCatalog;

    @Id
    @Column(name = "TABLE_SCHEMA")
    private String tableSchema;

    @Id
    @Column(name = "TABLE_NAME")
    private String tableName;

    @Id
    @Column(name = "COLUMN_NAME")
    private String columnName;

    @Column(name = "ORDINAL_POSITION")
    private Long ordinalPosition;

    @Column(name = "COLUMN_DEFAULT")
    private String columnDefault;

    @Column(name = "IS_NULLABLE")
    private String isNullable;

    @Column(name = "DATA_TYPE")
    private String dataType;

    @Column(name = "CHARACTER_MAXIMUM_LENGTH")
    private Long characterMaximumLength;

    @Column(name = "CHARACTER_OCTET_LENGTH")
    private Long characterOctetLength;

    @Column(name = "NUMERIC_PRECISION")
    private Long numericPrecision;

    @Column(name = "NUMERIC_SCALE")
    private Long numericScale;

    @Column(name = "DATETIME_PRECISION")
    private Long datetimePrecision;

    @Column(name = "CHARACTER_SET_NAME")
    private String characterSetName;

    @Column(name = "COLLATION_NAME")
    private String collationName;

    @Column(name = "COLUMN_TYPE")
    private String columnType;

    @Column(name = "COLUMN_KEY")
    private String columnKey;

    @Column(name = "EXTRA")
    private String extra;

    @Column(name = "PRIVILEGES")
    private String privileges;

    @Column(name = "COLUMN_COMMENT")
    private String columnComment;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @SuppressWarnings("serial")
    public static class PK implements Serializable {

        private String tableSchema;

        private String tableName;

        private String columnName;

    }

}
