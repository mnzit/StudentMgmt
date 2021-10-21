package com.nepalaya.studentmgmt.exception;

import com.nepalaya.studentmgmt.response.Response;

@FunctionalInterface
public interface ExceptionDataWrapper {
    Response handle() throws Exception;
}
