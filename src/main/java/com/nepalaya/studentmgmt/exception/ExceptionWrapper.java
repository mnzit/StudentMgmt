package com.nepalaya.studentmgmt.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void handle() throws Exception;
}
