package com.nepalaya.studentmgmt.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) throws Exception {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
