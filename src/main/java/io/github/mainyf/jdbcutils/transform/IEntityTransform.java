package io.github.mainyf.jdbcutils.transform;

import io.github.mainyf.jdbcutils.entitys.TableEntity;

public interface IEntityTransform {

    TableEntity transform(Class entityClass);

}
