package com.adventure.xp.dao.repositories;


import com.adventure.xp.dao.DButil.*;
import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EventRepo implements ICrudRepo<Event> {

    private DBcreate dbc;
    private DBread dbr;
    private DBupdate dbu;
    private DBdelete dbd;
    private Util util;

    @Override
    public int create(Event e) {
        return dbc.createEvent(e);
    }

    @Override
    public int read(int id) {
        return 0;
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
