package io.github.mainyf.sqlbuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreparedWrap {

    private PreparedStatement prepared;
    private Map<String, Object> values;

    public void setup() {

    }

}
