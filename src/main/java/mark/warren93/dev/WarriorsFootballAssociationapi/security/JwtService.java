package mark.warren93.dev.WarriorsFootballAssociationapi.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.*;

@Service
public class JwtService {
    private final Key key;
    private final long expMillis;

    public JwtService(@Value("${jwt.secret}") String secret, @Value("${jwt.expMinutes:120}") long expMinutes) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expMillis = expMinutes * 60_000;
    }

    public String generate(String subject, String username, String role) {
        Instant now = Instant.now();
        return Jwts.builder().setSubject(subject).setClaims(Map.of("u", username, "r", role)).setIssuedAt(java.util.Date.from(now)).setExpiration(java.util.Date.from(now.plusMillis(expMillis))).signWith(key, SignatureAlgorithm.HS256).compact();
    }

    public Jws<Claims> parse(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }
}