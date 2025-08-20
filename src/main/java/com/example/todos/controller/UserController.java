package com.example.todos.controller;

import com.example.todos.request.PasswordUpdateRequest;
import com.example.todos.response.UserResponse;
import com.example.todos.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User REST API Endpoints", description = "Operations related to info about current user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "User Information", description = "Get Current User Info")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public UserResponse getUserInfo() throws AccessDeniedException {
        return userService.getUserInfo();
    }

    @Operation(summary = "Delete User ", description = "Delete Current User Account")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteUser() throws AccessDeniedException {
        userService.deleteUser();
    }

    @Operation(summary = "Password Update", description = "Change User Password After Verification")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/password")
    public void passwordUpdate(@Valid @RequestBody PasswordUpdateRequest passwordUpdateRequest) throws Exception {
        userService.updatePassword(passwordUpdateRequest);
    }
}
