package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valunskii.university.domain.Classroom;
import com.valunskii.university.repository.ClassroomRepository;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    
    private ClassroomRepository classroomRepo;
    
    @Autowired
    public void setClassroomRepo(ClassroomRepository classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @GetMapping
    public String retriveAllClassrooms(Model model) {
        model.addAttribute("classrooms", classroomRepo.findAll());
        return "classrooms";
    }
    
    @GetMapping("/new")
    public String newClassroomForm(Model model) {
        return "addClassroom";
    }
    
    @GetMapping("/edit/{classroom}")
    public String retriveClassroomForEdit(@PathVariable Classroom classroom, Model model) {
        model.addAttribute("classroom", classroom);
        return "editClassroom";
    }
    
    @PostMapping("saveNew")
    public String createClassroom(@RequestParam String name, Model model) {
        classroomRepo.save(new Classroom(name));
        return "redirect:/classrooms";
    }
    
    @PostMapping
    public String updateClassroom(@RequestParam String name, @RequestParam("id") Classroom classroom) {
        classroom.setName(name);
        classroomRepo.save(classroom);
        return "redirect:/classrooms";
    }
    
    @GetMapping("/delete/{classroom}")
    public String deleteClassroom(@PathVariable Classroom classroom) {
        classroomRepo.delete(classroom);
        return "redirect:/classrooms";
    }
}
