package io.github.mainyf.sqlbuilder.commonentrys;

import io.github.mainyf.sqlbuilder.builder.IEntry;

public enum CharsetsEntry implements IEntry {

    UTF8,
    GBK;

    public String toString() {
        return name().toLowerCase();
    }

}
