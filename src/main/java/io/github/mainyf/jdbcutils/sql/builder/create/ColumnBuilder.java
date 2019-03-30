package io.github.mainyf.jdbcutils.sql.builder.create;

import io.github.mainyf.jdbcutils.sql.builder.IBuilder;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.ColumnConstrainEntry;
import io.github.mainyf.jdbcutils.sql.builder.create.entrys.DataTypeEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.var;

import java.util.List;

@Getter
@AllArgsConstructor
public class ColumnBuilder implements IBuilder {

    private String name;
    private DataTypeEntry dataType;
    private List<ColumnConstrainEntry> constrainEntries;

    @Override
    public String toSQL() {
        var sqlBuilder = new StringBuilder();
        sqlBuilder.append(name).append(" ");
        sqlBuilder.append(dataType.name());
        if (dataType.getLength() != null) {
            sqlBuilder.append("(").append(dataType.getLength()).append(")");
            if (dataType.getPrecision() != null) {
                sqlBuilder.append("(").append(dataType.getPrecision()).append(")");
            }
        }
        sqlBuilder.append(" ").append(dataType.isNullable() ? "NULL" : "NOT NULL").append(" ");

        int length = this.constrainEntries.size();
        for (int i = 0; i < length; i++) {
            sqlBuilder.append(this.constrainEntries.get(i).getType().toString());
            if(i != length - 1) {
                sqlBuilder.append(" ");
            }
        }

        return sqlBuilder.toString();
    }
}
