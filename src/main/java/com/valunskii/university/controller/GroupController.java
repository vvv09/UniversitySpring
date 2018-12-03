package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valunskii.university.repository.GroupRepository;

@Controller
@RequestMapping("/groups")
public class GroupController {
    
    @Autowired
    private GroupRepository groupRepo;
    
    @GetMapping
    public String groupList(Model model) {
        model.addAttribute("groups", groupRepo.findAll());
        return "groups";
    }
}
