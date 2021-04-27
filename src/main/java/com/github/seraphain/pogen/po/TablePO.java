package com.github.seraphain.pogen.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TABLES", schema = "information_schema")
@IdClass(TablePO.PK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @SuppressWarnings("serial")
    public static class PK implements Serializable {

        private String tableSchema;

        private String tableName;

    }

}
