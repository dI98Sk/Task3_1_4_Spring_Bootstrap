package com.skakundima.spring.boot.KataTask_3_1_2.controller;

import com.skakundima.spring.boot.KataTask_3_1_2.entity.User;
import com.skakundima.spring.boot.KataTask_3_1_2.service.RoleService;
import com.skakundima.spring.boot.KataTask_3_1_2.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/main")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String showUsers(Model model, @ModelAttribute("newUser") User newUser) {
        model.addAttribute("usersList", userService.getUsers());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User curUser = userService.getUserByEmail(auth.getName());
        model.addAttribute("curUser", curUser);
        model.addAttribute("rolesList", roleService.getAllRoles());
        return "main_page";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/main/";
    }

    @PatchMapping("/")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/main/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/main/";
    }

}