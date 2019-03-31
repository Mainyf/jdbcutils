package io.github.mainyf.jdbcutils.sql.builder.create.entrys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConstrainEntry {

    private ConstrainType type;
    private Set<String> columnName = new HashSet<>();

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
