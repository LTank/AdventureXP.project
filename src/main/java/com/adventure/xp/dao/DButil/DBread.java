package com.adventure.xp.dao.DButil;

import com.adventure.xp.dao.repositories.ActivitiesRepo;
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

    public Event readEventById(int id) {
        Event event;
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM adventuredb.events WHERE id = " + id);
        while (sqlRowSet.next()) {
            event = new Event(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("url"),
                    sqlRowSet.getDate("date_start"),
                    sqlRowSet.getDate("date_end"),
                    sqlRowSet.getString("title"),
                    sqlRowSet.getString("color"),
                    sqlRowSet.getNString("description"));

            return event;

        }
        return null;
    }

    public Activity readActivity(int id) {
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM activities WHERE product_id='" + id + "'");
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

    public ArrayList<Activity> readAllActivities() {
        ArrayList<Activity> activities = new ArrayList<>();
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM activities");
        while (sqlRowSet.next()) {
            activities.add(new Activity(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getInt("age_limit"),
                    sqlRowSet.getInt("height_limit"),
                    sqlRowSet.getInt("max_attendants"),
                    sqlRowSet.getDouble("price"),
                    sqlRowSet.getString("calendar_color"),
                    sqlRowSet.getString("description")));
        }
        return activities;
    }
}
