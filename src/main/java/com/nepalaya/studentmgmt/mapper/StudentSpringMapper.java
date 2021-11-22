package com.nepalaya.studentmgmt.mapper;

import com.nepalaya.studentmgmt.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSpringMapper implements RowMapper<Student> {
    // Object Relational Mapping
    @Override
    public Student mapRow(ResultSet resultSet, int rowNo) throws SQLException {
        return Student
                .builder()
                .id(resultSet.getLong("ID"))
                .name(resultSet.getString("NAME"))
                .address(resultSet.getString("ADDRESS"))
                .dob(resultSet.getDate("DOB"))
                .contactNo(resultSet.getString("CONTACT_NO"))
                .createdDate(resultSet.getDate("CREATED_DATE"))
                .status(resultSet.getBoolean("STATUS"))
                .build();
    }
}
