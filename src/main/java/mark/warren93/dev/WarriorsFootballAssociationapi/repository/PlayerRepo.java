package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends MongoRepository<Player, String> {

    // Standard method to fetch all players
    List<Player> findAll();  // This is the correct method to use instead of findAllPlayers()

    @Query("{'team_name': ?0}")  // MongoDB query to find players by team name
    List<Player> findAllPlayersByTeamName(String teamName);
}
