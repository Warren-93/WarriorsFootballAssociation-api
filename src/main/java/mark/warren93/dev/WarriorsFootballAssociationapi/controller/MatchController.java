package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Match;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.MatchRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    private final MatchRepository repo;

    public MatchController(MatchRepository r) {
        System.out.println("We have hit Match API");
        this.repo = r;
    }

    @GetMapping
    public List<Match> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Match one(@PathVariable String id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found: " + id));
    }

    @GetMapping("/division/{divisionId}")
    public List<Match> byDivisionUpcoming(@PathVariable String divisionId) {
        return repo.findByDivisionIdAndStatus(divisionId, "upcoming");
    }

    @PreAuthorize("hasAnyRole('LEAGUE_ADMIN','TEAM_ADMIN')")
    @PostMapping
    public Match create(@Valid @RequestBody Match m) {
        return repo.save(m);
    }

    @PreAuthorize("hasAnyRole('LEAGUE_ADMIN','TEAM_ADMIN')")
    @PutMapping("/{id}")
    public Match update(@Valid @RequestBody Match m) {
        return repo.save(m);
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
