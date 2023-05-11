package com.rabbitmqhello.repository;

import com.rabbitmqhello.model.StudentHealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentHealthInsuranceRepo extends JpaRepository<StudentHealthInsurance,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM student_health_insurance WHERE student_names = :studentNames ")
    StudentHealthInsurance findStudentHealthInsuranceByName(String studentNames);
}
