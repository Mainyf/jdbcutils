package io.github.mainyf.jdbcutils.enums;

public enum DatabaseCharsets {

    UTF8,
    GBK;

    public String toString() {
        return name().toLowerCase();
    }

}
