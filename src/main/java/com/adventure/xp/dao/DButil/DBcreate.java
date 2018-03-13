package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

// This Class is for create methods only.
@Repository
public class DBcreate {

    @Autowired
    private JdbcTemplate jdbc;


    //example of a create method.
    public int createUser (Object o) {
        return 0;
    }

    public int createEvent (Event e) {
        String query = "INSERT INTO events (url, date_start, date_end, title, color, description) " +
                        "VALUES (?, ?, ?, ?, ?, ?);";

        return jdbc.update(query, new Object[] {e.getUrl(), new Timestamp(e.getStart().getTime()), new Timestamp(e.getEnd().getTime()), e.getTitle(), e.getColor(), e.getDescription()});
    }





}
