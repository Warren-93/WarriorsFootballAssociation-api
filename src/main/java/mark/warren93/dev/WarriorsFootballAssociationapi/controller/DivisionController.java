package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Division;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.DivisionRepository;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisions")
public class DivisionController {
    private final DivisionRepository repo;

    public DivisionController(DivisionRepository r) {
        System.out.println("We have hit divisions API");
        this.repo = r;
    }

    @GetMapping
    public List<Division> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Division one(@PathVariable String id) {
        return repo.findById(id).orElseThrow();
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN')")
    @PostMapping
    public Division create(@Valid @RequestBody Division d) {
        return repo.save(d);
    }

    @PreAuthorize("hasAnyRole('LEAGUE_ADMIN','TEAM_ADMIN')")
    @PutMapping("/{id}")
    public Division update(@PathVariable String id, @Valid @RequestBody Division d) {
        d.setId(id);
        return repo.save(d);
    }

    @PreAuthorize("hasRole('LEAGUE_ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}