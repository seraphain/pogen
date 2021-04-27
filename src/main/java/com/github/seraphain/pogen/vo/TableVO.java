package com.github.seraphain.pogen.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
