package org.example.survey.auth;

import lombok.RequiredArgsConstructor;
import org.example.survey.config.JwtService;
import org.example.survey.model.Category;
import org.example.survey.model.User;
import org.example.survey.repository.CategoryRepository;
import org.example.survey.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        Optional<Category> category = categoryRepository.findByLabel("Computer Science");
        Category categoryToUSe = null;
        if (category.isPresent()) {
            categoryToUSe = category.get();
        }
        //Construct user object from registerRequest
        User user = new User(
                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.username(),
                passwordEncoder.encode(registerRequest.password()),
                registerRequest.role(),
                categoryToUSe
        );
        //save the user
        User registeredUser = userRepository.save(user);
        //generate token
        String token = jwtService.generateToken(registeredUser);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.username(),
                        authenticationRequest.password()
                )
        );
        //Now authentication is successfully
        //Next, generate token for this authenticated user
//        Principal principal = authentication.getPrincipal();
        User user = (User)authentication.getPrincipal();
//        User user = (User) userDetailsService.loadUserByUsername(authenticationRequest.username());
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
