package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// This Class is for delete methods only.
@Repository
public class DBdelete {

    @Autowired
    private JdbcTemplate jdbc;

    public int deleteActivity(Activity a) {
        try {
            jdbc.update("DELETE FROM activities WHERE id='" + a.getId() + "'");
            System.out.println("Activity deleted");
            return 1; // If success
        } catch (Exception e) {
            e.printStackTrace();
        }
    return  -1; // If error
    }

    public int deleteEvent(Event event) {
        try {
            jdbc.update("DELETE FROM events WHERE id = '" + event.getId() + "'");
            return 1;
        } catch (Exception e) {
            e. printStackTrace();
        }
        return -1;
    }

}
