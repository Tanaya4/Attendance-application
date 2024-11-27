package com.VibrantMind.Attendance_application.dto;

import lombok.Data;

@Data
public class RegistrationRequest {

	private String userName;
	private String password;
	private String email;
	private String role;
//	private boolean active = true;
}
