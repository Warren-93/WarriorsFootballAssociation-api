package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.TeamRepository;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamRepository repo;

    public TeamController(TeamRepository r) {
        System.out.println("We have hit Teams API");
        this.repo = r;
    }

    @GetMapping
    public List<Team> all() {
        return repo.findAll();
    }

    @Validated
    @GetMapping("/{id}")
    public Team one(@PathVariable String id) {

        return repo.findById(id).orElseThrow();
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN')")
    @PostMapping
    public Team create(@Valid @RequestBody Team t) {
        return repo.save(t);
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN') or @authz.isTeamAdmin(authentication, #id)")
    @PutMapping("/{id}")
    public Team update(@PathVariable String id, @Valid @RequestBody Team t) {
        t.setId(id);
        return repo.save(t);
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}