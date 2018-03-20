package com.adventure.xp.dao.repositories;


import com.adventure.xp.dao.DButil.*;
import com.adventure.xp.models.Activity;
import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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

    @Autowired
    private Util util;




    @Override
    public int create(Event e) {
        return dbc.createEvent(e);
    }

    @Override
    public Event read(int id) {
        return dbr.readEvent(id);
    }

    @Override
    public int update(Event e) {
        return dbu.updateEventById(e);
    }

    @Override
    public int delete(int id) {
        return dbd.deleteEvent(id);
    }

    @Override
    public ArrayList<Event> readAll() {

        return dbr.readAllEvents();
    }

    public int readLastCreatedEventId() {
        return dbr.readLastCreatedEventId();
    }
}
