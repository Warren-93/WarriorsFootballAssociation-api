package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Division;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DivisionRepository extends MongoRepository<Division, String> {
}