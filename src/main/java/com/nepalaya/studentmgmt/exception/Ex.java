package com.nepalaya.studentmgmt.exception;

import com.nepalaya.studentmgmt.util.LogUtil;

public class Ex {

    public static void caught(ExceptionWrapper wrapper) {
        try {
            wrapper.handle();
        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
    }
}
