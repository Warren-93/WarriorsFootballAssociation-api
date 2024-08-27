package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db-players.stats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStats{

    private int goals;
    private int assists;
    private int appearances;

}
