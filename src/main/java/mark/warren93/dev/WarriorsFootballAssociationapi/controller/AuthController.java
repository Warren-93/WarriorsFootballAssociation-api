package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.UserRepository;
import mark.warren93.dev.WarriorsFootballAssociationapi.security.JwtService;
import mark.warren93.dev.WarriorsFootballAssociationapi.security.UserPrincipal;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager am;
    private final PasswordEncoder pe;
    private final UserRepository users;
    private final JwtService jwt;

    public AuthController(AuthenticationManager am, PasswordEncoder pe, UserRepository users, JwtService jwt) {
        System.out.println("We have hit auth API");
        this.am = am;
        this.pe = pe;
        this.users = users;
        this.jwt = jwt;
    }

    @Validated
    public record RegisterRequest(@NotBlank @Size(min = 3, max = 30) String username, @NotBlank @Email String email,
                                  @NotBlank @Size(min = 8) String password,
                                  @Pattern(regexp = "player|team-admin|league-admin") String role) {
    }

    @Validated
    public record LoginRequest(@NotBlank String usernameOrEmail, @NotBlank String password) {
    }

    @Validated
    @PostMapping("/register")
    public Map<String, Object> register(@Valid @RequestBody RegisterRequest req) {
        // Defensive checks
        if (req.username() == null || req.email() == null || req.password() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username, email and password are required");
        }

        // Check if user exists by username or email
        boolean usernameExists = users.findByUsername(req.username()).isPresent();
        boolean emailExists = users.findByEmail(req.email()).isPresent();

        if (usernameExists || emailExists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }

        // Create and save new user
        User u = new User();
        u.setUsername(req.username());
        u.setEmail(req.email());
        u.setPassword(pe.encode(req.password()));
        u.setRole(req.role() == null ? "player" : req.role());

        users.save(u);

        System.out.println("Registered User: " + u);

        // Generate JWT token
        String token = jwt.generate(u.getId(), u.getUsername(), u.getRole());

        return Map.of(
                "token", token,
                "user", Map.of(
                        "id", u.getId(),
                        "username", u.getUsername(),
                        "role", u.getRole()
                )
        );
    }

    @Validated
    @PostMapping("/login")
    public Map<String, Object> login(@Valid @RequestBody LoginRequest req) {
        System.out.println("I have hit login");
        Authentication auth = am.authenticate(new UsernamePasswordAuthenticationToken(req.usernameOrEmail(), req.password()));
        UserPrincipal up = (UserPrincipal) auth.getPrincipal();
        String token = jwt.generate(up.getId(), up.getUsername(), up.getRole());
        return Map.of("token", token, "user", Map.of("id", up.getId(), "username", up.getUsername(), "role", up.getRole()));
    }
}