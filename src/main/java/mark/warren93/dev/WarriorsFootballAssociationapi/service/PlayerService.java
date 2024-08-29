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
    public Player createPlayer(Player player, String teamName) {
        // Find the team by its name
        Optional<Team> teamOptional = teamRepo.findTeamByTeamName(teamName);

        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            System.out.println("Team found: " + team.getTeamName());

            // Set the team for the player if your model requires it
            //player.setTeam(team); // Ensure Player class has setTeam() method if necessary

            // Save the player
            Player savedPlayer = playerRepo.save(player);

            // Add the player to the team
            team.getPlayers().add(savedPlayer);

            // Save the updated team
            teamRepo.save(team);

            return savedPlayer;
        } else {
            throw new RuntimeException("Team not found with name: " + teamName);
        }
    }

}
