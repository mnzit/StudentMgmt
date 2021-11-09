package com.nepalaya.studentmgmt.controller;

import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.service.StudentService;
import com.nepalaya.studentmgmt.service.impl.StudentServiceImpl;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("students")
public class StudentV2Controller {

    @Inject
    private StudentService studentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response students(){
        System.out.println(studentService);
        return Response
                .status(Response.Status.OK)
                .entity(studentService.getAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(@Valid Student student){
        return Response
                .ok(studentService.add(student))
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response student(@PathParam("id") Long id){
        return Response
                .status(Response.Status.OK)
                .entity(studentService.getById(id))
                .build();
    }

    //PUT
    //DELETE
}
