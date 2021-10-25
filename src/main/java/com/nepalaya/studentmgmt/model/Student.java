package com.nepalaya.studentmgmt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
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
    @NotBlank
    @Size(min = 2, max=150)
    private String name;
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
    @NotBlank
    @Size(min = 2, max=200)
    private String address;
    @NotBlank
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
