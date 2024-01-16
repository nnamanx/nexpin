package com.nnamanx.nexpin.auth;

import com.nnamanx.nexpin.config.JwtService;
import com.nnamanx.nexpin.model.dto.request.ClientRequest;
import com.nnamanx.nexpin.model.entity.Client;
import com.nnamanx.nexpin.model.enums.Role;
import com.nnamanx.nexpin.reposiotry.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(ClientRequest request) {
        var client = Client.builder()
                .fullName(request.getFullName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CLIENT)
                .build();
        repository.save(client);
        var jwtToken = jwtService.generateToken(client);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getFullName(),
                        request.getPassword()
                )
        );
        var client = repository.findByFullName(request.getFullName())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(client);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}