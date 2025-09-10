package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "teams")
public class Team {
    @Id
    private String id;

    @NotBlank
    private String divisionId;

    @NotBlank
    private String name;

    private String logoUrl;

    @Min(0)
    private int played;

    @Min(0)
    private int wins;

    @Min(0)
    private int draws;

    @Min(0)
    private int losses;

    @Min(0)
    private int goalsFor;

    @Min(0)
    private int goalsAgainst;

    private int goalDiff;

    @Min(0)
    private int points;

    // Used by AuthzService
    private List<String> admins;

    // Not persisted in MongoDB, used only in standings computation
    @Transient
    private int rank;
}
