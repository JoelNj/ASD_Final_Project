package org.example.survey.config;

import lombok.RequiredArgsConstructor;
import org.example.survey.model.Permission;
import org.example.survey.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity//we discuss it tomorrow
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(
                        request ->
                                request.requestMatchers("/api/v1/auth/*").permitAll()
                                    .requestMatchers("/api/v1/categories/{categoryId}/questions/{questionId}/answers/**").hasRole(Role.ADMIN.name())
                                        .requestMatchers("/api/v1/users/{userId}/assesments/**").hasRole(Role.ADMIN.name())
                                        .requestMatchers( "/api/v1/users/{userId}/assesments/{assesmentId}/assesmentquestions/**").hasRole(Role.ADMIN.name())
                                        .requestMatchers("/api/v1/categories/**").hasRole(Role.ADMIN.name())
                                        .requestMatchers( "/api/v1/categories/{categoryId}/questions").hasRole(Role.ADMIN.name())
                                        .requestMatchers("/api/v1/users/**").hasRole(Role.ADMIN.name())
                                        .anyRequest()
                                        .authenticated()
                )
                .authenticationProvider(authenticationProvider)
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http. build();
    }
}
