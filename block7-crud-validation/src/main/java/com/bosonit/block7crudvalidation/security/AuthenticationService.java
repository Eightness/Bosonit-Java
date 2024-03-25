/**
 * @author Albert Lozano Blasco
 * @version 13.0
 */

package com.bosonit.block7crudvalidation.security;

import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.respository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    // Attributes
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Methods
    public AuthenticationResponse register(RegisterRequest request) {
        var person = Person.builder()
                .login(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Person.Role.USER)
                .build();
        personRepository.save(person);
        var jwtToken = jwtService.generateToken(person);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var person = personRepository.findByLogin(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        var jwtToken = jwtService.generateToken((UserDetails) person);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
