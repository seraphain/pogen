package com.github.seraphain.pogen.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "COLUMNS", schema = "information_schema")
@IdClass(ColumnPO.PK.class)
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

    @Column(name = "GENERATION_EXPRESSION")
    private String generationExpression;

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Long ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Long getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(Long characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public Long getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(Long characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    public Long getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Long numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public Long getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Long numericScale) {
        this.numericScale = numericScale;
    }

    public Long getDatetimePrecision() {
        return datetimePrecision;
    }

    public void setDatetimePrecision(Long datetimePrecision) {
        this.datetimePrecision = datetimePrecision;
    }

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName;
    }

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getGenerationExpression() {
        return generationExpression;
    }

    public void setGenerationExpression(String generationExpression) {
        this.generationExpression = generationExpression;
    }

    @Override
    public String toString() {
        return "ColumnPO [tableCatalog=" + tableCatalog + ", tableSchema=" + tableSchema + ", tableName=" + tableName
                + ", columnName=" + columnName + ", ordinalPosition=" + ordinalPosition + ", columnDefault="
                + columnDefault + ", isNullable=" + isNullable + ", dataType=" + dataType + ", characterMaximumLength="
                + characterMaximumLength + ", characterOctetLength=" + characterOctetLength + ", numericPrecision="
                + numericPrecision + ", numericScale=" + numericScale + ", datetimePrecision=" + datetimePrecision
                + ", characterSetName=" + characterSetName + ", collationName=" + collationName + ", columnType="
                + columnType + ", columnKey=" + columnKey + ", extra=" + extra + ", privileges=" + privileges
                + ", columnComment=" + columnComment + ", generationExpression=" + generationExpression + "]";
    }

    @SuppressWarnings("serial")
    public static class PK implements Serializable {

        private String tableSchema;

        private String tableName;

        private String columnName;

        public PK() {

        }

        public PK(String tableSchema, String tableName, String columnName) {
            this.tableSchema = tableSchema;
            this.tableName = tableName;
            this.columnName = columnName;
        }

        public String getTableSchema() {
            return tableSchema;
        }

        public void setTableSchema(String tableSchema) {
            this.tableSchema = tableSchema;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
            result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
            result = prime * result + ((tableSchema == null) ? 0 : tableSchema.hashCode());
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
            PK other = (PK) obj;
            if (columnName == null) {
                if (other.columnName != null) {
                    return false;
                }
            } else if (!columnName.equals(other.columnName)) {
                return false;
            }
            if (tableName == null) {
                if (other.tableName != null) {
                    return false;
                }
            } else if (!tableName.equals(other.tableName)) {
                return false;
            }
            if (tableSchema == null) {
                if (other.tableSchema != null) {
                    return false;
                }
            } else if (!tableSchema.equals(other.tableSchema)) {
                return false;
            }
            return true;
        }

    }

}
