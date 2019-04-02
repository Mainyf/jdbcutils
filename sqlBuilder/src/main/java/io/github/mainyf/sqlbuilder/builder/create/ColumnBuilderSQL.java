package io.github.mainyf.sqlbuilder.builder.create;

import io.github.mainyf.sqlbuilder.builder.IBuilderSQL;
import io.github.mainyf.sqlbuilder.builder.create.entrys.constrain.ConstrainEntry;
import io.github.mainyf.sqlbuilder.builder.create.entrys.DataTypeEntry;
import io.github.mainyf.sqlbuilder.builder.create.entrys.constrain.IConstrain;
import io.github.mainyf.jdbcutils.utils.$;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.var;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ColumnBuilderSQL implements IBuilderSQL {

    private String name;
    private DataTypeEntry dataType;
    private Set<IConstrain> constrainEntries;

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

        int i = 0;
        int size = this.constrainEntries.size();
        for(IConstrain constrain : this.constrainEntries) {
            if(constrain instanceof ConstrainEntry) {
                var entry = (ConstrainEntry) constrain;
                if($.some(entry.getColumnName(), x -> x.equals(name))) {
                    sqlBuilder.append(entry.getType().toString());
                }
                if(i != size - 1) {
                    sqlBuilder.append(" ");
                }
            }
            i++;
        }

        return sqlBuilder.toString();
    }
}
