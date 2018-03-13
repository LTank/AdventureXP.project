package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
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

}
