package io.backend.user_verification.registration;

import io.backend.user_verification.UserRole;
import io.backend.user_verification.entities.User;
import io.backend.user_verification.notifications.ErrorMSG;
import io.backend.user_verification.services.UserService;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ErrorMSG errorMSG;

    public RegistrationService(UserService userService, EmailValidator emailValidator, ErrorMSG errorMSG) {
        this.userService = userService;
        this.emailValidator = emailValidator;
        this.errorMSG = errorMSG;
    }

    public String register(RegistrationRequest request) {
        //validate user via email

        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {

            throw new IllegalStateException(errorMSG.getINVALID_EMAIL_MSG());
        }

        return userService.signUpUser(new User(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
        ));
    }


}