package mark.warren93.dev.WarriorsFootballAssociationapi.security;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.TeamRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("authz")
public class AuthzService {
    private final TeamRepository teams;

    public AuthzService(TeamRepository t) {
        this.teams = t;
    }

    public boolean isLeagueAdmin(Authentication auth) {
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_LEAGUE_ADMIN"));
    }

    public boolean isTeamAdmin(Authentication auth, String teamId) {
        if (auth == null || teamId == null) return false;
        Object p = auth.getPrincipal();
        if (!(p instanceof UserPrincipal up)) return false;
        if (isLeagueAdmin(auth)) return true;
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_TEAM_ADMIN"))) return false;
        Team t = teams.findById(teamId).orElse(null);
        if (t == null || t.getAdmins() == null) return false;
        return t.getAdmins().stream().anyMatch(id -> id.equals(up.getId()));
    }
}