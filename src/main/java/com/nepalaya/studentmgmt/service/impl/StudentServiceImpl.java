package com.nepalaya.studentmgmt.service.impl;

import com.nepalaya.studentmgmt.builder.ResponseBuilder;
import com.nepalaya.studentmgmt.dao.StudentDAO;
import com.nepalaya.studentmgmt.dao.impl.StudentDAOImpl;
import com.nepalaya.studentmgmt.exception.ResponseProcessor;
import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO = new StudentDAOImpl();

    public StudentServiceImpl(){
        System.out.println("StudentServiceImpl: "+this);
    }

    @Override
    public Response add(Student student) {
        return ResponseProcessor
                .process(() -> {
                            studentDAO.save(student);
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
        System.out.println(studentDAO);
        return ResponseProcessor
                .process(() -> ResponseBuilder.success("Student's Fetched Successfully !", studentDAO.getAll()));
    }

    @Override
    public Response getById(Long id) {
        return ResponseProcessor
                .process(() -> ResponseBuilder.success("Student Fetched Successfully !", studentDAO.getOneById(id)));
    }
}
