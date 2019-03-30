package io.github.mainyf.jdbcutils.entitys;

import io.github.mainyf.jdbcutils.sql.builder.commonentrys.CharsetsEntry;
import io.github.mainyf.jdbcutils.sql.builder.commonentrys.DataEngineEntry;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TableEntity {

    public TableEntity(String name, List<FieldEntity> fieldEntities) {
        this.name = name;
        this.fieldEntities = fieldEntities;
    }

    private String name;

    private List<FieldEntity> fieldEntities;

    private CharsetsEntry charset = CharsetsEntry.UTF8;

    private DataEngineEntry engineType = DataEngineEntry.MyISAM;

}
