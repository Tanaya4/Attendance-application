package com.VibrantMind.Attendance_application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.VibrantMind.Attendance_application.modal.User;
import com.VibrantMind.Attendance_application.modal.UserDetailsImpl;
import com.VibrantMind.Attendance_application.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByEmail(username);
		if(user == null) {
			System.out.println("User 404");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserDetailsImpl(user);
	}

}
