package io.github.mainyf.jdbcutils.annotations;

import io.github.mainyf.jdbcutils.enums.ColumnType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    ColumnType type();

    String name() default "";

    boolean notNull() default true;

    boolean autoIncrement() default false;

}
