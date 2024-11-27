package com.VibrantMind.Attendance_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.VibrantMind.Attendance_application.dto.LoginRequest;
import com.VibrantMind.Attendance_application.dto.RegistrationRequest;
import com.VibrantMind.Attendance_application.modal.User;
import com.VibrantMind.Attendance_application.repo.UserRepository;
import com.VibrantMind.Attendance_application.util.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    public String register(RegistrationRequest request) {
        User user = new User();
        user.setName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("STUDENT");
        userRepository.save(user);
        return "Registration successful!";
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getEmail(), user.getRole());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
    
}
