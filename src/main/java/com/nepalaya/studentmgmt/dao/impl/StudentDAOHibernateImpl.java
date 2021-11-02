package com.nepalaya.studentmgmt.dao.impl;

import com.nepalaya.studentmgmt.dao.StudentDAO;
import com.nepalaya.studentmgmt.model.Student;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentDAOHibernateImpl implements StudentDAO {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jdbcDemo");

    @Override
    public void save(Student student) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new Exception("Saving Student Failed !");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Student student) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(student);
        } catch (Exception ex) {
            transaction.rollback();
            throw new Exception("Updating Student Failed");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            Student student = entityManager.find(Student.class, id);
            transaction = entityManager.getTransaction();
            transaction.begin();
            if (student == null) {
                throw new RuntimeException("Deleting Student Failed");
            } else {
                student.setStatus(false);
                transaction.commit();
            }
        } catch (Exception ex) {
            transaction.rollback();
            throw new Exception("Deleting Student Failed");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Student> getAll() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> rootEntry = cq.from(Student.class);
            CriteriaQuery<Student> all = cq.select(rootEntry);
            all.where(cb.equal(rootEntry.get("status"), true));
            TypedQuery<Student> allQuery = entityManager.createQuery(all);
            List<Student> students = allQuery.getResultList();
            if (students == null || students.isEmpty()) {
                throw new Exception("Students not found");
            }
            return students;
        } catch (Exception ex) {
            throw new Exception("Getting Students Failed !");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Student getOneById(Long id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Student student = entityManager.find(Student.class, id);
            if (student == null) {
                throw new Exception("Student with id=[" + id + "] is not found in our system");
            }
            return student;
        } catch (Exception ex) {
            throw new Exception("Getting Students Failed !");
        } finally {
            entityManager.close();
        }
    }
}
