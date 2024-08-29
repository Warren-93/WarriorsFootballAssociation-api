package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "db-teams")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Team {
    @Id
    private ObjectId ObjectId;
    private int teamId;
    private String teamName;
    private List<Player> players;
    public Team(int teamId, String teamName, List<Player> players) {
        this.teamId = teamId+=1;
        this.teamName = teamName;
        this.players = players;
    }
    public ObjectId getObjectId() {
        return ObjectId;
    }
    public void setObjectId(ObjectId objectId) {
        ObjectId = objectId;
    }
}