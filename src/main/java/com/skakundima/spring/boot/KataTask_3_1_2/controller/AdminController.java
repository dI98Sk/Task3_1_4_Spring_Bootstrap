package com.skakundima.spring.boot.KataTask_3_1_2.controller;

import com.skakundima.spring.boot.KataTask_3_1_2.model.User;
import com.skakundima.spring.boot.KataTask_3_1_2.service.RoleService;
import com.skakundima.spring.boot.KataTask_3_1_2.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String findAll(Model model ,@AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("allRoles", roleService.findAll());
        return "admin";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("allRoles", roleService.findAll());
        return "user";
    }

    @PostMapping()
    public String add(User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        userService.removeById(id);
        return "redirect:/admin";
    }

    @PutMapping("/{id}")
    public String update(User user) {
        userService.update(user);
        return "redirect:/admin";
    }
}
