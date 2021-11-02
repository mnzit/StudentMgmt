package com.nepalaya.studentmgmt.dao;

import java.util.List;

public interface GenericDAO<T,ID> {

    void save(T object) throws Exception;

    void update(T object) throws Exception;

    List<T> getAll() throws Exception;

    T getOneById(ID id) throws Exception;
}
