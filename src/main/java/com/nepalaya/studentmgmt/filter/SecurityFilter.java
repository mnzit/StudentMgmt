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

        if(!"/StudentMgmt/".equals(httpServletRequest.getRequestURI())){
            if(basicAuth == null){
                final PrintWriter writer = httpServletResponse.getWriter();
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(401);
                writer.write(JacksonUtil.toJson(ResponseBuilder.failure("Authorization header not found")));
            }
            LOGGER.info(basicAuth);
            basicAuth = basicAuth.replace("Basic ","");
            LOGGER.info(basicAuth);
            byte[] decode = Base64.getDecoder().decode(basicAuth);
            LOGGER.info("bytes"+ decode);
            basicAuth = new String(decode);
            LOGGER.info(basicAuth);
            String[] usernamePassword = basicAuth.split(":");
            LOGGER.info(usernamePassword[0]+":"+usernamePassword[1]);
            if (usernamePassword[0].equals("mnzit") && usernamePassword[1].equals("mnzit")) {
                chain.doFilter(request, response);
            } else {
                final PrintWriter writer = httpServletResponse.getWriter();
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(401);
                writer.write(JacksonUtil.toJson(ResponseBuilder.failure("Username/Password is incorrect")));
            }
        }else{
            chain.doFilter(request, response);
        }
    }
}
