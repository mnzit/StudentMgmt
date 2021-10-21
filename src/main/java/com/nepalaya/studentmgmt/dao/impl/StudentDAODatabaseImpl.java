package com.nepalaya.studentmgmt.dao.impl;

import com.nepalaya.studentmgmt.dao.StudentDAO;
import com.nepalaya.studentmgmt.db.JdbcTemplate;
import com.nepalaya.studentmgmt.db.QueryConstant;
import com.nepalaya.studentmgmt.mapper.StudentMapper;
import com.nepalaya.studentmgmt.model.Student;
import com.nepalaya.studentmgmt.util.DateUtil;

import java.util.List;
import java.util.Optional;

public class StudentDAODatabaseImpl implements StudentDAO {

    private final JdbcTemplate<Student> jdbcTemplate = new JdbcTemplate<>();

    // CREATE
    @Override
    public boolean add(Student student) throws Exception {
        int rowAffected = jdbcTemplate.update(
                QueryConstant.Student.CREATE,
                new Object[]{
                        student.getName(),
                        student.getAddress(),
                        DateUtil.convertJavaDateToSQLDate(student.getDob()),
                        student.getContactNo()
                });

        if (rowAffected > 0) {
            return true;
        } else {
            throw new RuntimeException("Adding Student Failed");
        }
    }

    // UPDATE
    @Override
    public boolean update(Student student) throws Exception {
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
            return true;
        } else {
            throw new RuntimeException("Updating Student Failed");
        }
    }

    // DELETE
    @Override
    public boolean delete(Long id) throws Exception {
        int rowAffected = jdbcTemplate.update(QueryConstant.Student.DELETE, new Object[]{id});
        if (rowAffected > 0) {
            return true;
        } else {
            throw new RuntimeException("Deleting Student Failed");
        }
    }

    // READ
    @Override
    public List<Student> getAll() throws Exception {
        List<Student> students = jdbcTemplate.getAll(QueryConstant.Student.GET_ALL, new StudentMapper());
        if (students == null || students.isEmpty()) {
            throw new RuntimeException("Students not found");
        } else {
            return students;
        }
    }

    // READ
    @Override
    public Student getById(Long id) throws Exception {
        Optional<Student> optionalStudent = jdbcTemplate
                .getOneByObject(
                        QueryConstant.Student.GET_BY_ID,
                        new Object[]{id},
                        new StudentMapper()
                );
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new RuntimeException("Student with id=[" + id + "] is not found in our system");
        }
    }
}
