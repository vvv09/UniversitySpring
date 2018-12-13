package com.valunskii.university.controller;

import java.time.DayOfWeek;
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

import com.valunskii.university.domain.Classroom;
import com.valunskii.university.domain.Group;
import com.valunskii.university.domain.Parity;
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

    private final String ANY = "any";

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
    public String retriveAllSchedule(WebRequest webRequest, Model model) {
        Map<String, String[]> params = webRequest.getParameterMap();
        String parity = null;
        String dayOfWeek = null;
        if (params.containsKey("parity")) {
            parity = params.get("parity")[0];
        }
        if (params.containsKey("dayOfWeek")) {
            dayOfWeek = params.get("dayOfWeek")[0];
        }
        if ((parity == null && dayOfWeek == null) || (parity.equals(ANY) && dayOfWeek.equals(ANY))) {
            model.addAttribute("schedule", scheduleRepo.findAllByOrderByIdAsc());
        } else {
            if (parity.equals(ANY)) {
                model.addAttribute("schedule",
                        scheduleRepo.findAllByDayOfWeekOrderByIdAsc(DayOfWeek.valueOf(dayOfWeek)));
            } else if (dayOfWeek.equals(ANY)) {
                model.addAttribute("schedule", scheduleRepo.findAllByParityOrderByIdAsc(Parity.valueOf(parity)));
            } else {
                model.addAttribute("schedule", scheduleRepo
                        .findAllByDayOfWeekAndParityOrderByIdAsc(DayOfWeek.valueOf(dayOfWeek), Parity.valueOf(parity)));
            }
        }
        return "schedule";
    }

    @GetMapping("/group/{group}")
    public String retriveScheduleForGroup(@PathVariable Group group, WebRequest webRequest, Model model) {
        Map<String, String[]> params = webRequest.getParameterMap();
        String parity = null;
        String dayOfWeek = null;
        if (params.containsKey("parity")) {
            parity = params.get("parity")[0];
        }
        if (params.containsKey("dayOfWeek")) {
            dayOfWeek = params.get("dayOfWeek")[0];
        }
        if ((parity == null && dayOfWeek == null) || (parity.equals(ANY) && dayOfWeek.equals(ANY))) {
            model.addAttribute("schedule", scheduleRepo.findByGroupOrderById(group));
        } else {
            if (parity.equals(ANY)) {
                model.addAttribute("schedule",
                        scheduleRepo.findByGroupAndDayOfWeekOrderById(group, DayOfWeek.valueOf(dayOfWeek)));
            } else if (dayOfWeek.equals(ANY)) {
                model.addAttribute("schedule", scheduleRepo.findByGroupAndParityOrderById(group, Parity.valueOf(parity)));
            } else {
                model.addAttribute("schedule", scheduleRepo
                        .findByGroupAndDayOfWeekAndParityOrderById(group, DayOfWeek.valueOf(dayOfWeek), Parity.valueOf(parity)));
            }
        }
        model.addAttribute("group", group);
        return "schedule";
    }

    @GetMapping("/teacher/{teacher}")
    public String retriveScheduleForTeacher(@PathVariable Teacher teacher, WebRequest webRequest, Model model) {
        Map<String, String[]> params = webRequest.getParameterMap();
        String parity = null;
        String dayOfWeek = null;
        if (params.containsKey("parity")) {
            parity = params.get("parity")[0];
        }
        if (params.containsKey("dayOfWeek")) {
            dayOfWeek = params.get("dayOfWeek")[0];
        }
        if ((parity == null && dayOfWeek == null) || (parity.equals(ANY) && dayOfWeek.equals(ANY))) {
            model.addAttribute("schedule", scheduleRepo.findByTeacherOrderById(teacher));
        } else {
            if (parity.equals(ANY)) {
                model.addAttribute("schedule",
                        scheduleRepo.findByTeacherAndDayOfWeekOrderById(teacher, DayOfWeek.valueOf(dayOfWeek)));
            } else if (dayOfWeek.equals(ANY)) {
                model.addAttribute("schedule",
                        scheduleRepo.findByTeacherAndParityOrderById(teacher, Parity.valueOf(parity)));
            } else {
                model.addAttribute("schedule", scheduleRepo.findByTeacherAndDayOfWeekAndParityOrderById(teacher,
                        DayOfWeek.valueOf(dayOfWeek), Parity.valueOf(parity)));
            }
        }
        model.addAttribute("teacher", teacher);
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
    public String updateSchedule(WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        if(validate(params)) {        
            Optional<Schedule> optionalSchedule = scheduleRepo.findById(Long.parseLong(params.get("id")[0]));
            Schedule schedule = null;
            if (optionalSchedule.isPresent()) {
                schedule = optionalSchedule.get();
            }
            
            Optional<Subject> optionalSubject = subjectRepo.findById(Long.parseLong(params.get("subjectId")[0]));
            Subject subject = null;
            if (optionalSubject.isPresent()) {
                subject = optionalSubject.get();
            }
            schedule.setSubject(subject);

            Optional<Teacher> optionalTeacher = teacherRepo.findById(Long.parseLong(params.get("teacherId")[0]));
            Teacher teacher = null;
            if (optionalTeacher.isPresent()) {
                teacher = optionalTeacher.get();
            }
            schedule.setTeacher(teacher);

            Optional<Group> optionalGroup = groupRepo.findById(Long.parseLong(params.get("groupId")[0]));
            Group group = null;
            if (optionalGroup.isPresent()) {
                group = optionalGroup.get();
            }
            schedule.setGroup(group);

            Optional<Classroom> optionalClassroom = classroomRepo
                    .findById(Long.parseLong(params.get("classroomId")[0]));
            Classroom classroom = null;
            if (optionalClassroom.isPresent()) {
                classroom = optionalClassroom.get();
            }
            schedule.setClassroom(classroom);

            scheduleRepo.save(schedule);
        }
        return "redirect:/schedule";
    }
    
    private boolean validate(Map<String, String[]> params) {
        if(!params.containsKey("id") || params.get("id") == null) {
            return false;
        }
        if(!params.containsKey("subjectId") || params.get("subjectId") == null) {
            return false;
        }
        if(!params.containsKey("teacherId") || params.get("teacherId") == null) {
            return false;
        }
        if(!params.containsKey("groupId") || params.get("groupId") == null) {
            return false;
        }
        if(!params.containsKey("classroomId") || params.get("classroomId") == null) {
            return false;
        }
        return true;
    }
}
