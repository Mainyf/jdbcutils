package io.github.mainyf.jdbcutils.sql.builder.create.entrys;

import io.github.mainyf.jdbcutils.sql.builder.commonentrys.CharsetsEntry;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.DataEngineEntry;
import lombok.Data;

@Data
public class MetadataEntry {

    private CharsetsEntry charset = CharsetsEntry.UTF8;
    private DataEngineEntry dataEngine = DataEngineEntry.MyISAM;



}
