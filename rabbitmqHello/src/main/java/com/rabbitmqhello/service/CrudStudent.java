package com.rabbitmqhello.service;

import com.rabbitmqhello.model.dto.DtoInput;

public interface CrudStudent {
    void saveStudent(DtoInput dtoInput);
    void deleteStudent(DtoInput dtoInput);
}
