package io.github.mainyf.jdbcutils.sql.builder.create;

import com.google.common.collect.Sets;
import io.github.mainyf.jdbcutils.sql.builder.IBuilder;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.CharsetsEntry;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.DataEngineEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.ConstrainEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.DataTypeEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.MetadataEntry;
import lombok.var;

import java.util.Map;
import java.util.Set;

public class CreateBuilder implements IBuilder {

    private String tableName;
    private Map<String, DataTypeEntry> columns;
    private Set<ConstrainEntry> constraintsSet;
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

    public CreateBuilder constraints(ConstrainEntry... constraintsSet) {
        this.constraintsSet = Sets.newHashSet(constraintsSet);
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
//        new ColumnBuilder()
        var sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS");
        return "";
    }
}
