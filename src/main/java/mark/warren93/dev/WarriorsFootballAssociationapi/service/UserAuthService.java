package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public class UserAuthService {

    UserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private String SECRET_KEY = "$EsmieWarren17042023Bella";

    public String authLoginRequest(String username, String password) {
        User user = userService.getUserByUsername(username);

        if(user != null && password.matches(user.getPassword())){
            // Generate JWT Token
            return Jwts.builder()
                    .setSubject(user.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }
        return "Invalid Credentials";
    }
}
