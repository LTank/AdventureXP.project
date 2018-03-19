package com.adventure.xp.dao.repositories;

import java.util.ArrayList;

public interface ICrudRepo<T> {

    public int create (T t);

    public T read (int id);

    public int update (T t);

    public int delete (int id);

    public ArrayList<T> readAll();

}
