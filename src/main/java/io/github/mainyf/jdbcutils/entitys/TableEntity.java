package io.github.mainyf.jdbcutils.entitys;

import io.github.mainyf.jdbcutils.enums.DatabaseCharsets;
import io.github.mainyf.jdbcutils.enums.TableDataEngine;
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

    private DatabaseCharsets charset = DatabaseCharsets.UTF8;

    private TableDataEngine engineType = TableDataEngine.MyISAM;

}
