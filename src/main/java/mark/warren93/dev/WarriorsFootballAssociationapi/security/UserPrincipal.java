package mark.warren93.dev.WarriorsFootballAssociationapi.security;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.text.html.Option;
import java.util.*;

public class UserPrincipal implements UserDetails {
    private final Optional<User> user;

    public UserPrincipal(Optional<User> u) {
        this.user = u;
    }

    public String getId() {
        return user.get().getId();
    }

    public String getRole() {
        return user.get().getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String r = user.get().getRole() == null ? "player" : user.get().getRole();
        String role = switch (r) {
            case "team-admin" -> "ROLE_TEAM_ADMIN";
            case "league-admin" -> "ROLE_LEAGUE_ADMIN";
            default -> "ROLE_PLAYER";
        };
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return user.get().getPassword();
    }

    @Override
    public String getUsername() {
        return user.get().getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}