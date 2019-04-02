package io.github.mainyf.jdbcutils.entitys;

import io.github.mainyf.jdbcutils.enums.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldEntity {

    private String fieldName;

    private ColumnType type;

    private boolean hasPrimaryKey;

    private boolean notNull;

    private FieldAttribute attribute;

}
