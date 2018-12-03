package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valunskii.university.repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepo;
    
    @GetMapping
    public String studentList(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "students";
    }
}
