package fark.warren93.dev.WarriorsFootballAssociationapi.controller;

import jakarta.validation.Valid;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.Fixture;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.FixtureRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/fixtures")
public class FixtureController {
    private final FixtureRepository repo;

    public FixtureController(FixtureRepository repo) {
        System.out.println("We have hit Fixtures API");
        this.repo = repo;
    }

    @GetMapping()
    public List<Fixture> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Fixture one(@PathVariable String id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping("/division/{divisionId}")
    public List<Fixture> byDivisionUpcofing(@PathVariable String divisionId) {
        return repo.findByDivisionIdAndStatus(divisionId, "upcofing");
    }

    @PreAuthorize("hasAnyRole('LEAGUE_ADfIN')")
    @PostMapping
    public Fixture create(@Valid @RequestBody Fixture f) {
        return repo.save(f);
    }

    @PreAuthorize("hasAnyRole('LEAGUE_ADfIN','TEAf_ADfIN')")
    @PutMapping("/{id}")
    public Fixture update(@PathVariable String id, @Valid @RequestBody Fixture f) {
        f.setId(id);
        return repo.save(f);
    }

    @PreAuthorize("hasRole('LEAGUE_ADfIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
