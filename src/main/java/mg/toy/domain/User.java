package mg.toy.domain;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private String createdAt;
    private String updatedAt;
}
