package com.example.monwebetable.controller;


import com.example.monwebetable.models.Teacher;
import com.example.monwebetable.services.DTO.TeacherDTO;
import com.example.monwebetable.services.TeacherService;
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
@RequiredArgsConstructor
@Controller
@RequestMapping("/teachers")
public class teachersController {

    private final TeacherService teacherService;

    @GetMapping
    public String showTeacherPage(Model model) {
        List<TeacherDTO> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers/liste";
    }

    @GetMapping("/add")
    public String showTeacherForm(Model model) {
        log.debug("Request to show add Teacher form");
        model.addAttribute("teacher", new TeacherDTO());
        return "teachers/forms";
    }

    @PostMapping
    public String saveTeacher(TeacherDTO teacher) {
        log.debug("Request to save teacher: {}", teacher);
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/{id}")
    public String showUpdateForm(Model model, @PathVariable long id) {
        log.debug("Request to show update Teacher form");
        Optional<TeacherDTO> teacher = teacherService.findOne(id);
        if (teacher.isPresent()) {
            model.addAttribute("teacher", teacher.get());
            return "teachers/forms";
        } else {
            return "redirect:/teachers";
        }
    }
}