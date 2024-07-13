package com.alura.forohub.controller;


import com.alura.forohub.domain.infra.security.TokenJWT;
import com.alura.forohub.domain.infra.security.TokenService;
import com.alura.forohub.domain.topic.user.AuthenticationData;
import com.alura.forohub.domain.topic.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJWT> authenticate(@RequestBody @Valid AuthenticationData userCredentials){
        Authentication authToken = new UsernamePasswordAuthenticationToken(userCredentials.email(), userCredentials.password());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(jwtToken));
    }
}

