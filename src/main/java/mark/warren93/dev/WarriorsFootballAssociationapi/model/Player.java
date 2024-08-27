package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db-players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player{

        @Id
        private String ObjectId;
        private String name;
        private int squad_number;
        private String position;
        private String teamName;

        private PlayerStats playerStats;

    public Player(String name, int squad_number, String position, String teamName, PlayerStats playerStats) {
        this.name = name;
        this.squad_number = squad_number;
        this.position = position;
        this.teamName = teamName;
        this.playerStats = playerStats;
    }

    public String getObjectId() {
        return ObjectId;
    }

    public void setObjectId(String ObjectId) {
        this.ObjectId = ObjectId;
    }
}
