package com.example.monwebetable.services.Mapper.impl;

import com.example.monwebetable.models.Teacher;
import com.example.monwebetable.services.DTO.TeacherDTO;
import com.example.monwebetable.services.Mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMapperimpl implements TeacherMapper {
    private final ModelMapper modelMapper;
    @Override
    public TeacherDTO toDto(Teacher entity) {
        return modelMapper.map(entity, TeacherDTO.class);
    }

    @Override
    public Teacher toEntity(TeacherDTO dto) {
        return modelMapper.map(dto, Teacher.class);
    }
}
