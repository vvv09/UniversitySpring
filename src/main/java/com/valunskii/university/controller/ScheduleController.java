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

import com.valunskii.university.domain.Classroom;
import com.valunskii.university.domain.Group;
import com.valunskii.university.domain.Schedule;
import com.valunskii.university.domain.Subject;
import com.valunskii.university.domain.Teacher;
import com.valunskii.university.repository.ClassroomRepository;
import com.valunskii.university.repository.GroupRepository;
import com.valunskii.university.repository.ScheduleRepository;
import com.valunskii.university.repository.SubjectRepository;
import com.valunskii.university.repository.TeacherRepository;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleRepository scheduleRepo;

    @Autowired
    public void setScheduleRepo(ScheduleRepository scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }
    
    private SubjectRepository subjectRepo;
    private TeacherRepository teacherRepo;
    private GroupRepository groupRepo;
    private ClassroomRepository classroomRepo;

    @Autowired
    public void setSubjectRepo(SubjectRepository subjectRepo) {
        this.subjectRepo = subjectRepo;
    }
    
    @Autowired
    public void setTeacherRepo(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }
    
    @Autowired
    public void setGroupRepo(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }
    
    @Autowired
    public void setClassroomRepo(ClassroomRepository classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @GetMapping
    public String retriveAllSchedule(Model model) {
        model.addAttribute("schedule", scheduleRepo.findAllByOrderByIdAsc());
        return "schedule";
    }
    
    @GetMapping("/group/{group}")
    public String retriveScheduleForGroup(@PathVariable Group group, Model model) {
        model.addAttribute("schedule", scheduleRepo.findByGroupOrderById(group));
       
        return "schedule";
    }
    
    @GetMapping("/teacher/{teacher}")
    public String retriveScheduleForTeacher(@PathVariable Teacher teacher, Model model) {
        model.addAttribute("schedule", scheduleRepo.findByTeacherOrderById(teacher));
       
        return "schedule";
    }
    
    @GetMapping("/edit/{schedule}")
    public String retriveScheduleForEdit(@PathVariable Schedule schedule, Model model) {
        model.addAttribute("sceduleRow", schedule);
        model.addAttribute("classrooms", classroomRepo.findAll());
        model.addAttribute("teachers", teacherRepo.findAll());
        model.addAttribute("subjects", subjectRepo.findAll());
        model.addAttribute("groups", groupRepo.findAll());
        return "editScheduleRow";
    }
    
    @PostMapping
    public String updateSchedule(@RequestParam Long subjectId, @RequestParam Long teacherId,
            @RequestParam Long groupId, @RequestParam Long classroomId, @RequestParam("id") Schedule schedule) {

        Optional<Subject> optionalSubject = subjectRepo.findById(subjectId);
        Subject subject = null;
        if (optionalSubject.isPresent()) {
            subject = optionalSubject.get();
        }
        schedule.setSubject(subject);
        
        Optional<Teacher> optionalTeacher = teacherRepo.findById(teacherId);
        Teacher teacher = null;
        if (optionalTeacher.isPresent()) {
            teacher = optionalTeacher.get();
        }
        schedule.setTeacher(teacher);
        
        Optional<Group> optionalGroup = groupRepo.findById(groupId);
        Group group = null;
        if (optionalGroup.isPresent()) {
            group = optionalGroup.get();
        }
        schedule.setGroup(group);
        
        Optional<Classroom> optionalClassroom = classroomRepo.findById(classroomId);
        Classroom classroom = null;
        if (optionalClassroom.isPresent()) {
            classroom = optionalClassroom.get();
        }
        schedule.setClassroom(classroom);
        
              
        scheduleRepo.save(schedule);
        
        return "redirect:/schedule";
    }
}
