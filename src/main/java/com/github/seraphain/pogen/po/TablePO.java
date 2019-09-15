package com.github.seraphain.pogen.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "TABLES", schema = "information_schema")
@IdClass(TablePO.PK.class)
public class TablePO {

    @Column(name = "TABLE_CATALOG")
    private String tableCatalog;

    @Id
    @Column(name = "TABLE_SCHEMA")
    private String tableSchema;

    @Id
    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "TABLE_TYPE")
    private String tableType;

    @Column(name = "ENGINE")
    private String engine;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "ROW_FORMAT")
    private String rowFormat;

    @Column(name = "TABLE_ROWS")
    private Long tableRows;

    @Column(name = "AVG_ROW_LENGTH")
    private Long avgRowLength;

    @Column(name = "DATA_LENGTH")
    private Long dataLength;

    @Column(name = "MAX_DATA_LENGTH")
    private Long maxDataLength;

    @Column(name = "INDEX_LENGTH")
    private Long indexLength;

    @Column(name = "DATA_FREE")
    private Long dataFree;

    @Column(name = "AUTO_INCREMENT")
    private Long autoIncrement;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "CHECK_TIME")
    private Date checkTime;

    @Column(name = "TABLE_COLLATION")
    private String tableCollation;

    @Column(name = "CHECKSUM")
    private Long checksum;

    @Column(name = "CREATE_OPTIONS")
    private String createOptions;

    @Column(name = "TABLE_COMMENT")
    private String tableComment;

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

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    public Long getTableRows() {
        return tableRows;
    }

    public void setTableRows(Long tableRows) {
        this.tableRows = tableRows;
    }

    public Long getAvgRowLength() {
        return avgRowLength;
    }

    public void setAvgRowLength(Long avgRowLength) {
        this.avgRowLength = avgRowLength;
    }

    public Long getDataLength() {
        return dataLength;
    }

    public void setDataLength(Long dataLength) {
        this.dataLength = dataLength;
    }

    public Long getMaxDataLength() {
        return maxDataLength;
    }

    public void setMaxDataLength(Long maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    public Long getIndexLength() {
        return indexLength;
    }

    public void setIndexLength(Long indexLength) {
        this.indexLength = indexLength;
    }

    public Long getDataFree() {
        return dataFree;
    }

    public void setDataFree(Long dataFree) {
        this.dataFree = dataFree;
    }

    public Long getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Long autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getTableCollation() {
        return tableCollation;
    }

    public void setTableCollation(String tableCollation) {
        this.tableCollation = tableCollation;
    }

    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    public String getCreateOptions() {
        return createOptions;
    }

    public void setCreateOptions(String createOptions) {
        this.createOptions = createOptions;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    @Override
    public String toString() {
        return "TablePO [tableCatalog=" + tableCatalog + ", tableSchema=" + tableSchema + ", tableName=" + tableName
                + ", tableType=" + tableType + ", engine=" + engine + ", version=" + version + ", rowFormat="
                + rowFormat + ", tableRows=" + tableRows + ", avgRowLength=" + avgRowLength + ", dataLength="
                + dataLength + ", maxDataLength=" + maxDataLength + ", indexLength=" + indexLength + ", dataFree="
                + dataFree + ", autoIncrement=" + autoIncrement + ", createTime=" + createTime + ", updateTime="
                + updateTime + ", checkTime=" + checkTime + ", tableCollation=" + tableCollation + ", checksum="
                + checksum + ", createOptions=" + createOptions + ", tableComment=" + tableComment + "]";
    }

    @SuppressWarnings("serial")
    public static class PK implements Serializable {

        private String tableSchema;

        private String tableName;

        public PK() {

        }

        public PK(String tableSchema, String tableName) {
            this.tableSchema = tableSchema;
            this.tableName = tableName;
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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
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
            if (tableName == null) {
                if (other.tableName != null)
                    return false;
            } else if (!tableName.equals(other.tableName))
                return false;
            if (tableSchema == null) {
                if (other.tableSchema != null)
                    return false;
            } else if (!tableSchema.equals(other.tableSchema)) {
                return false;
            }
            return true;
        }

    }

}
