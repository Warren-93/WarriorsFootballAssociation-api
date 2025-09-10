package mark.warren93.dev.WarriorsFootballAssociationapi.repository; import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team; import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeamRepository extends MongoRepository<Team,String>{ Team findByName(String name);
    List<Team> findByDivisionId(String divisionId);
}