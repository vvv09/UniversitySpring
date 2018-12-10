package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valunskii.university.repository.ScheduleRepository;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleRepository scheduleRepo;

    @Autowired
    public void setScheduleRepo(ScheduleRepository scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    @GetMapping
    public String retriveAllSchedule(Model model) {
        model.addAttribute("schedule", scheduleRepo.findAllByOrderByIdAsc());
        return "schedule";
    }
}
