package com.nepalaya.studentmgmt.service.impl;

import com.nepalaya.studentmgmt.builder.ResponseBuilder;
import com.nepalaya.studentmgmt.dao.StudentDAO;
import com.nepalaya.studentmgmt.dao.impl.StudentDAODatabaseImpl;
import com.nepalaya.studentmgmt.dao.impl.StudentDAOHibernateImpl;
import com.nepalaya.studentmgmt.exception.ResponseProcessor;
import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO = new StudentDAOHibernateImpl();

    @Override
    public Response add(Student student) {
        return ResponseProcessor
                .process(() -> {
                            studentDAO.add(student);
                            return ResponseBuilder.success("Student Added Successfully !");
                        }
                );
    }

    @Override
    public Response update(Student student) {
        return ResponseProcessor
                .process(() -> {
                            studentDAO.update(student);
                            return ResponseBuilder.success("Student Updated Successfully !");
                        }
                );
    }

    @Override
    public Response delete(Long id) {
        return ResponseProcessor
                .process(() -> {
                    studentDAO.delete(id);
                    return ResponseBuilder.success("Student's Deleted Successfully !");
                });
    }

    @Override
    public Response getAll() {
        return ResponseProcessor
                .process(() -> ResponseBuilder.success("Student's Fetched Successfully !", studentDAO.getAll()));
    }

    @Override
    public Response getById(Long id) {
        return ResponseProcessor
                .process(() -> ResponseBuilder.success("Student Fetched Successfully !", studentDAO.getById(id)));
    }
}
