package com.adventure.xp.dao.repositories;

import com.adventure.xp.dao.DButil.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActivitiesRepo implements ICrudRepo {

    private DBcreate dbc;
    private DBread dbr;
    private DBupdate dbu;
    private DBdelete dbd;
    private Util util = new Util();

    @Override
    public int create(Object o) {
        return 0;
    }

    @Override
    public int read(int id) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public ArrayList readAll() {
        return null;
    }


    public String getColorByTitle(String title){

        return util.getColorByActivity(title);
    }

    public String getDescriptionByTitle(String title) {

        return util.getDescriptionByTitle(title);
    }
}
