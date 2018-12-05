package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valunskii.university.domain.Teacher;
import com.valunskii.university.repository.TeacherRepository;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
     
    private TeacherRepository teacherRepo;

    @Autowired
    public void setTeacherRepo(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @GetMapping
    public String retriveAllTeachers(Model model) {
        model.addAttribute("teachers", teacherRepo.findAll());
        return "teachers";
    }
    
    @GetMapping("/new")
    public String newTeacherForm(Model model) {
        return "addTeacher";
    }
    
    @GetMapping("/edit/{teacher}")
    public String retriveTeacherForEdit(@PathVariable Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher);
        return "editTeacher";
    }
    
    @PostMapping("saveNew")
    public String createTeacher(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName, Model model) {
        teacherRepo.save(new Teacher(firstName, middleName, lastName));
        return "redirect:/teachers";
    }
    
    @PostMapping
    public String updateClassroom(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName, @RequestParam("id") Teacher teacher) {
        teacher.setLastName(lastName);
        teacher.setMiddleName(middleName);
        teacher.setFirstName(firstName);
        teacherRepo.save(teacher);
        return "redirect:/teachers";
    }
    
    @GetMapping("/delete/{teacher}")
    public String deleteClassroom(@PathVariable Teacher teacher) {
        teacherRepo.delete(teacher);
        return "redirect:/teachers";
    }
}
