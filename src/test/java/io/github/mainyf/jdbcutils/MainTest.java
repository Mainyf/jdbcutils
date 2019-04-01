package io.github.mainyf.jdbcutils;

import io.github.mainyf.jdbcutils.sql.builder.SQLBuilder;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.DataTypeEntry;
import org.junit.Test;

public class MainTest {

    @Test
    public void test() {
//        MySQLDatabase database = new MySQLDatabase(JDBCInfo
//                .builder()
//                .host("localhost")
//                .driver("com.mysql.cj.jdbc.Driver")
//                .port(3306)
//                .username("root")
//                .password("yxf1223785950")
//                .database("demo")
//                .disableSSL()
//                .setGMTB8()
//                .build()
//        );
//        try {
//            database.initDatabase();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        database.registerEntity(User.class);
//        MySQLDataTable table = (MySQLDataTable) database.getTable(User.class);
//        table.createTable();
        System.out.println(
            SQLBuilder
                .createIfNotExists("demoTable")
                .column("uid", DataTypeEntry.INT.length(100))
                .column("uuid", DataTypeEntry.BINARY)
                .column("name", DataTypeEntry.VARCHAR.length(100))
                .column("age", DataTypeEntry.INT.length(20))
                .constraints(
                    SQLBuilder.constrain().primaryKey("uuid"),
                    SQLBuilder.constrain().autoIncrement("uid"),
                    SQLBuilder.constrain().unique("uid", "uuid")
                )
                .metadatas(
                    SQLBuilder.metadata().charset("asdasd"),
                    SQLBuilder.metadata().dataEngine("asdasd")
                )
                .toSQL()
        );

    }

}

