package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import io.jsonwebtoken.Jwts;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserAuthService {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final String SECRET_KEY = "$EsmieWarren17042023Bella";

    @Autowired
    public UserAuthService(UserService userService) {
        this.userService = userService;
    }

    public String authLoginRequest(String username, String password) {
        System.out.println("AuthLogin");
        User user = userService.getUserByUsername(username);

        System.out.println(user.toString());
        if (user != null && password.matches(user.getPassword().toString())){
            System.out.println(user.getPassword().toString());
            // Generate JWT Token
            return Jwts.builder()
                    .setSubject(user.getUsername())  // Use username as the subject
                    //.claim("role", user.getRole())  // Optionally, add user roles/claims
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                    //.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        } else {
            System.out.print("User is null");
            throw new IllegalArgumentException("Invalid Credentials");
        }
    }
}
