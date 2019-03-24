package io.github.mainyf.jdbcutils.enums;

public enum ColumnType {

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


    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
