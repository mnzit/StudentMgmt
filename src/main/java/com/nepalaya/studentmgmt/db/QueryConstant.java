package com.nepalaya.studentmgmt.db;

public interface QueryConstant {

    interface Student {
        String CREATE = "INSERT INTO STUDENTS(NAME,ADDRESS,DOB,CONTACT_NO) VALUES(?,?,?,?)";
        String UPDATE = "UPDATE STUDENTS SET NAME=?,DOB=?,ADDRESS=?,CONTACT_NO=? WHERE ID=?";
        String DELETE = "UPDATE STUDENTS SET STATUS = FALSE WHERE ID = ?";
        String GET_ALL = "SELECT * FROM STUDENTS WHERE STATUS = TRUE";
        String GET_BY_ID = "SELECT * FROM STUDENTS WHERE ID = ? AND STATUS = TRUE";
    }

    interface Employee {

    }
}
