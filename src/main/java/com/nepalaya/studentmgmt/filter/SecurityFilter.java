package com.nepalaya.studentmgmt.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class SecurityFilter implements Filter {

    private final static Logger LOGGER = Logger.getLogger(SecurityFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Security Filter is Triggered");
        chain.doFilter(request,response);
    }
}
