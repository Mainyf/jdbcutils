package io.github.mainyf.jdbcutils.sql.builder;

import io.github.mainyf.jdbcutils.sql.builder.create.CreateBuilder;

public class SQLBuilder {

    public static CreateBuilder create(String tableName) {
        return new CreateBuilder(tableName);
    }

}
