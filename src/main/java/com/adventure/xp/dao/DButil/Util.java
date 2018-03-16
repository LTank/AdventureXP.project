package com.adventure.xp.dao.DButil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// This Class is for utility methods only.
@Repository
public class Util {

    @Autowired
    private JdbcTemplate jdbc;


    public String getColorByActivity(String activityName){

        // Basic SQL SELECT statement
        String query = "SELECT calendar_color FROM activities WHERE name=?";

        // Query for Object (String)
         String color = jdbc.queryForObject(query, new Object[] {activityName}, String.class);

        return color;


    }


    public String getDescriptionByTitle(String title) {
        // Basic SQL SELECT statement
        String query = "SELECT description FROM activities WHERE name=?";

        // Query for Object (String)
        String description = jdbc.queryForObject(query, new Object[] {title}, String.class);

        return description;
    }


}
