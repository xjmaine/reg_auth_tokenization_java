//package io.backend.user_verification.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
////                .csrf().disable()
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authorize)->{
//                    authorize.requestMatchers("/api/v1/registration/**").permitAll();
//                    authorize.anyRequest().authenticated();
//                }).httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();
//    }
//
//
//
//
//}
