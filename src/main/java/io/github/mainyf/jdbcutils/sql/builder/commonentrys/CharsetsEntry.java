package io.github.mainyf.jdbcutils.sql.builder.commonentrys;

import io.github.mainyf.jdbcutils.sql.builder.IEntry;

public enum CharsetsEntry implements IEntry {

    UTF8,
    GBK;

    public String toString() {
        return name().toLowerCase();
    }

}
