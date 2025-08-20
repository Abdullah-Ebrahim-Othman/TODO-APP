package com.example.todos.service;

import com.example.todos.request.TodoRequest;
import com.example.todos.response.TodoResponse;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface TodoService {

    List<TodoResponse> getAllTodos() throws AccessDeniedException;

    TodoResponse createTodo(TodoRequest todoRequest) throws AccessDeniedException;

    TodoResponse toggleTodoCompletion(long id) throws AccessDeniedException;

    void deleteTodo(long id) throws AccessDeniedException;
}
