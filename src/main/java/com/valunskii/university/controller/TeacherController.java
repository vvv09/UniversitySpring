package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valunskii.university.repository.TeacherRepository;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
  
    @Autowired
    private TeacherRepository teacherRepo;
    
    @GetMapping
    public String teacherList(Model model) {
        model.addAttribute("teachers", teacherRepo.findAll());
        return "teachers";
    }
}
