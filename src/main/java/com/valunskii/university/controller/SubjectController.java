package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valunskii.university.repository.SubjectRepository;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    
    @Autowired
    private SubjectRepository subjectRepo;
    
    @GetMapping
    public String subjectList(Model model) {
        model.addAttribute("subjects", subjectRepo.findAll());
        return "subjects";
    }
}
