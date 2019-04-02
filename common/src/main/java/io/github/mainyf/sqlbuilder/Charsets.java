package io.github.mainyf.sqlbuilder;

public enum Charsets {
    UTF8,
    GBK;

    public String toString() {
        return name().toLowerCase();
    }

}
