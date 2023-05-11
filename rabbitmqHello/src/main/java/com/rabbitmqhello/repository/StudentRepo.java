package com.rabbitmqhello.repository;

import com.rabbitmqhello.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student,Long> {
}
