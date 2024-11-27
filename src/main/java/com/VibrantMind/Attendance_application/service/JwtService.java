package com.VibrantMind.Attendance_application.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.VibrantMind.Attendance_application.modal.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "uPiJxvnTkMZkl6tOf/xuYlD5yOBx+7RxrjwLk3Xfbxg=";

    // Method to generate JWT token
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail()) // Use the username as the subject
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Set token expiration to 10 hours
                .signWith(getSigningKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    // Method to decode the secret key
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

	public String extractUserName(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return true;
	}
}
