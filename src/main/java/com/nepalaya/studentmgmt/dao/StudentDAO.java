package com.nepalaya.studentmgmt.dao;

import com.nepalaya.studentmgmt.model.Student;

import java.util.List;

public interface StudentDAO extends GenericDAO<Student,Long>{

    void delete(Long id) throws Exception;
}
