package io.github.mainyf.jdbcutils.entitys;

import io.github.mainyf.jdbcutils.enums.TableDataEngine;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

    private Charset charset = StandardCharsets.UTF_8;

    private TableDataEngine engineType = TableDataEngine.MyISAM;

}
