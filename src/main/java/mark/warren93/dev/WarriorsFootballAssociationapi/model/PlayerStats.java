package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db-players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStats extends Player{

    private int goals;
    private int assists;
    private int appearances;

}
