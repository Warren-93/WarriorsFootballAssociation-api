package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import jakarta.validation.Valid;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository repo;

    public UserController(UserRepository r) {
        this.repo = r;
    }

    @GetMapping
    public List<User> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public User one(@PathVariable String id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id));
    }

    @PostMapping
    public User create(@Valid @RequestBody User u) {
        return repo.save(u);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @Valid @RequestBody User u) {
        return repo.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
