package io.backend.user_verification.registration;

import lombok.*;

@Getter
//@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String username;
    private final String password;
    private final String email;

    public RegistrationRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
        public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}


