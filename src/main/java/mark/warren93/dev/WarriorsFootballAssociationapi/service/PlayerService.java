package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public List<Player> findAllPlayer() {
        return playerRepo.findAll();  // Uses the standard findAll() method
    }

    public Optional<Player> findPlayerByPlayerName(String playerName) {
        return playerRepo.findSinglePlayerByPlayerName(playerName);
    }
}
