package com.nepalaya.studentmgmt.dao.impl;


import com.nepalaya.studentmgmt.dao.StudentDAO;
import com.nepalaya.studentmgmt.db.QueryConstant;
import com.nepalaya.studentmgmt.mapper.StudentSpringMapper;
import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.util.DateUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("springJdbcTemplate")
public class StudentSpringJdbcTemplate implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public StudentSpringJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Student student) throws Exception {
        int rowAffected = jdbcTemplate.update(
                QueryConstant.Student.CREATE,
                new Object[]{
                        student.getName(),
                        student.getAddress(),
                        DateUtil.convertJavaDateToSQLDate(student.getDob()),
                        student.getContactNo()
                });

        if (rowAffected > 0) {
        } else {
            throw new RuntimeException("Adding Student Failed");
        }
    }

    @Override
    public void update(Student student) throws Exception {
        int rowAffected = jdbcTemplate.update(
                QueryConstant.Student.UPDATE,
                new Object[]{
                        student.getName(),
                        student.getDob(),
                        student.getAddress(),
                        student.getContactNo(),
                        student.getId()
                });
        if (rowAffected > 0) {
        } else {
            throw new RuntimeException("Updating Student Failed");
        }
    }

    @Override
    public List<Student> getAll() throws Exception {
        List<Student> students = jdbcTemplate.query(QueryConstant.Student.GET_ALL, new StudentSpringMapper());
        if (students == null || students.isEmpty()) {
            throw new RuntimeException("Students not found");
        } else {
            return students;
        }
    }

    @Override
    public Student getOneById(Long id) throws Exception {
        Student student = jdbcTemplate
                .queryForObject(
                        QueryConstant.Student.GET_BY_ID,
                        new StudentSpringMapper(),
                        new Object[]{id}
                );
        if (student != null) {
            return student;
        } else {
            throw new RuntimeException("Student with id=[" + id + "] is not found in our system");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        int rowAffected = jdbcTemplate.update(QueryConstant.Student.DELETE, new Object[]{id});
        if (rowAffected > 0) {

        } else {
            throw new RuntimeException("Deleting Student Failed");
        }
    }

}
