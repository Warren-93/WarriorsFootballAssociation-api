package mark.warren93.dev.WarriorsFootballAssociationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db-users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;
    private String firstName;
    private String surename;
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean admin;
    private String teamAssignedTo;

}
