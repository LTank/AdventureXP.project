package com.adventure.xp.dao.repositories;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.adventure.xp.dao.DButil.DBcreate;
import com.adventure.xp.dao.DButil.DBdelete;
import com.adventure.xp.dao.DButil.DBread;
import com.adventure.xp.dao.DButil.DBupdate;
import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EventRepo implements ICrudRepo<Event> {

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
    public int create(Event e) {
        return 0;
    }

    @Override
    public Event read(int id) {
        return new Event();
    }

    @Override
    public int update(Event e) {
        return 0;
    }

    @Override
    public int delete(Event e) {
        return 0;
    }

    @Override
    public ArrayList<Event> readAll() {
        return dbr.readAllEvents();
    }
}
