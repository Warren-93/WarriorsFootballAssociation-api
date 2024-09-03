package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    private final UserService userService;
    //private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //private final String SECRET_KEY = "$EsmieWarren17042023Bella";

    @Autowired
    public UserAuthService(UserService userService) {
        this.userService = userService;
    }

    public User authLoginRequest(String username, String password) {
        System.out.println("AuthLogin");
        User user = userService.getUserByUsername(username);

        System.out.println(user);
        System.out.println(user.getPassword());
        System.out.println(password);
        if (password.equals(user.getPassword())){
            return user;
        } else {
            throw new IllegalArgumentException("Invalid Credentials");
        }
    }
}
