package com.nepalaya.studentmgmt.dao.impl;

import com.nepalaya.studentmgmt.dao.StudentDAO;
import com.nepalaya.studentmgmt.model.Student;

import java.util.List;

public class StudentDAOImpl extends GenericDAOImpl<Student, Long> implements StudentDAO {

    @Override
    public void delete(Long id) throws Exception {
        Student student = getOneById(id);
        student.setStatus(false);
        super.update(student);
    }

    @Override
    public Student getOneById(Long id) throws Exception {
        return super.getOneById(
                (criteriaBuilder, criteriaQuery, root) -> {
                    criteriaQuery.where(
                            criteriaBuilder.and(
                                    criteriaBuilder.equal(root.get("id"),id),
                                    criteriaBuilder.equal(root.get("status"),true)
                            )
                    );
                }
        );
    }

    @Override
    public List<Student> getAll() throws Exception {
        return super.getAll((criteriaBuilder, criteriaQuery, root) -> {
            criteriaQuery.where(criteriaBuilder.equal(root.get("status"), true));
        });
    }

    @Override
    public void update(Student student) throws Exception {
        Student foundStudent = getOneById(student.getId());
        foundStudent.setAddress(student.getAddress());
        foundStudent.setName(student.getName());
        foundStudent.setDob(student.getDob());
        foundStudent.setContactNo(student.getContactNo());
        super.update(foundStudent);
    }
}
