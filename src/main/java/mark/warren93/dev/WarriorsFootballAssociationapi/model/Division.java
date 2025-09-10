package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "divisions")
public class Division {
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String season;
    private List<String> teams;
}