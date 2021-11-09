package com.nepalaya.studentmgmt.provider;

import com.nepalaya.studentmgmt.builder.ResponseBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Provider
public class ValidationProvider implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {

        List<String> failures = e.getConstraintViolations()
                .stream()
                .map(v -> "Invalid tag " + v.getPropertyPath() + ": " + v.getMessage())
                .collect(Collectors.toList());

        com.nepalaya.studentmgmt.response.Response finalResponse = ResponseBuilder.failure("Invalid Request Parameters", failures);

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(finalResponse)
                .build();
    }
}
