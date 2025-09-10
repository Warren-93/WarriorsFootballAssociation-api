package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "matches")
public class Match {
    @Id
    private String id;

    private String divisionId;
    private String homeTeamId;
    private String awayTeamId;

    // e.g. "scheduled", "in-progress", "finished"
    private String status;

    private Result result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
        private int homeScore;
        private int awayScore;
    }
}
