package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import mark.warren93.dev.WarriorsFootballAssociationapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
    @Autowired
    private PlayerService service;
    @PostMapping("/createPlayer")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player, @RequestParam String teamName) {
        try {
            Player createPlayer = service.createPlayer(player, teamName);
            return new ResponseEntity<>(createPlayer, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Catch in controller !!!!!!!!!!!!!!!!!!!!!!");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/allPlayers")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> allPlayers = service.findAllPlayer();
        System.out.println(allPlayers);
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }
    @GetMapping("/playerByPlayerName")
    public ResponseEntity<Optional<Player>> getSinglePlayerByPlayerName(@RequestParam String playerName) {
        Optional<Player> findPlayerByPlayerName = service.findPlayerByPlayerName(playerName);
        return new ResponseEntity<>(findPlayerByPlayerName, HttpStatus.OK);
    }
}
