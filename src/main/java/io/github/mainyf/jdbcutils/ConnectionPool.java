package io.github.mainyf.jdbcutils;

import com.google.common.reflect.Reflection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {

    private JDBCInfo jdbcInfo;
    private LinkedList<Connection> dataSources = new LinkedList<>();

    public ConnectionPool(JDBCInfo jdbcInfo) {
        this.jdbcInfo = jdbcInfo;
    }

    public void initPool() throws ClassNotFoundException {
        if (jdbcInfo.getDriver().isEmpty()) {
            throw new RuntimeException("jdbc info driver class path cannot null");
        }
        Class.forName(jdbcInfo.getDriver());
        for(int i = 0;i < jdbcInfo.getMaxPool();i++) {
            addConnection();
        }
    }

    private void addConnection() {
        try {
            this.dataSources.add(
                DriverManager.getConnection(
                    "jdbc:mysql://" +
                        jdbcInfo.getHost() +
                        ":" +
                        jdbcInfo.getDatabase() +
                        jdbcInfo.toParamsString(),
                    jdbcInfo.getUsername(),
                    jdbcInfo.getPassword()
                )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cleanPool() {
        dataSources.forEach((v) -> {
            try {
                v.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public Connection getConnection() {
        if (dataSources.isEmpty()) {
            addConnection();
        }
        Connection conn = dataSources.removeFirst();
        return attachProxyToConnection(conn);
    }

    private Connection attachProxyToConnection(Connection connection) {
        return Reflection.newProxy(connection.getClass(), (proxy, method, args) -> {
            if (method.getName().equals("close")) {
                dataSources.addLast(connection);
                return null;
            }
            return args == null ? method.invoke(connection) : method.invoke(connection, args);
        });
    }

}

