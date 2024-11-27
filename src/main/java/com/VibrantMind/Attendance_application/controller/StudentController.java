package com.VibrantMind.Attendance_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VibrantMind.Attendance_application.dto.AttendanceResponse;
import com.VibrantMind.Attendance_application.modal.User;
import com.VibrantMind.Attendance_application.service.StudentService;
import com.VibrantMind.Attendance_application.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController()
public class StudentController {
	
	@Autowired
	private UserService userService;
	
    @Autowired
    private StudentService studentService;
	
	
    @PostMapping("/attendance")
    public String markAttendance() {
        return studentService.markAttendance();
    }

    @GetMapping("/attendance/history")
    public List<AttendanceResponse> getAttendanceHistory() {
        return studentService.getAttendanceHistory();
    }

//	@GetMapping("/hello")
//	public String greet(HttpServletRequest req) {
//		return "Hello World!" + req.getSession().getId();
//	}
//	
//	@PostMapping("/register")
//	public User register(@RequestBody User user) {
//		user.setPassword(encoder.encode(user.getPassword()));
//		userService.saveUser(user);
//		return user;
//	}
	
	
}
