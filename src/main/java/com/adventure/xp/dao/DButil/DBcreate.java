package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// This Class is for create methods only.
public class DBcreate {

    @Autowired
    private JdbcTemplate jdbc;


    //example of a create method.
    public int createUser (Object o) {
        return 0;
    }

    public int createEvent (Event e) {
        String query = "INSERT INTO events (id, url, date_start, date_end, title, color, description) " +
                        "VALUES (" + e.getId() + ", " + e.getUrl() + ", " + e.getStart() + ", " + e.getEnd() +
                        ", " + e.getTitle() + ", " + e.getColor() + ", " + e.getDescription() + ");";


        return jdbc.update(query);
    }





}
