package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.Student;
import com.example.monwebetable.repositories.StudentRepository;
import com.example.monwebetable.services.DTO.StudentDTO;
import com.example.monwebetable.services.Mapper.StudentMapper;
import com.example.monwebetable.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save Student: {}", studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return studentRepository.findById(id).map(student-> {
            return studentMapper.toDto(student);
        });
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        return findOne(studentDTO.getId()).map(existingStudent -> {
            existingStudent.setNom(studentDTO.getNom());
            existingStudent.setPrenom(studentDTO.getPrenom());
            existingStudent.setTelephone(studentDTO.getTelephone());
            existingStudent.setVille(studentDTO.getVille());
            existingStudent.setDateNaissance(studentDTO.getDateNaissance());
            existingStudent.setClasse(studentDTO.getClasse());
            existingStudent.setMatricule(studentDTO.getMatricule());
            return save(existingStudent);
        }).orElseThrow(() -> new IllegalArgumentException("Student not found with id " + studentDTO.getId()));
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student ->{
            return studentMapper.toDto(student);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }
}