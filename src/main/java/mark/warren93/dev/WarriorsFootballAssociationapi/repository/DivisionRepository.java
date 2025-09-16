package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Division;
import mark.warren93.dev.WarriorsFootballAssociationapi.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DivisionRepository extends MongoRepository<Division, String> {

}
