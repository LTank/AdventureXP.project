package com.adventure.xp.dao.repositories;

import com.adventure.xp.dao.DButil.*;
import com.adventure.xp.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActivitiesRepo implements ICrudRepo<Activity> {

    private DBcreate dbc;
    @Autowired
    private DBread dbr;
    private DBupdate dbu;
    private DBdelete dbd;
    @Autowired
    private Util util;

    @Override
    public int create(Activity o) {
        return 0;
    }

    @Override
    public Activity read(int id) {
        return null;
    }

    @Override
    public int update(Activity o) {
        return 0;
    }

    @Override
    public int delete(Activity o) {
        return 0;
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
