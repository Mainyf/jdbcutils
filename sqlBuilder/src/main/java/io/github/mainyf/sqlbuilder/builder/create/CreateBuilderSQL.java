package io.github.mainyf.sqlbuilder.builder.create;

import com.google.common.collect.Sets;
import io.github.mainyf.sqlbuilder.builder.IBuilderSQL;
import io.github.mainyf.sqlbuilder.builder.create.entrys.DataTypeEntry;
import io.github.mainyf.sqlbuilder.builder.create.entrys.metadata.MetadataEntry;
import io.github.mainyf.sqlbuilder.builder.create.entrys.constrain.IConstrain;
import lombok.var;

import java.util.Map;
import java.util.Set;

public class CreateBuilderSQL implements IBuilderSQL {

    private final String PREFIX = "CREATE TABLE ";
    private String tableName;
    private CreateType createType;
    private Map<String, DataTypeEntry> columns;
    private Set<IConstrain> constraintsSet;
    private MetadataEntry[] metadatas;

    public CreateBuilderSQL(String tableName) {
        this.tableName = tableName;
        this.createType = CreateType.CREATE;
    }

    public CreateBuilderSQL(String tableName, CreateType createType) {
        this.tableName = tableName;
        this.createType = createType;
    }

    public CreateBuilderSQL column(String name, DataTypeEntry typeEntry) {
        if (this.columns.containsKey(name)) {
            throw new RuntimeException(name + " column already exists");
        }
        this.columns.put(name, typeEntry);
        return this;
    }

    public CreateBuilderSQL constraints(IConstrain... constraintsSet) {
        this.constraintsSet = Sets.newHashSet(constraintsSet);
        return this;
    }

    public CreateBuilderSQL metadatas(MetadataEntry... metadatas) {
        this.metadatas = metadatas;
        return this;
    }

    @Override
    public String toSQL() {
        var sqlBuilder = new StringBuilder(this.PREFIX);
        sqlBuilder
            .append(this.createType.toString()).append(" ")
            .append(this.tableName)
            .append("(");

        Set<Map.Entry<String, DataTypeEntry>> entrySet = this.columns.entrySet();
        int i = 0;
        int size = entrySet.size();
        for (Map.Entry<String, DataTypeEntry> entry : entrySet) {
            sqlBuilder.append(
                new ColumnBuilderSQL(entry.getKey(), entry.getValue(), this.constraintsSet).toSQL()
            );
            if (i != size - 1) {
                sqlBuilder.append(", ");
            }
            i++;
        }
        sqlBuilder.append(") ");
        for (int j = 0; j < this.metadatas.length; j++) {
            sqlBuilder.append(this.metadatas[j].toSQL());
            if(j != this.metadatas.length - 1) {
                sqlBuilder.append(" ");
            }
        }
        return sqlBuilder.toString();
    }

    public enum CreateType {
        CREATE,
        CREATE_IF_NOT_EXISTS;

        @Override
        public String toString() {
            switch (this) {
                case CREATE_IF_NOT_EXISTS:
                    return "IF NO EXISTS";
                default:
                    return "";
            }
        }
    }
}
