package mark.warren93.dev.WarriorsFootballAssociationapi.security;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository users;

    public CustomUserDetailsService(UserRepository u) {
        this.users = u;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User u = users.findByUsername(usernameOrEmail);
        if (u == null) u = users.findByEmail(usernameOrEmail);
        if (u == null) throw new UsernameNotFoundException("User not found");
        return new UserPrincipal(u);
    }
}