package io.github.mainyf.sqlbuilder.builder.create.entrys;

import lombok.Getter;

public enum DataTypeEntry {

    VARCHAR,
    BINARY,
    BLOB,
    CHAR,
    DATE,
    YEAR,
    DOUBLE,
    ENUM,
    DATETIME,
    DECIMAL,
    FLOAT,
    INT,
    INTEGER,
    JSON,
    LINESTRING,
    LONGBLOB,
    LONGTEXT,
    SET,
    TEXT,
    TIME,
    TIMESTAMP,
    VARBINARY;

    @Getter
    private Integer length;

    @Getter
    private Integer precision;

    @Getter
    private boolean nullable = true;

    @Getter
    private Object defaultValue;

    public DataTypeEntry length(int length) {
        this.length = length;
        return this;
    }

    private DataTypeEntry nullable(boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    private DataTypeEntry precision(int precision) {
        this.precision = precision;
        return this;
    }

    private DataTypeEntry defaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

}