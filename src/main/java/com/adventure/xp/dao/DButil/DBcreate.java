package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import com.adventure.xp.models.Event;
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
