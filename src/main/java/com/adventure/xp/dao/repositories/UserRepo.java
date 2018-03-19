package com.adventure.xp.dao.repositories;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.adventure.xp.dao.DButil.DBcreate;
import com.adventure.xp.dao.DButil.DBdelete;
import com.adventure.xp.dao.DButil.DBread;
import com.adventure.xp.dao.DButil.DBupdate;
import com.adventure.xp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepo implements ICrudRepo<User>{


    @Autowired
    private DBcreate dbc;

    @Autowired
    private DBread dbr;

    @Autowired
    private DBupdate dbu;

    @Autowired
    private DBdelete dbd;

    private DBUtil util;


    // This is the method used in dao. Refer to the specific "DB" class and put logic ind there. NOT HERE!
    @Override
    public int create (User u) {
        return dbc.createUser(u);
    }

    @Override
    public User read (int id) {
        return dbr.readUser(id);
    }

    @Override
    public int update(User u) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public ArrayList readAll() {
        return dbr.readAllUsers();
    }
}
