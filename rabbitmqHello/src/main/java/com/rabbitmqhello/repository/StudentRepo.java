package com.rabbitmqhello.repository;

import com.rabbitmqhello.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM student WHERE names = :names ")
    Student findStudentByName(String names);
}
