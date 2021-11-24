package com.nepalaya.studentmgmt.dao.impl;

import com.nepalaya.studentmgmt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "UPDATE STUDENTS SET status=false WHERE id=:id", nativeQuery = true)
    void delete(Long id);
}
