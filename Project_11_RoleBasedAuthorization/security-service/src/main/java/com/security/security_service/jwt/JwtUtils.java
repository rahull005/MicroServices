package com.security.security_service.jwt;

import com.security.security_service.entities.UserImp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Service
public class JwtUtils {

    // Base64 encoded key of "mysecretkeymysecretkeymysecretkeymysecretkey"
    private static final String secretKey = "bXlzZWNyZXRrZXlteXNlY3JldGtleW15c2VjcmV0a2V5bXlzZWNyZXRrZXk=";

    public String generateToken(UserImp user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("roles", user.getAuthorities()
                        .stream()
                        .map(role -> role.getAuthority()) // e.g., ROLE_USER, ROLE_ADMIN
                        .toList())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .signWith(getKey())
                .compact();
    }

    public void validateToken(String token) {
        Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token); // throws exception if invalid
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
