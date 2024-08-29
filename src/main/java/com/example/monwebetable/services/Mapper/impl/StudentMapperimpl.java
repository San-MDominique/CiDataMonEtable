package com.example.monwebetable.services.Mapper.impl;

import com.example.monwebetable.models.Student;
import com.example.monwebetable.services.DTO.StudentDTO;
import com.example.monwebetable.services.Mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapperimpl implements StudentMapper {
        private final ModelMapper modelMapper;
    @Override
    public StudentDTO toDto(Student entity) {
        return modelMapper.map(entity, StudentDTO.class);
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }
}
