package com.nepalaya.studentmgmt.service;

import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.response.Response;

public interface StudentService {

    Response add(Student student); // CREATE

    Response update(Student student); // UPDATE

    Response delete(Long id); // DELETE

    Response getAll(); // READ

    Response getById(Long id); // READ
}
