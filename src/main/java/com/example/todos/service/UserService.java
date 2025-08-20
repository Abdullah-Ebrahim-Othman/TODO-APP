package com.example.todos.service;

import com.example.todos.request.PasswordUpdateRequest;
import com.example.todos.response.UserResponse;

import java.nio.file.AccessDeniedException;

public interface UserService {

    UserResponse getUserInfo() throws AccessDeniedException;
    void deleteUser() throws AccessDeniedException;
    void updatePassword(PasswordUpdateRequest passwordUpdateRequest) throws AccessDeniedException;
}
