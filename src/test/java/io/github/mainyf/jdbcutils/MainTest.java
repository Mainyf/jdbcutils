package io.github.mainyf.jdbcutils;

import io.github.mainyf.jdbcutils.sql.databases.mysql.MySQLDataTable;
import io.github.mainyf.jdbcutils.sql.databases.mysql.MySQLDatabase;
import org.junit.Test;

public class MainTest {

    @Test
    public void test() {

        MySQLDatabase database = new MySQLDatabase(JDBCInfo
                .builder()
                .host("localhost")
                .driver("com.mysql.cj.jdbc.Driver")
                .port(3306)
                .username("root")
                .password("yxf1223785950")
                .database("demo")
                .disableSSL()
                .setGMTB8()
                .build()
        );
        try {
            database.initDatabase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        database.registerEntity(User.class);
        MySQLDataTable table = (MySQLDataTable) database.getTable(User.class);
        table.createTable();
    }

}

