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
    public String createTeacher(WebRequest webRequest, Model model) {
        Map<String, String[]> params = webRequest.getParameterMap();
        teacherRepo.save(new Teacher(params.get("firstName")[0], params.get("middleName")[0], params.get("lastName")[0]));
        return "redirect:/teachers";
    }
    
    @PostMapping
    public String updateClassroom(WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        Optional<Teacher> optionalTeacher = teacherRepo.findById(Long.parseLong(params.get("id")[0]));
        Teacher teacher = null;
        if (optionalTeacher.isPresent()) {
            teacher = optionalTeacher.get();
        }
        teacher.setLastName(params.get("lastName")[0]);
        teacher.setMiddleName(params.get("middleName")[0]);
        teacher.setFirstName(params.get("firstName")[0]);
        teacherRepo.save(teacher);
        return "redirect:/teachers";
    }
    
    @GetMapping("/delete/{teacher}")
    public String deleteClassroom(@PathVariable Teacher teacher) {
        teacherRepo.delete(teacher);
        return "redirect:/teachers";
    }
}
