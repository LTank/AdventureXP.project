package com.adventure.xp.dao.repositories;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.adventure.xp.dao.DButil.DBcreate;
import com.adventure.xp.dao.DButil.DBdelete;
import com.adventure.xp.dao.DButil.DBread;
import com.adventure.xp.dao.DButil.DBupdate;
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

    private DBUtil util;

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
    public int delete(Activity a) {
        return dbd.deleteActivity(a);
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
