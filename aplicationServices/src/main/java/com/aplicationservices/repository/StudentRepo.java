package com.aplicationservices.repository;

import com.aplicationservices.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student,Long> {
}
