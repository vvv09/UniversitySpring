package com.valunskii.university.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

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
        model.addAttribute("groups", groupRepo.findAll());
        return "editStudent";
    }
    
    @PostMapping("saveNew")
    public String createStudent(WebRequest webRequest, Model model) {
        Map<String, String[]> params = webRequest.getParameterMap();
        Optional<Group> optionalGroup = groupRepo.findById(Long.parseLong(params.get("groupId")[0]));
        Group group = null;
        if (optionalGroup.isPresent()) {
            group = optionalGroup.get();
        }
        studentRepo.save(new Student(params.get("firstName")[0], params.get("middleName")[0], params.get("lastName")[0], group));
        return "redirect:/students";
    }
    
    @PostMapping
    public String updateStudent(WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        Optional<Student> optionalStudent = studentRepo.findById(Long.parseLong(params.get("id")[0]));
        Student student = null;
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        }
        student.setLastName(params.get("lastName")[0]);
        student.setMiddleName(params.get("middleName")[0]);
        student.setFirstName(params.get("firstName")[0]);
        Optional<Group> optionalGroup = groupRepo.findById(Long.parseLong(params.get("groupId")[0]));
        Group group = null;
        if (optionalGroup.isPresent()) {
            group = optionalGroup.get();
        }
        student.setGroup(group);
        studentRepo.save(student);
        
        return "redirect:/students";
    }
    
    @GetMapping("/delete/{student}")
    public String deleteStudent(@PathVariable Student student) {
        studentRepo.delete(student);
        return "redirect:/students";
    }
}
