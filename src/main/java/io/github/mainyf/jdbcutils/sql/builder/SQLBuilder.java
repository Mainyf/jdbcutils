package io.github.mainyf.jdbcutils.sql.builder;

import com.google.common.collect.Sets;
import io.github.mainyf.jdbcutils.sql.builder.create.CreateBuilder;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.ColumnConstrainEntry;

public class SQLBuilder {

    public static CreateBuilder create(String tableName) {
        return new CreateBuilder(tableName);
    }

    public ColumnConstrainEntry primaryKey(String columnName) {
        return new ColumnConstrainEntry(ColumnConstrainEntry.ConstrainType.PRIMARYKEY, Sets.newHashSet(columnName));
    }

    public ColumnConstrainEntry unique(String... columnNames) {
        return new ColumnConstrainEntry(ColumnConstrainEntry.ConstrainType.UNIQUE, Sets.newHashSet(columnNames));
    }

    public ColumnConstrainEntry autoIncrement(String... columnNames) {
        return new ColumnConstrainEntry(ColumnConstrainEntry.ConstrainType.AUTOINCREMENT, Sets.newHashSet(columnNames));
    }
}
