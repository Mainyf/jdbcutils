package io.github.mainyf.sqlbuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

public class SQLExecuter {

    private ConnectionPool pool;

    public SQLExecuter(ConnectionPool pool) {
        this.pool = pool;
    }

    public int executeUpdateSQL(String sql) {
        return executeUpdateSQL(sql, Collections.emptyMap());
    }

    public int executeUpdateSQL(String sql, Map<String, Object> values) {
        Connection connection = this.pool.getConnection();
        PreparedWrap statement = new PreparedWrap();
        int result = 0;
        try {
            statement.setPrepared(connection.prepareStatement(sql));
            statement.setValues(values);
            statement.setup();
            result = statement.getPrepared().executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.cleanResources(connection, statement.getPrepared());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void executeQuerySQL(String sql, Consumer<ResultSet> consumer) {
        executeQuerySQL(sql, Collections.emptyMap(), consumer);
    }

    public void executeQuerySQL(String sql, Map<String, Object> values, Consumer<ResultSet> consumer) {
        Connection connection = this.pool.getConnection();
        PreparedWrap statement = new PreparedWrap();
        ResultSet result = null;
        try {
            statement.setPrepared(connection.prepareStatement(sql));
            statement.setValues(values);
            statement.setup();
            result = statement.getPrepared().executeQuery();
            consumer.accept(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.cleanResources(connection, result, statement.getPrepared());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cleanResources(AutoCloseable ...resources) throws Exception {
        for(AutoCloseable res : resources) {
            if(res != null) {
                res.close();
            }
        }
    }

}
