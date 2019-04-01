package io.github.mainyf.jdbcutils.sql.builder;

import io.github.mainyf.jdbcutils.sql.builder.create.CreateBuilderSQL;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.constrain.ConstrainEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.metadata.MetadataEntry;

public class SQLBuilder {

    public static CreateBuilderSQL create(String tableName) {
        return new CreateBuilderSQL(tableName);
    }

    public static CreateBuilderSQL createIfNotExists(String tableName) {
        return new CreateBuilderSQL(tableName, CreateBuilderSQL.CreateType.CREATE_IF_NOT_EXISTS);
    }

    public static MetadataEntry metadata() {
        return new MetadataEntry();
    }

    public static ConstrainEntry constrain() {
        return new ConstrainEntry();
    }

}
