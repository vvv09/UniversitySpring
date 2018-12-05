package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valunskii.university.domain.Subject;
import com.valunskii.university.repository.SubjectRepository;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    
    private SubjectRepository subjectRepo;

    @Autowired
    public void setSubjectRepo(SubjectRepository subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @GetMapping
    public String retriveAllSubjecs(Model model) {
        model.addAttribute("subjects", subjectRepo.findAll());
        return "subjects";
    }
   
    @GetMapping("/new")
    public String newSubjectForm(Model model) {
        return "addSubject";
    }
    
    @GetMapping("/edit/{subject}")
    public String retriveSubjectForEdit(@PathVariable Subject subject, Model model) {
        model.addAttribute("subject", subject);
        return "editSubject";
    }
    
    @PostMapping("saveNew")
    public String createSubject(@RequestParam String name, Model model) {
        subjectRepo.save(new Subject(name));
        return "redirect:/subjects";
    }
    
    @PostMapping
    public String updateSubject(@RequestParam String name, @RequestParam("id") Subject subject) {
        subject.setName(name);
        subjectRepo.save(subject);
        return "redirect:/subjects";
    }
    
    @GetMapping("/delete/{subject}")
    public String deleteSubject(@PathVariable Subject subject) {
        subjectRepo.delete(subject);
        return "redirect:/subjects";
    }
}
