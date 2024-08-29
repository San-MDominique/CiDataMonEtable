package com.example.monwebetable.controller;

import com.example.monwebetable.models.Student;
import com.example.monwebetable.services.DTO.StudentDTO;
import com.example.monwebetable.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class studentsController {

        private final StudentService studentService;

    @GetMapping
    public String showStudentPage(Model model) {
        List<StudentDTO> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students/liste";
    }

    @GetMapping("/add")
    public String showStudentForm(Model model) {
        log.debug("request to show add Student form");
        model.addAttribute("student", new StudentDTO());
        return "students/forms";
    }

    @PostMapping("/save")

    public String saveStudent(StudentDTO student) {
        log.debug("Request to save student:{}", student);
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String showUpdateForm(Model model, @PathVariable long id) {
        log.debug("Resquest ti show update Student form");
        Optional<StudentDTO> student = studentService.findOne(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "students/forms";
        } else {
            return "redirect:/students";
        }
    }
}


