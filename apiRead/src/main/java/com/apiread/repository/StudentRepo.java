package com.apiread.repository;

import com.apiread.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student,Long> {
}
