package com.skakundima.spring.boot.KataTask_3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/no-role/")
    public String noRoleUser() {
        return "user_without_role";
    }
}
