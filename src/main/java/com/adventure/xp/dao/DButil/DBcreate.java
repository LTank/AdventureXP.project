package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
import com.adventure.xp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.adventure.xp.models.Event;
import java.sql.Timestamp;
// This Class is for create methods only.
@Repository
public class DBcreate {

    @Autowired
    private JdbcTemplate jdbc;
    
    // Creating a new user
    public int createUser (User u) {
        // Encryption of our users chosen password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // New users should always be enabled
        u.setEnabled(1);

        try {
            jdbc.update("INSERT INTO users(username, password, enabled) " +
                    "VALUES('" + u.getUsername() + "','"
                    + passwordEncoder.encode(u.getPassword()) + "','"
                    + u.getEnabled() + "')");
            jdbc.update("INSERT INTO user_roles(username, role) " +
                    "VALUES('" + u.getUsername() + "','"
                    + u.getRole() + "')");
            System.out.println("User created");
            return 1; // If success
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1; // If error
    }

    public int createActivity(Activity a) {
        try {
            jdbc.update("INSERT INTO activities(name, age_limit, price, height_limit, max_attendants, calendar_color, description) " +
                    "VALUES('" + a.getName() + "','"
                    + a.getAgeLimit() + "','"
                    + a.getPrice() + "','"
                    + a.getHeightLimit() + "','"
                    + a.getMaxAttendants() + "','"
                    + a.getCalendarColor() + "','"
                    + a.getDescription() + "')");
            System.out.println("Activity created");
            return 1; // If success
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1; // If error
    }

    public int createEvent (Event e) {
        String query = "INSERT INTO events (url, date_start, date_end, title, color, description) " +
                        "VALUES (?, ?, ?, ?, ?, ?);";

        return jdbc.update(query, new Object[] {e.getUrl(), new Timestamp(e.getStart().getTime()), new Timestamp(e.getEnd().getTime()), e.getTitle(), e.getColor(), e.getDescription()});
    }





}
