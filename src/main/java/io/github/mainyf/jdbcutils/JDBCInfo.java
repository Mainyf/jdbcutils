package io.github.mainyf.jdbcutils;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class JDBCInfo {

    private String driver;
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;
    private Map<String, String> params;
    private int maxPool = 10;

    public String toParamsString() {
        if(params.isEmpty()) {
            return "";
        }
        StringBuilder paramsString = new StringBuilder("?");
        for(Map.Entry<String, String> entry : this.params.entrySet()) {
            paramsString
                .append(entry.getKey())
                .append("=")
                .append(entry.getValue())
                .append("&");
        }

        paramsString.replace(paramsString.length() - 1, paramsString.length(), "");

        return paramsString.toString();
    }

    public static JDBCInfoBuilder builder() {
        return new JDBCInfoBuilder();
    }

    public static final class JDBCInfoBuilder {
        private String driver;
        private String host;
        private int port;
        private String database;
        private String username;
        private String password;
        private Map<String, String> params;
        private int maxPool = 10;

        private JDBCInfoBuilder() {
        }

        public JDBCInfoBuilder driver(String driver) {
            this.driver = driver;
            return this;
        }

        public JDBCInfoBuilder host(String host) {
            this.host = host;
            return this;
        }

        public JDBCInfoBuilder database(String database) {
            this.database = database;
            return this;
        }

        public JDBCInfoBuilder port(int port) {
            this.port = port;
            return this;
        }

        public JDBCInfoBuilder username(String username) {
            this.username = username;
            return this;
        }

        public JDBCInfoBuilder password(String password) {
            this.password = password;
            return this;
        }

        public JDBCInfoBuilder params(String name, String value) {
            this.params.put(name, value);
            return this;
        }

        public JDBCInfoBuilder setGMTB8() {
            this.params.put("serverTimezone", "GMT%2B8");
            return this;
        }

        public JDBCInfoBuilder disableSSL() {
            this.params.put("useSSL", "false");
            return this;
        }

        public JDBCInfoBuilder maxPool(int maxPool) {
            this.maxPool = maxPool;
            return this;
        }

        public JDBCInfo build() {
            JDBCInfo jDBCInfo = new JDBCInfo();
            jDBCInfo.setDriver(driver);
            jDBCInfo.setHost(host);
            jDBCInfo.setPort(port);
            jDBCInfo.setDatabase(database);
            jDBCInfo.setUsername(username);
            jDBCInfo.setPassword(password);
            jDBCInfo.setParams(params);
            jDBCInfo.setMaxPool(maxPool);
            return jDBCInfo;
        }
    }
}
