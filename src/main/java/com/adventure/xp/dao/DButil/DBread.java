package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// This Class is for read methods only.
@Repository
public class DBread {

    private JdbcTemplate jdbc;

    private SqlRowSet sqlRowSet;

    @Autowired
    public DBread(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        System.out.println("Hej Anders");
    }

    public Event readEvent(int id){
        Event event;
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM events WHERE id = " + id);
        if(sqlRowSet.next()){
            event = new Event(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("url")+"?id="+sqlRowSet.getInt("id"),
                    sqlRowSet.getTimestamp("date_start"),
                    sqlRowSet.getTimestamp("date_end"),
                    sqlRowSet.getString("title"),
                    sqlRowSet.getString("color"),
                    sqlRowSet.getString("description"));
            return event;
        }
        return null;
    }

    public ArrayList<Event> readAllEvents() {
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM events");
        ArrayList<Event> events = new ArrayList<>();
        while (sqlRowSet.next()) {
            events.add(new Event(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("url")+"?id="+sqlRowSet.getInt("id"),
                    sqlRowSet.getTimestamp("date_start"),
                    sqlRowSet.getTimestamp("date_end"),
                    sqlRowSet.getString("title"),
                    sqlRowSet.getString("color"),
                    sqlRowSet.getString("description")));
        }
        return events;
    }

    public ArrayList<Activity> readAllActivities() {
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM activities");
        ArrayList<Activity> activites = new ArrayList<>();
        while(sqlRowSet.next()) {
            activites.add(new Activity(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getInt("age_limit"),
                    sqlRowSet.getInt("height_limit"),
                    sqlRowSet.getInt("max_attendants"),
                    sqlRowSet.getDouble("price"),
                    sqlRowSet.getString("calendar_color"),
                    sqlRowSet.getString("description")
            ));
        }
        return activites;
    }
}
