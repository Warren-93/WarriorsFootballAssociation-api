package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "players")
public class Player {
    @Id
    private String id;
    @NotBlank
    private String userId;
    private String teamId;
    @NotBlank
    private String name;
    @Pattern(regexp = "GK|DEF|MID|FWD")
    private String position;
    @Min(0)
    @Max(99)
    private Integer number;
    @Min(0)
    private int appearances = 0;
    @Min(0)
    private int goals = 0;
    @Min(0)
    private int assists = 0;
    @Min(0)
    private int cleanSheets = 0;
}
