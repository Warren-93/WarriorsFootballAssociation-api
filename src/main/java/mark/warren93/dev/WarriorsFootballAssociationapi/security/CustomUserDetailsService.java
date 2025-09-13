package mark.warren93.dev.WarriorsFootballAssociationapi.security;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository users;

    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Try username first
        Optional<User> u = users.findByUsername(usernameOrEmail);

        // If not found, try email
        if (u.isEmpty()) {
            u = users.findByEmail(usernameOrEmail);
        }

        // If still not found, throw error
        return new UserPrincipal(
                Optional.ofNullable(u.orElseThrow(() -> new UsernameNotFoundException("User not found: " + usernameOrEmail)))
        );
    }
}
