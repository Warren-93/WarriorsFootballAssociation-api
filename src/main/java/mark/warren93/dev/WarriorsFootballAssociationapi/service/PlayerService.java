package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;

import mark.warren93.dev.WarriorsFootballAssociationapi.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepo playerRepo;
    public List<Player> findAllPlayer() {
        return playerRepo.getAllPlayers();
    }
    public List<Player> getAllPlayersByTeam(String team_name) {
        return playerRepo.getAllPlayersByTeamName(team_name);
    }
}
