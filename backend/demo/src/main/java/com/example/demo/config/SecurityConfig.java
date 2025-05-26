package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/api/employee", true)
                        .permitAll()
                )
                .httpBasic(Customizer.withDefaults()) // ✅ Enable Basic Auth for tools like Postman
                .logout(logout -> logout
                        .logoutSuccessUrl("/home")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // Disable CSRF for API testing (not for production)

        return http.build();
    }
}
