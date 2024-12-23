package io.backend.user_verification.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;



@Component
public class ErrorMSG {

    /**
     * Formats the user not found message with the provided email.
     *
     * @param email the email that was not found.
     * @return the formatted error message.
     */

    private final String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final String INVALID_EMAIL_MSG = "Email is not valid!";
    private final String SIGN_UP_SUCCESS_MSG = "User signed up successfully!";
    private final String USER_EMAIL_ALREADY_EXISTS_MSG = "User email %s already exists!";
    private final String UNABLE_TO_GENERATE_TOKEN_MSG = "Token could not be generated";

    public String getUSER_NOT_FOUND_MSG() {
        return USER_NOT_FOUND_MSG;
    }

    public String getINVALID_EMAIL_MSG() {
        return INVALID_EMAIL_MSG;
    }

    public String getSIGN_UP_SUCCESS_MSG() {
        return SIGN_UP_SUCCESS_MSG;
    }

    public String getUSER_EMAIL_ALREADY_EXISTS_MSG() {
        return USER_EMAIL_ALREADY_EXISTS_MSG;
    }

    public String getUNABLE_TO_GENERATE_TOKEN_MSG(){
        return UNABLE_TO_GENERATE_TOKEN_MSG;
    }
}


