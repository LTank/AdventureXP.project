package com.adventure.xp.dao.DButil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// This Class is for utility methods only.
public class Util {

    @Autowired
    private JdbcTemplate jdbc;


    public String getColorByActivity(String activityName){

        // Basic SQL SELECT statement
        String query = "SELECT color FROM events WHERE title=?";

        // Query for Object (String)
        String color = jdbc.queryForObject(query, new Object[] {activityName}, String.class);

        return color;


    }


    public String getDescriptionByTitle(String title) {
        // Basic SQL SELECT statement
        String query = "SELECT description FROM events WHERE title=?";

        // Query for Object (String)
        String description = jdbc.queryForObject(query, new Object[] {title}, String.class);

        return description;
    }


}
