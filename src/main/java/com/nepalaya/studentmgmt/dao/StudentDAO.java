package com.nepalaya.studentmgmt.dao;

import com.nepalaya.studentmgmt.model.Student;

public interface StudentDAO extends GenericDAO<Student,Long>{

    void delete(Long id) throws Exception;
}
