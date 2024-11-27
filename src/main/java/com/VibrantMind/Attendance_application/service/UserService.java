package com.VibrantMind.Attendance_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VibrantMind.Attendance_application.modal.User;
import com.VibrantMind.Attendance_application.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
}
