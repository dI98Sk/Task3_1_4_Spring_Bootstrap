package com.skakundima.spring.boot.KataTask_3_1_2.controller;


import com.skakundima.spring.boot.KataTask_3_1_2.model.User;
import com.skakundima.spring.boot.KataTask_3_1_2.service.RoleService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    private final RoleService roleService;

    public UserController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String showUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleService.findAll());
        return "user";
    }
}
