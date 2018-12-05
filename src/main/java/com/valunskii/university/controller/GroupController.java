package com.valunskii.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valunskii.university.domain.Group;
import com.valunskii.university.repository.GroupRepository;

@Controller
@RequestMapping("/groups")
public class GroupController {
    
    private GroupRepository groupRepo;
  
    @Autowired
    public void setGroupRepo(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    @GetMapping
    public String retriveAllGroups(Model model) {
        model.addAttribute("groups", groupRepo.findAll());
        return "groups";
    }
    
    @GetMapping("/new")
    public String newGroupForm(Model model) {
        return "addGroup";
    }
    
    @GetMapping("/edit/{group}")
    public String retriveGroupForEdit(@PathVariable Group group, Model model) {
        model.addAttribute("group", group);
        return "editGroup";
    }
    
    @PostMapping("saveNew")
    public String createGroup(@RequestParam String name, Model model) {
        groupRepo.save(new Group(name));
        return "redirect:/groups";
    }
    
    @PostMapping
    public String updateGroup(@RequestParam String name, @RequestParam("id") Group group) {
        group.setName(name);
        groupRepo.save(group);
        return "redirect:/groups";
    }
    
    @GetMapping("/delete/{group}")
    public String deleteGroup(@PathVariable Group group) {
        groupRepo.delete(group);
        return "redirect:/groups";
    }
}
