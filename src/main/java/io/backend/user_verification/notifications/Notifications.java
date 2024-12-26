package io.backend.user_verification.notifications;

import org.springframework.stereotype.Component;



@Component
public class Notifications {

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
    private final String TOKEN_NOT_FOUND_MSG = "Token could not be found";
    private final String EMAIL_ALREADY_CONFIRM_MSG = "Email already confirmed";
    private final String TOKEN_EXPIRED_MSG = "Token expired!";
    private final String CONFIRM_EMAIL_MSG = "Confirm Your Email";
    private final String FAILED_TO_SEND_EMAIL_MSG = "Failed to send email";
    private final  String CONFIRMED_MSG = "Confirmed";

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

    public String getTOKEN_NOT_FOUND_MSG() {
        return TOKEN_NOT_FOUND_MSG;
    }

    public String getEMAIL_ALREADY_CONFIRM_MSG() {
        return EMAIL_ALREADY_CONFIRM_MSG;
    }

    public String getTOKEN_EXPIRED_MSG() {
        return TOKEN_EXPIRED_MSG;
    }

    public String getCONFIRM_EMAIL_MSG(){
        return CONFIRM_EMAIL_MSG;
    }

    public String getFAILED_TO_SEND_EMAIL_MSG() {
        return FAILED_TO_SEND_EMAIL_MSG;
    }

    public String getCONFIRMED_MSG() {
        return CONFIRMED_MSG;
    }

}


