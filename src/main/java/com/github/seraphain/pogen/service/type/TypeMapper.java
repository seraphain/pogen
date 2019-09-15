package com.github.seraphain.pogen.service.type;

public interface TypeMapper {

    String getJdbcType(String dataType);

    String getJavaTypePrimitive(String dataType);

    String getJavaTypeSimple(String dataType);

    String getJavaTypeFull(String dataType);

    String getJavaTypeImport(String dataType);

    String getJavaTypeResultSet(String dataType);

}
