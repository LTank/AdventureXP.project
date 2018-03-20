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


    private JdbcTemplate jdbc;

    private SqlRowSet sqlRowSet;

    @Autowired
    public Util(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }


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



    public Activity getActivityByName(String name){
        String query = "SELECT * FROM activities WHERE name=?";

        sqlRowSet = jdbc.queryForRowSet(query, new Object[] {name});
        while (sqlRowSet.next()) {
            return new Activity(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getInt("age_limit"),
                    sqlRowSet.getInt("height_limit"),
                    sqlRowSet.getInt("max_attendants"),
                    sqlRowSet.getDouble("price"),
                    sqlRowSet.getString("calendar_color"),
                    sqlRowSet.getString("description"));
        }
        return new Activity();
    }



    public int addEventActivityJoin (int eventId, Activity activity){
        String query = "INSERT into event_activity_con (event_id, activity_id) VALUES (?, ?)";

        return jdbc.update(query, new Object[] {eventId, activity.getId()});
    }

}
