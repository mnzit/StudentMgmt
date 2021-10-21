package com.nepalaya.studentmgmt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;
import com.nepalaya.studentmgmt.service.impl.StudentServiceImpl;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentController extends Controller {

    private final static StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(inputStream, Student.class);
        Response responseBody = studentService.add(student);
        buildResponse(response, responseBody);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] split = request.getRequestURL().toString().split("/");
        if (split[split.length - 1].matches("[1-9]\\d*")) {
            Response responseBody = studentService.getById(Long.parseLong(split[split.length - 1]));
            buildResponse(response, responseBody);
        } else {
            Response responseBody = studentService.getAll();
            buildResponse(response, responseBody);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String[] split = req.getRequestURL().toString().split("/");
        ServletInputStream inputStream = req.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(inputStream, Student.class);
        student.setId(Long.parseLong(split[split.length - 1]));
        Response responseBody = studentService.update(student);
        buildResponse(response, responseBody);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String[] split = req.getRequestURL().toString().split("/");
        System.out.println(split[0]);
        Response responseBody = studentService.delete(Long.parseLong(split[split.length - 1]));
        buildResponse(response, responseBody);
    }
}
