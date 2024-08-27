package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public List<Player> findAllPlayer() {
        return playerRepo.findAll();  // Uses the standard findAll() method
    }

    public List<Player> findPlayerByPlayerName(String playerName) {
        return playerRepo.findSinglePlayerByPlayerName(playerName);
    }
}
