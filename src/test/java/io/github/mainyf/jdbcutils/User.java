package io.github.mainyf.jdbcutils;

import io.github.mainyf.jdbcutils.annotations.Column;
import io.github.mainyf.jdbcutils.annotations.Entity;
import io.github.mainyf.jdbcutils.annotations.Length;
import io.github.mainyf.jdbcutils.annotations.PrimaryKey;
import io.github.mainyf.jdbcutils.enums.ColumnType;

import java.util.UUID;

@Entity
public class User {

    @Column(
        type = ColumnType.INT,
        autoIncrement = true
    )
    @Length(200)
    @PrimaryKey
    private int uid;

    @Column(
        type = ColumnType.BINARY
    )
    @Length(36)
    private UUID uuid;

    @Column(
        type = ColumnType.VARCHAR
    )
    @Length(200)
    private String username;

    @Column(
        type = ColumnType.VARCHAR
    )
    @Length(200)
    private String password;

}
