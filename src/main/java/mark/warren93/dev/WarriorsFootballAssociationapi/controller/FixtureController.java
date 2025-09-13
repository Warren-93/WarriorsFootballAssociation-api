package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import jakarta.validation.Valid;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.Fixture;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.FixtureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/fixtures")
public class FixtureController {
    private final FixtureRepository repo;

    public FixtureController(FixtureRepository repo) {
        System.out.println("We have hit Fixtures API");
        this.repo = repo;
    }

    @GetMapping
    public List<Fixture> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Fixture one(@PathVariable String id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fixture not found: " + id));
    }

    @GetMapping("/division/{divisionId}")
    public List<Fixture> byDivisionUpcoming(@PathVariable String divisionId) {
        return repo.findByDivisionIdAndStatus(divisionId, "upcoming");
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN')")
    @PostMapping
    public Fixture create(@Valid @RequestBody Fixture f) {
        return repo.save(f);
    }

    @PreAuthorize("hasAnyRole('LEAGUE_ADMIN','TEAM_ADMIN')")
    @PutMapping("/{id}")
    public Fixture update(@PathVariable String id, @Valid @RequestBody Fixture f) {
        f.setId(id);
        return repo.save(f);
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
