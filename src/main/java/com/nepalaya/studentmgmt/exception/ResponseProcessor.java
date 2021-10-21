package com.nepalaya.studentmgmt.exception;

import com.nepalaya.studentmgmt.builder.ResponseBuilder;
import com.nepalaya.studentmgmt.response.Response;
import com.nepalaya.studentmgmt.util.LogUtil;

public class ResponseProcessor {

    public static Response process(ExceptionDataWrapper exceptionDataWrapper){
        try{
            return exceptionDataWrapper.handle();
        }catch (Exception ex){
            LogUtil.exception(ex);
            return ResponseBuilder.failure(ex.getMessage());
        }
    }
}
