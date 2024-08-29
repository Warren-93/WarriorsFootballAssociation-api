package mark.warren93.dev.WarriorsFootballAssociationapi.service;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.PlayerRepo;
import mark.warren93.dev.WarriorsFootballAssociationapi.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private TeamRepo teamRepo;

    public List<Player> findAllPlayer() {
        return playerRepo.findAll();  // Uses the standard findAll() method
    }

    public Optional<Player> findPlayerByPlayerName(String playerName) {
        return playerRepo.findSinglePlayerByPlayerName(playerName);
    }

    public Player createPlayer(Player player, String teamName){
    Optional<Team> teamOptional = teamRepo.findTeamByTeamName(teamName);
    System.out.println(teamOptional);

        if (teamOptional.isPresent()) {
            System.out.println("We are in the if of present optional");
            Team team = teamOptional.get();
            Player savedPlayer = playerRepo.save(player); // Save the player first
            team.getPlayers().add(player); // Add the player to the team
            teamRepo.save(team); // Save the updated team
            return savedPlayer;
        } else {
            throw new RuntimeException("Team not found with name: " + teamName);
        }
    }

}
