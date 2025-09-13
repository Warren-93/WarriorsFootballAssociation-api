package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.Fixture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixtureRepository extends MongoRepository<Fixture, String> {
    List<Fixture> findByDivisionIdAndStatus(String divisionId, String upcoming);

}
