package io.github.mainyf.jdbcutils.sql.builder.create;

import io.github.mainyf.jdbcutils.sql.builder.IBuilder;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.CharsetsEntry;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.DataEngineEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.MetadataEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.ColumnConstrainEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.DataTypeEntry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreateBuilder implements IBuilder {

    private String tableName;
    private Map<String, DataTypeEntry> columns;
    private List<ColumnConstrainEntry> constraintsSet;
    private MetadataEntry metadata;

    public CreateBuilder(String tableName) {
        this.tableName = tableName;
    }

    public CreateBuilder column(String name, DataTypeEntry typeEntry) {
        if(this.columns.containsKey(name)) {
            throw new RuntimeException(name + " column already exists");
        }
        this.columns.put(name, typeEntry);
        return this;
    }

    public CreateBuilder constraints(ColumnConstrainEntry... constraintsSet) {
        this.constraintsSet = Arrays.asList(constraintsSet);
        return this;
    }

    public CreateBuilder charset(CharsetsEntry charset) {
        metadata.setCharset(charset);
        return this;
    }

    public CreateBuilder dataEngine(DataEngineEntry dataEngine) {
        metadata.setDataEngine(dataEngine);
        return this;
    }

    @Override
    public String toSQL() {
        // TODO use column builder generate sql string
        return "";
    }
}
