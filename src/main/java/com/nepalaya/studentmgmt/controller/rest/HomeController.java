package com.nepalaya.studentmgmt.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController(value = "homeRestController")
@RequestMapping("rest/home")
public class HomeController {

    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> home() {
       Map<String, String> status = new HashMap<>();
       status.put("health","OK");
       status.put("currentRefreshTime", new Date().toString());
       return status;
    }
}
