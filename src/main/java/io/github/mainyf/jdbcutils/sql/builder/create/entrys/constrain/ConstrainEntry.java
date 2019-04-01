package io.github.mainyf.jdbcutils.sql.builder.create.entrys.constrain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConstrainEntry extends ConstrainFinalEntry {

    private String[] columnName;
    private ConstrainType type;

    public ConstrainFinalEntry primaryKey(String columnName) {
        this.columnName = new String[]{columnName};
        this.type = ConstrainType.PRIMARYKEY;
        return this;
    }

    public ConstrainFinalEntry unique(String... columnNames) {
        this.columnName = columnNames;
        this.type = ConstrainEntry.ConstrainType.UNIQUE;
        return this;
    }

    public ConstrainFinalEntry autoIncrement(String... columnNames) {
        this.columnName = columnNames;
        this.type = ConstrainEntry.ConstrainType.AUTOINCREMENT;
        return this;
    }

    public enum ConstrainType {

        PRIMARYKEY,
        UNIQUE,
        AUTOINCREMENT;

        @Override
        public String toString() {
            switch (this) {
                case PRIMARYKEY:
                    return "PRIMARY KEY";
                case AUTOINCREMENT:
                    return "AUTO_INCREMENT";
                default:
                    return name().toLowerCase();
            }
        }
    }

}
