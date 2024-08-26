package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "db-team.players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

        @Id
        private int playerId;
        private String name;
        private int squad_number;
        private String position;

    public Player(String name, int squad_number, String position) {
        this.name = name;
        this.squad_number = squad_number;
        this.position = position;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
