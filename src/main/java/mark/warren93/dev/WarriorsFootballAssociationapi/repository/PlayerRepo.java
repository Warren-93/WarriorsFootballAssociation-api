package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepo extends MongoRepository<Player, ObjectId> {

    List<Player> findAllPlayersByTeamName(String team_name);

    List<Player> findAllPlayers();

}
