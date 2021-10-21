package com.nepalaya.studentmgmt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepalaya.studentmgmt.exception.Ex;
import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;
import com.nepalaya.studentmgmt.service.impl.StudentServiceImpl;
import com.nepalaya.studentmgmt.util.DateUtil;
import com.nepalaya.studentmgmt.util.JacksonUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentController extends HttpServlet {

    private final static StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ex.caught(() -> {

                ServletInputStream inputStream = request.getInputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                Student student = objectMapper.readValue(inputStream, Student.class);
                Response studentAddResponse = studentService.add(student);

                final PrintWriter writer = response.getWriter();
                response.setContentType("application/json");
                response.setStatus(200);
                writer.write(JacksonUtil.toJson(studentAddResponse));

        });
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ex.caught(() -> {

            String[] split = request.getRequestURL().toString().split("/");

            if(split[split.length-1].matches("[1-9]\\d*")){
                Response getByIdResponse = studentService.getById(Long.parseLong(split[split.length-1]));
                final PrintWriter writer = response.getWriter();
                response.setContentType("application/json");
                response.setStatus(200);
                writer.write(JacksonUtil.toJson(getByIdResponse));
            }else {
                Response studentAllResponse = studentService.getAll();
                final PrintWriter writer = response.getWriter();
                response.setContentType("application/json");
                response.setStatus(200);
                writer.write(JacksonUtil.toJson(studentAllResponse));
            }
        });
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Ex.caught(() -> {
            String[] split = req.getRequestURL().toString().split("/");
            System.out.println(split[0]);
            ServletInputStream inputStream = req.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            Student student = objectMapper.readValue(inputStream, Student.class);
            student.setId(Long.parseLong(split[split.length - 1]));

            Response studentUpdate = studentService.update(student);
            final PrintWriter writer = response.getWriter();
            response.setContentType("application/json");
            response.setStatus(200);
            writer.write(JacksonUtil.toJson(studentUpdate));
        });
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Ex.caught(() -> {
            String[] split = req.getRequestURL().toString().split("/");
            System.out.println(split[0]);
            Response studentDelete = studentService.delete(Long.parseLong(split[split.length - 1]));
            final PrintWriter writer = response.getWriter();
            response.setContentType("application/json");
            response.setStatus(200);
            writer.write(JacksonUtil.toJson(studentDelete));
        });
    }
}
