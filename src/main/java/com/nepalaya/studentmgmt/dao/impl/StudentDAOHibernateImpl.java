package com.nepalaya.studentmgmt.dao.impl;

import com.nepalaya.studentmgmt.dao.StudentDAO;
import com.nepalaya.studentmgmt.db.QueryConstant;
import com.nepalaya.studentmgmt.mapper.StudentMapper;
import com.nepalaya.studentmgmt.model.Student;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class StudentDAOHibernateImpl implements StudentDAO {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jdbcDemo");

    @Override
    public boolean add(Student student) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Student student) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Override
    public List<Student> getAll() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> rootEntry = cq.from(Student.class);
        CriteriaQuery<Student> all = cq.select(rootEntry);
        TypedQuery<Student> allQuery = entityManager.createQuery(all);
        List<Student> students = allQuery.getResultList();

        if (students == null || students.isEmpty()) {
            throw new RuntimeException("Students not found");
        }
        entityManager.close();
        return students;
    }

    @Override
    public Student getById(Long id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;

        Optional<Student> optionalStudent = Optional.of(entityManager.find(Student.class, id));
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();

        } else {
            throw new RuntimeException("Student with id=[" + id + "] is not found in our system");
        }
        entityManager.close();
        return student;

    }
}
