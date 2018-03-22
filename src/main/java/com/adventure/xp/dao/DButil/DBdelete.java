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

    public int deleteActivity(int id) {
        try {
            jdbc.update("DELETE FROM activities WHERE id='" + id + "'");
            System.out.println("Activity deleted");
            return 1; // If success
        } catch (Exception e) {
            e.printStackTrace();
        }
    return  -1; // If error
    }

    public int deleteEvent(int id) {
        try {
            jdbc.update("DELETE FROM events WHERE id = '" + id + "'");
            return 1;
        } catch (Exception e) {
            e. printStackTrace();
        }
        return -1;
    }

}
