package io.github.mainyf.jdbcutils.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldAttribute {

    private Integer length;

    private Integer precision;

    private Object defaultValue;

    private boolean autoIncrement;

}
