package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// This Class is for read methods only.
@Repository
public class DBread {

    @Autowired
    private JdbcTemplate jdbc;
    private SqlRowSet sqlRowSet;

    public ArrayList<Event> readAllEvents() {
        ArrayList<Event> events = new ArrayList<>();
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM events");
        while (sqlRowSet.next()) {
            events.add(new Event(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("url"),
                    sqlRowSet.getDate("date_start"),
                    sqlRowSet.getDate("date_end"),
                    sqlRowSet.getString("title"),
                    sqlRowSet.getString("color"),
                    sqlRowSet.getString("description")));
        }
        return events;
    }
}
