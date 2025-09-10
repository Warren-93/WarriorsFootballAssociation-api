package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Fixture;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.FixtureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fixtures")
public class FixtureController {
    private final FixtureRepository repo;

    public FixtureController(FixtureRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Fixture> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Fixture one(@PathVariable String id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Fixture create(@RequestBody Fixture fixture) {
        return repo.save(fixture);
    }
}
