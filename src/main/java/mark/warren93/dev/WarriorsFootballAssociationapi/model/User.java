package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 12)
    private String password;

    // restrict role values, default "player"
    @NotBlank
    @Pattern(regexp = "player|team-admin|league-admin")
    private String role = "player";

    @Size(max = 50)
    private String displayName;

    private String avatarUrl;
}
