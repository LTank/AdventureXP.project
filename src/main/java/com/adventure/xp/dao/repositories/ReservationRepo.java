package com.adventure.xp.dao.repositories;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.adventure.xp.dao.DButil.DBcreate;
import com.adventure.xp.dao.DButil.DBdelete;
import com.adventure.xp.dao.DButil.DBread;
import com.adventure.xp.dao.DButil.DBupdate;

import java.util.ArrayList;

public class ReservationRepo implements ICrudRepo {

    private DBcreate dbc;
    private DBread dbr;
    private DBupdate dbu;
    private DBdelete dbd;
    private DBUtil util;

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
}