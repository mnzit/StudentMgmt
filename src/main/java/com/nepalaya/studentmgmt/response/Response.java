package com.nepalaya.studentmgmt.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class Response implements Serializable {

    private Boolean success;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

}
