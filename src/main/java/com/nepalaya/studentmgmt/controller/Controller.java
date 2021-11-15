package com.nepalaya.studentmgmt.controller;

import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.util.JacksonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Controller extends HttpServlet {

    private static final String PREFIX = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";

    public void buildResponse(HttpServletResponse response, Response responseBody) throws IOException {
        final PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setStatus(200);
        writer.write(JacksonUtil.toJson(responseBody));
    }


    protected void view(String page, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request
                .getRequestDispatcher(PREFIX + page + SUFFIX)
                .forward(request, response);
    }
}
