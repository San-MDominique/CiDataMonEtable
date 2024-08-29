package com.example.monwebetable.services;

import com.example.monwebetable.services.DTO.StudentDTO;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentDTO save(StudentDTO student);
    Optional<StudentDTO> findOne(Long id);

    StudentDTO update(StudentDTO student);

     List<StudentDTO>findAll();
    void delete(Long id);
}
