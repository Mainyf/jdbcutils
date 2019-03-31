package io.github.mainyf.jdbcutils.sql.builder.create.factorys;

import com.google.common.collect.Sets;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.ConstrainEntry;

public class ConstrainFactory {

    public ConstrainEntry primaryKey(String columnName) {
        return new ConstrainEntry(ConstrainEntry.ConstrainType.PRIMARYKEY, Sets.newHashSet(columnName));
    }

    public ConstrainEntry unique(String... columnNames) {
        return new ConstrainEntry(ConstrainEntry.ConstrainType.UNIQUE, Sets.newHashSet(columnNames));
    }

    public ConstrainEntry autoIncrement(String... columnNames) {
        return new ConstrainEntry(ConstrainEntry.ConstrainType.AUTOINCREMENT, Sets.newHashSet(columnNames));
    }

}
