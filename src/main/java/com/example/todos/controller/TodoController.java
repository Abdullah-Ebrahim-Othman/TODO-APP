package com.example.todos.controller;

import com.example.todos.request.TodoRequest;
import com.example.todos.response.TodoResponse;
import com.example.todos.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Tag(name = "Todo REST API Endpoints", description = "Operations for managing User todos")
@RequestMapping("/api/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(summary = "Get all todos for user", description = "Fetch All Todos For the signed in user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TodoResponse> getAllTodos() throws AccessDeniedException {
        return todoService.getAllTodos();
    }

    @Operation(summary = "Create Todo for User", description = "Create todo for the signed in user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TodoResponse createTodo(@Valid @RequestBody TodoRequest todoRequest) throws AccessDeniedException {
        return todoService.createTodo(todoRequest);
    }

    @Operation(summary = "Update Todo for User", description = "Update todo for the signed in user")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public TodoResponse toggleTodoCompletion(@PathVariable @Min(1) long id) throws AccessDeniedException {
        return todoService.toggleTodoCompletion(id);
    }

    @Operation(summary = "Delete Todo for User", description = "Delete todo for the signed in user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{/id}")
    public void deleteTodo(@PathVariable @Min(1) long id) throws AccessDeniedException {
        todoService.deleteTodo(id);
    }

}
