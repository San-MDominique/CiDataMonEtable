package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.Teacher;
import com.example.monwebetable.repositories.TeacherRepository;
import com.example.monwebetable.services.DTO.TeacherDTO;
import com.example.monwebetable.services.Mapper.TeacherMapper;
import com.example.monwebetable.services.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Request to save Teacher: {}", teacherDTO);
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        return teacherRepository.findById(id).map(teacher  ->{
            return teacherMapper.toDto(teacher);
        });
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        return findOne(teacherDTO.getId()).map(existingTeacher -> {
            existingTeacher.setNom(teacherDTO.getNom());
            existingTeacher.setPrenom(teacherDTO.getPrenom());
            existingTeacher.setTelephone(teacherDTO.getTelephone());
            existingTeacher.setVille(teacherDTO.getVille());
            existingTeacher.setDateNaissance(teacherDTO.getDateNaissance());
            existingTeacher.setVacant(teacherDTO.isVacant());
            existingTeacher.setMatiereEnseigne(teacherDTO.getMatiereEnseigne());
            existingTeacher.setProchainCours(teacherDTO.getProchainCours());
            existingTeacher.setSujetProchaineReunion(teacherDTO.getSujetProchaineReunion());
            return save(existingTeacher);
        }).orElseThrow(() -> new IllegalArgumentException("Teacher not found with id " + teacherDTO.getId()));
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacher ->{
            return teacherMapper.toDto(teacher);
                }).toList();
    }

    @Override
    public void delete(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new IllegalArgumentException("Teacher not found with id " + id);
        }
        teacherRepository.deleteById(id);

    }
}
