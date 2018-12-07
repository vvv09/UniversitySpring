package com.valunskii.university.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valunskii.university.domain.Group;
import com.valunskii.university.domain.Student;
import com.valunskii.university.repository.GroupRepository;
import com.valunskii.university.repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    private StudentRepository studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }
    
    private GroupRepository groupRepo;
    
    @Autowired
    public void setGroupRepo(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    @GetMapping
    public String retriveAllStudents(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "students";
    }
    
    @GetMapping("/new")
    public String newStudentForm(Model model) {
        model.addAttribute("groups", groupRepo.findAll());
        return "addStudent";
    }
    
    @GetMapping("/edit/{student}")
    public String retriveStudentForEdit(@PathVariable Student student, Model model) {
        model.addAttribute("student", student);
        return "editStudent";
    }
    
    @PostMapping("saveNew")
    public String createStudent(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName, @RequestParam Long groupId, Model model) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + groupId);
        Optional<Group> optionalGroup = groupRepo.findById(groupId);
        Group group = null;
        if (optionalGroup.isPresent()) {
            group = optionalGroup.get();
        }
        studentRepo.save(new Student(firstName, middleName, lastName, group));
        return "redirect:/students";
    }
    
    @PostMapping
    public String updateStudent(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName, @RequestParam("id") Student student) {
        student.setLastName(lastName);
        student.setMiddleName(middleName);
        student.setFirstName(firstName);
        studentRepo.save(student);
        return "redirect:/students";
    }
    
    @GetMapping("/delete/{student}")
    public String deleteStudent(@PathVariable Student student) {
        studentRepo.delete(student);
        return "redirect:/students";
    }
}
