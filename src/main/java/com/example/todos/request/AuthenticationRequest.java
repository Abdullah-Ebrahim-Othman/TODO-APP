package com.example.todos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AuthenticationRequest {

    @NotEmpty(message = "Email is Mandatory")
    @Email
    private String email;

    @NotEmpty(message = "Password is Mandatory")
    @Size(min = 5, max = 30, message = "Password must be at least 5 Characters long")
    private String password;

    public @NotEmpty(message = "Email is Mandatory") @Email String getEmail() {
        return email;
    }

    public @NotEmpty(message = "Password is Mandatory") @Size(min = 5, max = 30, message = "Password must be at least 5 Characters long") String getPassword() {
        return password;
    }
}
