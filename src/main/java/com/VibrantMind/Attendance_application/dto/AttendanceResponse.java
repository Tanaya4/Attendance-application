package com.VibrantMind.Attendance_application.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceResponse {
	
	 private LocalDate date; 
	 private LocalDateTime timestamp; 
	 private String selfieUrl; 
}
