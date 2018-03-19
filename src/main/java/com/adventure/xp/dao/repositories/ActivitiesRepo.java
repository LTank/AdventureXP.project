package com.adventure.xp.dao.repositories;

import com.adventure.xp.dao.DButil.*;
import com.adventure.xp.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActivitiesRepo implements ICrudRepo<Activity> {

    @Autowired
    private DBcreate dbc;

    @Autowired
    private DBread dbr;

    @Autowired
    private DBupdate dbu;

    @Autowired
    private DBdelete dbd;

    @Autowired
    private Util util;

    @Override
    public int create(Activity a) {
        return dbc.createActivity(a);
    }

    @Override
    public Activity read(int id) {
        return dbr.readActivity(id);
    }

    @Override
    public int update(Activity a) {
        return dbu.updateActivity(a);
    }

    @Override
    public int delete(int id) {
        return dbd.deleteActivity(id);
    }

    @Override
    public ArrayList<Activity> readAll() {
        return dbr.readAllActivities();
    }


    public String getColorByTitle(String title){

        return util.getColorByActivity(title);
    }

    public String getDescriptionByTitle(String title) {

        return util.getDescriptionByTitle(title);
    }
}
