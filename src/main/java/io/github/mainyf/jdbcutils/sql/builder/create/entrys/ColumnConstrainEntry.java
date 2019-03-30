package io.github.mainyf.jdbcutils.sql.builder.create.entrys;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ColumnConstrainEntry {

    private ConstrainType type;
    private Set<String> columnName;

    public enum ConstrainType {
        PRIMARYKEY,
        UNIQUE,
        AUTOINCREMENT;

        @Override
        public String toString() {
            switch (this) {
                case AUTOINCREMENT:
                    return "AUTO_INCREMENT";
                default:
                    return name().toLowerCase();
            }
        }
    }

}
