package com.VibrantMind.Attendance_application.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "mySecretKey"; // Use a strong, secure key
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // Generate JWT Token
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validate JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
            return true; // Token is valid
        } catch (JwtException e) {
            return false; // Invalid token
        }
    }


    // Extract Username from Token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // Ensure SECRET_KEY matches the key used for signing
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
