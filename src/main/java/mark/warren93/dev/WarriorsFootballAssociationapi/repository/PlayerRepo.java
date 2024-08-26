package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends MongoRepository<Player, ObjectId> {

    List<Player> findAllPlayersByTeamName(String team_name);

    List<Player> findAllPlayers();

}
