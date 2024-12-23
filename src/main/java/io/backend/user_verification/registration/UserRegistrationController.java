package io.backend.user_verification.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
//@AllArgsConstructor
public class UserRegistrationController {

    private final RegistrationService registrationService;

    public UserRegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }


    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
}
