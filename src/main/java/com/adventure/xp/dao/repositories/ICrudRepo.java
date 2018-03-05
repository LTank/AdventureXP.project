package com.adventure.xp.dao.repositories;

import java.util.ArrayList;

public interface ICrudRepo<T> {

    public int create (T t);

    public int read (int id);

    public int update (T t);

    public int delete (T t);

    public ArrayList<T> readAll();

}
