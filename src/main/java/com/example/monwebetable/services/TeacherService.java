package com.example.monwebetable.services;

import com.example.monwebetable.models.Teacher;
import com.example.monwebetable.services.DTO.TeacherDTO;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    TeacherDTO save(TeacherDTO teacher);
    Optional<TeacherDTO> findOne(Long id);
    TeacherDTO update(TeacherDTO teacher);  // Correction du nom de la méthode

    List<TeacherDTO> findAll();
    // Suppression de la méthode statique

    void delete(Long id);
}
