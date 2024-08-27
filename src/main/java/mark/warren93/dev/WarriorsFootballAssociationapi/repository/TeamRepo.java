package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepo extends MongoRepository<Team, ObjectId> {

    List<Team> findAll();
    //Optional<Team> findByTeamId(String teamId);

    List<Team> findTeamByTeamName(String team_name);
}
