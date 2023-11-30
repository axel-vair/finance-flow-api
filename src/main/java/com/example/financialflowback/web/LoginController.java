package com.example.financialflowback.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class LoginController {
    @GetMapping("/user")
    public String getUser(){
        return "Welcome, User";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Welcome, Admin";
    }
}
