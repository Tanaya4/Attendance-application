package com.VibrantMind.Attendance_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VibrantMind.Attendance_application.dto.LoginRequest;
import com.VibrantMind.Attendance_application.dto.RegistrationRequest;
import com.VibrantMind.Attendance_application.modal.User;
import com.VibrantMind.Attendance_application.service.AuthService;
import com.VibrantMind.Attendance_application.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
    
}
