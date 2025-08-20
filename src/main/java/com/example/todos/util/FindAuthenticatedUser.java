package com.example.todos.util;

import com.example.todos.entity.User;

import java.nio.file.AccessDeniedException;

public interface FindAuthenticatedUser {

    User getAuthenticatedUser() throws AccessDeniedException;
}
