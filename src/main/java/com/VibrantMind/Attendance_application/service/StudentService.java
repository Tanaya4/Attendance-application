package com.VibrantMind.Attendance_application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VibrantMind.Attendance_application.dto.AttendanceResponse;
import com.VibrantMind.Attendance_application.modal.Attendance;
import com.VibrantMind.Attendance_application.repo.AttendanceRepository;

@Service
public class StudentService {
	@Autowired
    private AttendanceRepository attendanceRepository;

    public String markAttendance() {
        Attendance attendance = new Attendance();
        attendance.setStudentName("StudentName"); // Replace with logged-in student
        attendance.setTimestamp(LocalDateTime.now());
        attendance.setSelfieUrl("selfie/path.jpg"); // Placeholder
        attendanceRepository.save(attendance);
        return "Attendance marked!";
    }

    public List<AttendanceResponse> getAttendanceHistory() {
        return attendanceRepository.findByStudentName("StudentName") // Replace with logged-in user
                .stream()
                .map(att -> new AttendanceResponse(att.getDate(), att.getTimestamp(), att.getSelfieUrl()))
                .collect(Collectors.toList());
    }
}
