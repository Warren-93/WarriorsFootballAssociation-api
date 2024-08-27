package mark.warren93.dev.WarriorsFootballAssociationapi.controller;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import mark.warren93.dev.WarriorsFootballAssociationapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
        @Autowired
        private PlayerService service;

        @GetMapping("/allPlayers")
        public ResponseEntity<List<Player>> getPlayers() {
            List<Player> allPlayers = service.findAllPlayer();
            System.out.println(allPlayers);
            return new ResponseEntity<>(allPlayers, HttpStatus.OK);
        }

    @GetMapping("/playerByPlayerName")
    public ResponseEntity<List<Player>> getSinglePlayerByPlayerName(@RequestParam String playerName){
        List<Player> findPlayerByPlayerName = service.findPlayerByPlayerName(playerName);
        return new ResponseEntity<>(findPlayerByPlayerName, HttpStatus.OK);
    }
}
