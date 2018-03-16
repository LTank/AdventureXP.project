package com.adventure.xp.dao.DButil;

import com.adventure.xp.models.Activity;
import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

// This Class is for update methods only.
@Repository
public class DBupdate {

    @Autowired
    private JdbcTemplate jdbc;

    public int updateActivity(Activity a) {
        try {
            jdbc.update("UPDATE activities SET name='" + a.getName()
                    + "', age_limit='" + a.getAgeLimit()
                    + "', price='" + a.getPrice()
                    + "', height_limit='" + a.getHeightLimit()
                    + "', max_attendants='" + a.getMaxAttendants()
                    + "', calendar_color='" + a.getCalendarColor()
                    + "', description='" + a.getDescription()
                    + "' WHERE id = "+a.getId());
            System.out.println("Updated activity");
            return 1; // If success
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1; // If error
    }

    public int updateEvent(Event e) {
        try {
            jdbc.update("UPDATE events SET url='" + e.getUrl()
                    + "', date_start='" + new Timestamp(e.getStart().getTime())
                    + "', date_end='" + new Timestamp(e.getEnd().getTime())
                    + "', title='" + e.getTitle()
                    + "', color='" + e.getColor()
                    + "', description='" + e.getDescription()
                    + "' WHERE id = "+e.getId());
            System.out.println("Updated Event");
            return 1; // If success
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return -1; // If error
    }
}
