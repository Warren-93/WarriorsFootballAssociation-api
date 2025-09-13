package mark.warren93.dev.WarriorsFootballAssociationapi.security;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository user;

    public CustomUserDetailsService(UserRepository u) {
        this.user = u;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> u = user.findByUsername(usernameOrEmail);
        if (u == null) u = user.findByEmail(usernameOrEmail);
        if (u == null) throw new UsernameNotFoundException("User not found");
        return new UserPrincipal(u);
    }
}