package com.github.seraphain.pogen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.github.seraphain.pogen.po.ColumnPO;

public interface ColumnRepository extends Repository<ColumnPO, ColumnPO.PK> {

    @Query(value = "SELECT TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, COLUMN_DEFAULT, IS_NULLABLE, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, CHARACTER_OCTET_LENGTH, NUMERIC_PRECISION, NUMERIC_SCALE, DATETIME_PRECISION, CHARACTER_SET_NAME, COLLATION_NAME, COLUMN_TYPE, COLUMN_KEY, EXTRA, PRIVILEGES, COLUMN_COMMENT FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = ?1 AND TABLE_NAME = ?2", nativeQuery = true)
    List<ColumnPO> findByTableSchemaAndTableName(String tableSchema, String tableName);

}
