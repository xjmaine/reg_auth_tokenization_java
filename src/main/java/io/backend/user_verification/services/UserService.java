package io.backend.user_verification.services;

import io.backend.user_verification.entities.User;
import io.backend.user_verification.notifications.ErrorMSG;
import io.backend.user_verification.registration.token.ConfirmationToken;
import io.backend.user_verification.registration.token.ConfirmationTokenService;
import io.backend.user_verification.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;

@Service
//@AllArgsConstructor //uncomment constructor if you dont use this
public class UserService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(String.valueOf(UserService.class));

    private final ErrorMSG errorMSG;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;


    public UserService(ErrorMSG errorMSG, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.errorMSG = errorMSG;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(String.format(errorMSG.getUSER_NOT_FOUND_MSG(), email)));
    }

    @Transactional
    public String signUpUser(User user){
        logger.info(errorMSG.getUSER_EMAIL_ALREADY_EXISTS_MSG());

        //check if user exists
        boolean ifUserExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if(ifUserExists){
            throw new IllegalStateException(errorMSG.getUSER_EMAIL_ALREADY_EXISTS_MSG());
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            logger.warning(errorMSG.getUSER_EMAIL_ALREADY_EXISTS_MSG()+ user.getEmail());
            throw new IllegalStateException(errorMSG.getUSER_EMAIL_ALREADY_EXISTS_MSG());
        }

        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        try {
            //TODO: send confirmation token email
            ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    user
            );

            confirmationTokenService.saveConfirmationToken(confirmationToken);
        } catch (Exception e) {
            throw new RuntimeException(errorMSG.getUNABLE_TO_GENERATE_TOKEN_MSG(), e);
        }

        //TODO: send email

        return token;

    }
}