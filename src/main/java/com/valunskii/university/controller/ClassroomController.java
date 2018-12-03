package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valunskii.university.repository.ClassroomRepository;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    
    @Autowired
    private ClassroomRepository classroomRepo;
    
    @GetMapping
    public String classroomList(Model model) {
        model.addAttribute("classrooms", classroomRepo.findAll());
        return "classrooms";
    }
}
