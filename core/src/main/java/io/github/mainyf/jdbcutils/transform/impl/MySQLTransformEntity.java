package io.github.mainyf.jdbcutils.transform.impl;

import io.github.mainyf.jdbcutils.annotations.*;
import io.github.mainyf.jdbcutils.entitys.FieldAttribute;
import io.github.mainyf.jdbcutils.entitys.FieldEntity;
import io.github.mainyf.jdbcutils.entitys.TableEntity;
import io.github.mainyf.jdbcutils.transform.IEntityTransform;
import io.github.mainyf.jdbcutils.utils.ReflectUtils;
import io.github.mainyf.jdbcutils.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MySQLTransformEntity implements IEntityTransform {

    @Override
    public TableEntity transform(Class entityClass) {
        Entity entity = ReflectUtils.getAnnotation(entityClass, Entity.class);
        List<FieldEntity> fieldEntities = new ArrayList<>();
        try {
            final Object obj = entityClass.newInstance();
            fieldEntities = ReflectUtils.getAllField(entityClass)
                .stream()
                .filter((v) -> v.getAnnotation(Column.class) != null)
                .map((v) -> {
                    Column column = v.getAnnotation(Column.class);
                    Length length = v.getAnnotation(Length.class);
                    Precision precision = v.getAnnotation(Precision.class);
                    return new FieldEntity(
                        StringUtils.isBlank(column.name()) ? v.getName() : column.name(),
                        column.type(),
                        v.getAnnotation(PrimaryKey.class) != null,
                        column.notNull(),
                        new FieldAttribute(
                            length == null ? null : length.value(),
                            precision == null ? null : precision.value(),
                            null,
                            column.autoIncrement()
                        )
                    );
                })
                .collect(Collectors.toList());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return new TableEntity(
            StringUtils.isBlank(entity.table()) ? entityClass.getSimpleName() : entity.table(),
            fieldEntities
        );
    }

}
