package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
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

    public Activity getActivityByEventId(int eventId) {
        DBread dbr = new DBread(jdbc);
        return dbr.readActivity(getActivityIdByEventId(eventId));
    }

    public int getActivityIdByEventId (int eventId){
        String query = "SELECT activity_id FROM event_activity_con WHERE event_id=" + eventId;

        Integer activityId = jdbc.queryForObject(query, Integer.class);

        return activityId;
    }

}
