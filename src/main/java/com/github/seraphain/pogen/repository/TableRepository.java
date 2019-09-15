package com.github.seraphain.pogen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.github.seraphain.pogen.po.TablePO;

public interface TableRepository extends Repository<TablePO, TablePO.PK> {

    @Query(value = "SELECT TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, TABLE_TYPE, ENGINE, VERSION, ROW_FORMAT, TABLE_ROWS, AVG_ROW_LENGTH, DATA_LENGTH, MAX_DATA_LENGTH, INDEX_LENGTH, DATA_FREE, AUTO_INCREMENT, CREATE_TIME, UPDATE_TIME, CHECK_TIME, TABLE_COLLATION, CHECKSUM, CREATE_OPTIONS, TABLE_COMMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = ?1", nativeQuery = true)
    List<TablePO> findByTableSchema(String tableSchema);

}
