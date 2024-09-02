package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import mark.warren93.dev.WarriorsFootballAssociationapi.service.UserAuthService;
import mark.warren93.dev.WarriorsFootballAssociationapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    UserAuthService userAuthService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>("User Created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestParam String username, @RequestParam String password) {
        Logger logger = LoggerFactory.getLogger(UserController.class);

        try {
            logger.info("Login controller hit");

            // Validate input
            if (username == null || username.isEmpty()) {
                return ResponseEntity.badRequest().body("Username is required.");
            }
            if (password == null || password.isEmpty()) {
                return ResponseEntity.badRequest().body("Password is required.");
            }

            // Attempt to authenticate
            String loginResponse = userAuthService.authLoginRequest(username, password);

            if (loginResponse != null) {
                return ResponseEntity.ok(loginResponse);  // Return successful login response
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            logger.error("Error during login", e);

            // Return a generic error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the login request.");
        }
    }
}
