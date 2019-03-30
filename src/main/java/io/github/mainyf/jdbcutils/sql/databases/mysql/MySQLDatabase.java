package io.github.mainyf.jdbcutils.sql.databases.mysql;

import io.github.mainyf.jdbcutils.ConnectionPool;
import io.github.mainyf.jdbcutils.JDBCInfo;
import io.github.mainyf.jdbcutils.entitys.TableEntity;
import io.github.mainyf.jdbcutils.sql.databases.IDataTable;
import io.github.mainyf.jdbcutils.sql.databases.IDatabase;
import io.github.mainyf.jdbcutils.transform.IEntityTransform;
import io.github.mainyf.jdbcutils.transform.impl.MySQLTransformEntity;
import io.github.mainyf.jdbcutils.utils.$;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class MySQLDatabase implements IDatabase {

    private JDBCInfo jdbcInfo;
    private ConnectionPool pool;
    private Map<Key, IDataTable> entityMap = new HashMap<>();
    private IEntityTransform tableTransform = new MySQLTransformEntity();
    private boolean hasInited = false;

    public MySQLDatabase(JDBCInfo jdbcInfo) {
        this.jdbcInfo = jdbcInfo;
    }

    @Override
    public void initDatabase() throws ClassNotFoundException {
        this.pool = new ConnectionPool(this.jdbcInfo);
        this.pool.initPool();
        this.hasInited = true;
    }

    @Override
    public <T> void registerEntity(Class<T> entityClass) {
        checkHasInited();
        if(entityMap.containsKey(entityClass)) {
            throw new RuntimeException("entity already register");
        }
        TableEntity entity = tableTransform.transform(entityClass);
        if(entity != null) {
            checkSameName(entity.getName());
            checkSameEntity(entityClass);
            entityMap.put(new Key(entity.getName(), entityClass), new MySQLDataTable<>(entityClass, entity, this));
        } else {
            throw new RuntimeException("transform entity fail");
        }
    }

    private void checkSameName(String tableName) {
        if($.some(this.entityMap.keySet(), (v) -> v.name.equals(tableName))) {
            throw new RuntimeException("table name already exists");
        }
    }

    private void checkSameEntity(Class clazz) {
        if($.some(this.entityMap.keySet(), (v) -> v.clazz.equals(clazz))) {
            throw new RuntimeException("entity already exists");
        }
    }

    @Override
    public IDataTable getTable(String name) {
        return this.entityMap.get($.find(this.entityMap.keySet(), (v) -> v.name.equals(name)));
    }

    @Override
    public IDataTable getTable(Class clazz) {
        return this.entityMap.get($.find(this.entityMap.keySet(), (v) -> v.clazz.equals(clazz)));
    }

    @Override
    public ConnectionPool getConnectionPool() {
        return this.pool;
    }

    @Override
    public JDBCInfo getJDBCInfo() {
        return this.jdbcInfo;
    }

    private void checkHasInited() {
        if(!this.hasInited) {
            throw new RuntimeException("Uninitialized");
        }
    }

    @Data
    @AllArgsConstructor
    private class Key {

        private String name;
        private Class clazz;

    }
}
