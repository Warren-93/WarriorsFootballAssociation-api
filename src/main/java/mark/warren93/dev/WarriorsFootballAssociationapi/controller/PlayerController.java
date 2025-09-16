package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import jakarta.validation.Valid;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerRepository repo;

    public PlayerController(PlayerRepository r) {
        System.out.println("We have hit Players API");
        this.repo = r;
    }

    @GetMapping
    public List<Player> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Player one(@PathVariable String id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found: " + id));
    }

    @GetMapping("/team/{teamId}")
    public List<Player> byTeam(@PathVariable String teamId) {
        return repo.findByTeamId(teamId);
    }

    @PostMapping
    public Player create(@Valid @RequestBody Player p) {
        return repo.save(p);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable String id, @Valid @RequestBody Player p) {
        p.setId(id);
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
