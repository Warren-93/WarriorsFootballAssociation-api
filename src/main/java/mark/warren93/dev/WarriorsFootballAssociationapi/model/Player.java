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
public class Player {
        @Id
        private String playerId;
        private String teamName;
        private String name;
        private int squad_number;
        private String position;
        private PlayerStats playerStats;
}
