package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// This Class is for utility methods only.
@Repository
public class Util {

    @Autowired
    private JdbcTemplate jdbc;
    private SqlRowSet sqlRowSet;

    public int readLastInsertID() {
        sqlRowSet = jdbc.queryForRowSet("SELECT id FROM activities WHERE LAST_INSERT_ID()");
        int id = 0;
        while (sqlRowSet.next()) {
            id = sqlRowSet.getInt("id");
        }
        return id;
    }
}
