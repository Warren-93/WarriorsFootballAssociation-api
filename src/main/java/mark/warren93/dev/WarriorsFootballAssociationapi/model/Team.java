package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "teams")
public class Team {
    @Id
    private String id;

    private String divisionId;
    private String name;
    private int points;
    private int goalDiff;
    private int goalsFor;
    private int goalsAgainst;
    private int rank;
    private List<String> admins; // for AuthzService checks
}
