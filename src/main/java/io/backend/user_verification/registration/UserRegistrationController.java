package io.backend.user_verification.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="confirm")
    public String confirmUser(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
