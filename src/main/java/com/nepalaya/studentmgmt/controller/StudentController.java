package com.nepalaya.studentmgmt.controller;

import com.nepalaya.studentmgmt.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("students")
public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ModelAndView students(Model model) {
        model.addAttribute("students", studentService.getAll().getData());
        return new ModelAndView("students");
    }

}
