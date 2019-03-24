package io.github.mainyf.jdbcutils.utils;

public class ObjectUtils {

    public static <T> T get(T obj, T defaultValue) {
        return obj == null ? defaultValue : obj;
    }

}
