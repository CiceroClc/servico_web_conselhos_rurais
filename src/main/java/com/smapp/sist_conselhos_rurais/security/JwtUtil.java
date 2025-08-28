package com.smapp.sist_conselhos_rurais.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

	private final Key key;
    private final long expirationMs;

    public JwtUtil(Environment env) {
        String secret = env.getProperty("app.jwt.secret");
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = Long.parseLong(env.getProperty("app.jwt.expiration", "3600000"));
    }

    public String generateToken(String username, String role) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(now)
                .expiration(exp)
                .signWith(key)
                .compact();
    }

    public Jws<Claims> parse(String token) {
        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token);
    }	
}
