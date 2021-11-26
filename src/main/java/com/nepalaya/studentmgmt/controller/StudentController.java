package com.nepalaya.studentmgmt.controller;

import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("students")
public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String students(Model model) {
        Response response = studentService.getAll();
        model.addAttribute("students", response.getData());
        model.addAttribute("message", response.getMessage());
        model.addAttribute("status", response.getSuccess());
        return "students/index";
    }

    @GetMapping("create")
    public String showAddStudentsPage(Student student) {
        return "students/create";
    }

    @PostMapping("create")
    public String students(Model model, @Valid Student student) {
        student.setDob(new Date());
        Response response = studentService.add(student);
        model.addAttribute("message", response.getMessage());
        model.addAttribute("status", response.getSuccess());
        return "redirect:/students";
    }
}
