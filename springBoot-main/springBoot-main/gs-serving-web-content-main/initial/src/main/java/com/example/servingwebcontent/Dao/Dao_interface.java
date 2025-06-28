package com.example.servingwebcontent.Dao;

import java.util.ArrayList;

public interface Dao_interface<T> {
    public int insert(T t);

    public int update(T t);

    public int delete(String id);

    public ArrayList<T> selectAll();

    public T selectById(String id);

    public ArrayList<T> selectByCondition(String condition);
}
