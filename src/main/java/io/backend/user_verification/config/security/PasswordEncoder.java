package io.backend.user_verification.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Configuration
public class PasswordEncoder {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password(bCryptPasswordEncoder().encode("john"))
//                .roles("USER")
//                .build();
//
//        UserDetails sam = User.builder()
//                .username("sam")
//                .password(bCryptPasswordEncoder().encode("sam"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,sam);
//    }
}
