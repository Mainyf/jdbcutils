package io.github.mainyf.jdbcutils;

import org.junit.Test;

public class MainTest {

    @Test
    public void test() {

//        MySQLDatabase database = new MySQLDatabase("minecraft");
//        database.registerEntity();
        System.out.println(
            JDBCInfo
                .builder()
                .host("localhost")

        );
    }

}

