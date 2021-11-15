package com.nepalaya.studentmgmt.filter;

import com.nepalaya.studentmgmt.builder.ResponseBuilder;
import com.nepalaya.studentmgmt.util.JacksonUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.logging.Logger;

public class SecurityFilter implements Filter {

    private final static Logger LOGGER = Logger.getLogger(SecurityFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("The Filter is Triggered");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String basicAuth = httpServletRequest.getHeader("Authorization");

        if (!"/StudentMgmt/v2".equals(httpServletRequest.getRequestURI()) || !"/StudentMgmt/".equals(httpServletRequest.getRequestURI())) {
            if (basicAuth == null) {
                handleError(httpServletResponse, "Authorization Header is not found");
            }
            if (!basicAuth.contains("Basic ")) {
                handleError(httpServletResponse, "Authorization Header is not in correct format");
            }
            basicAuth = basicAuth.replace("Basic ", "");
            byte[] decode = Base64.getDecoder().decode(basicAuth);
            basicAuth = new String(decode);
            String[] usernamePassword = basicAuth.split(":");
            // TODO: Must be checked from the database
            if ("mnzit".equals(usernamePassword[0]) && "mnzit".equals(usernamePassword[1])) {
                chain.doFilter(request, response);
            } else {
                handleError(httpServletResponse, "Username/Password is incorrect");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    public void handleError(HttpServletResponse httpServletResponse, String error) throws IOException {
        final PrintWriter writer = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        writer.write(JacksonUtil.toJson(ResponseBuilder.failure(error)));
        writer.flush();
        httpServletResponse.sendError(401);
    }
}
