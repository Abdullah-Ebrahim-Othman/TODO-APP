package com.example.todos.controller;

import com.example.todos.request.AuthenticationRequest;
import com.example.todos.request.RegisterRequest;
import com.example.todos.response.AuthenticationResponse;
import com.example.todos.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication REST API Endpoints", description = "Operations related to register & Login")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "Register a user", description = "Create a new User in Database")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody RegisterRequest registerRequest) throws Exception {
        authenticationService.register(registerRequest);
    }

    @Operation(summary = "Login a User", description = "Submit a email and password to authenticate the user")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public AuthenticationResponse login(@Valid @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return authenticationService.login(authenticationRequest);
    }
}
