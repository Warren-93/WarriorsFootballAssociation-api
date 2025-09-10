package mark.warren93.dev.WarriorsFootballAssociationapi.repository;

import mark.warren93.dev.WarriorsFootballAssociationapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String u);
    User findByEmail(String e);
}