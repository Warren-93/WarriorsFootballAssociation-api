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
public class Player extends PlayerStats{

        @Id
        private String ObjectId;
        private String teamName;
        private String name;
        private int squad_number;
        private String position;

        private PlayerStats playerStats;

    public Player(String name, int squad_number, String position, String teamName, PlayerStats playerStats) {
        this.teamName = teamName;
        this.name = name;
        this.squad_number = squad_number;
        this.position = position;
        this.playerStats = playerStats;
    }
}
