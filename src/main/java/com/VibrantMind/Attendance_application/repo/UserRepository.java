package com.VibrantMind.Attendance_application.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VibrantMind.Attendance_application.modal.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}

