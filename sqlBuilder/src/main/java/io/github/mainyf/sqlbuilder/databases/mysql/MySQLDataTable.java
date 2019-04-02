package io.github.mainyf.sqlbuilder.databases.mysql;

import io.github.mainyf.sqlbuilder.SQLExecuter;
import io.github.mainyf.jdbcutils.entitys.FieldAttribute;
import io.github.mainyf.jdbcutils.entitys.FieldEntity;
import io.github.mainyf.jdbcutils.entitys.TableEntity;
import io.github.mainyf.sqlbuilder.databases.IDataTable;
import io.github.mainyf.sqlbuilder.databases.IDatabase;
import io.github.mainyf.sqlbuilder.where.Where;

import java.util.List;
import java.util.Set;

public class MySQLDataTable<T> implements IDataTable {

    private Class<T> type;
    private TableEntity entity;
    private IDatabase database;
    private SQLExecuter sqlExecuter;

    public MySQLDataTable(Class<T> type, TableEntity entity, IDatabase database) {
        this.type = type;
        this.entity = entity;
        this.database = database;
        this.sqlExecuter = new SQLExecuter(this.database.getConnectionPool());
    }

    @Override
    public void createTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS `");
        sqlBuilder
            .append(database.getJDBCInfo().getDatabase())
            .append("`.`").append(this.entity.getName()).append("`")
            .append(this.createSQL());

        System.out.println(sqlBuilder.toString());

        sqlExecuter.executeUpdateSQL(sqlBuilder.toString());
    }

    public String createSQL() {
        StringBuilder sqlBuilder = new StringBuilder("(");
        List<FieldEntity> fields = this.entity.getFieldEntities();
        int length = fields.size();
        for (int i = 0; i < length; i++) {
            if (i != 0 && i != length - 1) {
                sqlBuilder.append(" ");
            }
            sqlBuilder.append(this.fieldSQL(fields.get(i)));
            if (i != length - 1) {
                sqlBuilder.append(",");
            }
        }
        sqlBuilder
            .append(") ")
            .append("ENGINE=").append(entity.getEngineType().name()).append(" ")
            .append("DEFAULT CHARSET=").append(entity.getCharset().toString());

        return sqlBuilder.toString();
    }

    private String fieldSQL(FieldEntity fieldEntity) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
            .append("`").append(fieldEntity.getFieldName()).append("`")
            .append(" ")
            .append(fieldEntity.getType().toString());
        FieldAttribute attribute = fieldEntity.getAttribute();
        if (attribute != null) {
            Integer length = attribute.getLength();
            if (length != null) {
                sqlBuilder.append("(").append(length);
                Integer precision = attribute.getPrecision();
                if (precision != null) {
                    sqlBuilder.append(",").append(precision);
                }
                sqlBuilder.append(")");
            }
        }
        sqlBuilder.append(" ");
        if (fieldEntity.isHasPrimaryKey()) {
            sqlBuilder.append("PRIMARY KEY ");
        }
        if (fieldEntity.getAttribute().isAutoIncrement()) {
            sqlBuilder.append("AUTO_INCREMENT ");
        }
        sqlBuilder.append(fieldEntity.isNotNull() ? "NOT NULL" : "NULL");

        return sqlBuilder.toString();
    }

    @Override
    public int insert(Object entity) {
        return 0;
    }

    @Override
    public int insertList(Object entity) {
        return 0;
    }

    @Override
    public int update(Object entity, Where where) {
        return 0;
    }

    @Override
    public Object find(Where where) {
        return null;
    }

    @Override
    public Set findList(Where where) {
        return null;
    }

    @Override
    public int delete(Where where) {
        return 0;
    }
}
