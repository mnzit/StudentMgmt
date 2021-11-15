package com.nepalaya.studentmgmt.controller;

import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentUIController extends Controller{

    @Inject
    private StudentService studentService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = studentService.getAll();
        // Data Setting
        if(response.getSuccess()){
            req.setAttribute("students", response.getData());
        }else{
            req.setAttribute("errorMsg", response.getMessage());
        }
        view("students",req,resp);
    }
}
