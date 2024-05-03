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
    private ObjectId teamId;
    private String team_name;
    private List<Player> players;

    public Team(String team_name, List<Player> players) {
        this.teamId = teamId;
        this.team_name = team_name;
        this.players = players;
    }
}
