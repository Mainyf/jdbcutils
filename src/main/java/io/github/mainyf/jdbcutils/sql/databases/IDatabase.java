package io.github.mainyf.jdbcutils.sql.databases;

import io.github.mainyf.jdbcutils.ConnectionPool;
import io.github.mainyf.jdbcutils.JDBCInfo;

public interface IDatabase {

    void initDatabase() throws ClassNotFoundException;

    <T> void registerEntity(Class<T> entityClass);

    IDataTable getTable(String name);

    IDataTable getTable(Class clazz);

    ConnectionPool getConnectionPool();

    JDBCInfo getJDBCInfo();

}
