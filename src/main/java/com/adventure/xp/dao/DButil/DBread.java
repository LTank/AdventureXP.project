package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
import com.adventure.xp.models.Event;
import com.adventure.xp.models.User;
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

    private Util util = new Util(jdbc);

    @Autowired
    public DBread(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public Event readEvent(int id){
        SqlRowSet sqlRowSet;
        Event event;
        Activity activity = getActivityByEventId(id);
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM events WHERE id = " + id);

        if(sqlRowSet.next()){
            event = new Event(
                    sqlRowSet.getInt("id"),
                    "/event?id=" + sqlRowSet.getInt("id"),
                    sqlRowSet.getTimestamp("date_start"),
                    sqlRowSet.getTimestamp("date_end"),
                    sqlRowSet.getString("description"),
                    sqlRowSet.getInt("number_of_customers"),
                    sqlRowSet.getString("customer_name"),
                    activity.getName(),
                    activity.getCalendarColor()
                    );
            return event;
        }
        return null;
    }

    public ArrayList<Event> readAllEvents() {
        SqlRowSet sqlRowSet;
        ArrayList<Event> events = new ArrayList<>();
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM events");
        while (sqlRowSet.next()) {
            Activity activity = getActivityByEventId(sqlRowSet.getInt("id"));

            events.add(new Event(
                    sqlRowSet.getInt("id"),
                    "/event?id=" + sqlRowSet.getInt("id"),
                    sqlRowSet.getTimestamp("date_start"),
                    sqlRowSet.getTimestamp("date_end"),
                    sqlRowSet.getString("description"),
                    sqlRowSet.getInt("number_of_customers"),
                    sqlRowSet.getString("customer_name"),
                    activity.getName(),
                    activity.getCalendarColor()));
        }
        return events;
    }


    public Activity readActivity(int id) {
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM activities WHERE id='" + id + "'");
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

    public User readUser(int id) {
        sqlRowSet = jdbc.queryForRowSet("SELECT users.id, users.username, users.password, user_roles.role, users.enabled, users.profile_image " +
                "FROM users " +
                "INNER JOIN user_roles " +
                "ON users.username = user_roles.username " +
                "WHERE id ='" + id + "'");
        while (sqlRowSet.next()) {
            return new User(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("username"),
                    sqlRowSet.getString("password"),
                    sqlRowSet.getString("role"),
                    sqlRowSet.getInt("enabled"),
                    sqlRowSet.getString("profile_image"));
        }
        return new User();
    }

    public ArrayList<User> readAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        sqlRowSet = jdbc.queryForRowSet("SELECT users.id, users.username, users.password, user_roles.role, users.enabled, users.profile_image " +
                "FROM users " +
                "INNER JOIN user_roles " +
                "ON users.username = user_roles.username");
        while (sqlRowSet.next()) {
            users.add(new User(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("username"),
                    sqlRowSet.getString("password"),
                    sqlRowSet.getString("role"),
                    sqlRowSet.getInt("enabled"),
                    sqlRowSet.getString("profile_image")));
        }
        return users;
    }


    public Event readLastCreatedEvent(){
        sqlRowSet = jdbc.queryForRowSet("select last_insert_id() as last_id from events");
        sqlRowSet.first();
        int lastId = sqlRowSet.getInt("last_id");
        return readEvent(lastId);
    }

    public int readLastCreatedEventId(){
        sqlRowSet = jdbc.queryForRowSet("select last_insert_id() as last_id from events");
        sqlRowSet.first();
        int lastId = sqlRowSet.getInt("last_id");
        return lastId;
    }

    public int getActivityIdByEventId (int eventId){
        String query = "SELECT * FROM event_activity_con WHERE event_id=" + "'" +eventId+"'";

        sqlRowSet = jdbc.queryForRowSet(query);


        sqlRowSet.first();
        int temp = sqlRowSet.getInt("activity_id");
        return temp;
    }

    public Activity getActivityByEventId(int eventId) {
        return readActivity(getActivityIdByEventId(eventId));
    }
}
