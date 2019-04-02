package io.github.mainyf.sqlbuilder.databases;

import io.github.mainyf.sqlbuilder.ConnectionPool;
import io.github.mainyf.sqlbuilder.JDBCInfo;

public interface IDatabase {

    void initDatabase() throws ClassNotFoundException;

    <T> void registerEntity(Class<T> entityClass);

    IDataTable getTable(String name);

    IDataTable getTable(Class clazz);

    ConnectionPool getConnectionPool();

    JDBCInfo getJDBCInfo();

}
