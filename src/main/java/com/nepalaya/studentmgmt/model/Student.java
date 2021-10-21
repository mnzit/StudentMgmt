package com.nepalaya.studentmgmt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Student implements Serializable {

    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
    private String address;
    private String contactNo;
    private Date createdDate;
    private Boolean status;


    public Student(String name, Date dob, String address, String contactNo) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contactNo = contactNo;
    }

    public Student(Long id, String name, Date dob, String address, String contactNo) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contactNo = contactNo;
    }
}
