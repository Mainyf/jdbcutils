package io.github.mainyf.jdbcutils.sql.builder.create.entrys.metadata;

import io.github.mainyf.jdbcutils.sql.builder.IBuilderSQL;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.CharsetsEntry;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.DataEngineEntry;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MetadataEntry extends MetadataFinalEntry implements IBuilderSQL {

    private CharsetsEntry charset = CharsetsEntry.UTF8;
    private DataEngineEntry dataEngine = DataEngineEntry.MyISAM;

    private MetadataType type;

    public MetadataFinalEntry charset(CharsetsEntry charset) {
        this.type = MetadataType.CHARSET;
        this.setCharset(charset);
        return this;
    }

    public MetadataFinalEntry dataEngine(DataEngineEntry dataEngine) {
        this.type = MetadataType.DATA_ENGINE;
        this.setDataEngine(dataEngine);
        return this;
    }

    @Override
    public String toSQL() {

        return null;
    }

    public enum MetadataType {
        CHARSET,
        DATA_ENGINE
    }
}
