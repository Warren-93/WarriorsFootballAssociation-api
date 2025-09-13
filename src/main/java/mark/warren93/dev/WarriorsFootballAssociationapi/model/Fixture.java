package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "fixtures")
public class Fixture {
    @Id
    private String id;

    private String divisionId;
    private String homeTeam;
    private String awayTeam;
    private String date;
    private String status;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
        private int homeScore;
        private int awayScore;
    }
}
