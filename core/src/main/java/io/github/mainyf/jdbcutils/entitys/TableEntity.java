package io.github.mainyf.jdbcutils.entitys;

import io.github.mainyf.sqlbuilder.Charsets;
import io.github.mainyf.sqlbuilder.DataEngine;
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

    private Charsets charset = Charsets.UTF8;

    private DataEngine engineType = DataEngine.MyISAM;

}
