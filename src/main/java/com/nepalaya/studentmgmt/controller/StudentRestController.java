package com.nepalaya.studentmgmt.controller;

import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/students")
public class StudentRestController {

    public final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response create(Student student){
        return studentService.add(student);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response students(){
        return studentService.getAll();
    }

    @GetMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response student(@PathVariable("id") Long id){
        return studentService.getById(id);
    }
}
