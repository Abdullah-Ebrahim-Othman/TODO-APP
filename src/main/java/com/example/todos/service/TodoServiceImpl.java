package com.example.todos.service;

import com.example.todos.entity.Todo;
import com.example.todos.entity.User;
import com.example.todos.repository.TodoRepository;
import com.example.todos.request.TodoRequest;
import com.example.todos.response.TodoResponse;
import com.example.todos.util.FindAuthenticatedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public TodoServiceImpl(TodoRepository todoRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.todoRepository = todoRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }


    @Override
    @Transactional
    public List<TodoResponse> getAllTodos() throws AccessDeniedException {
        User user = findAuthenticatedUser.getAuthenticatedUser();
        return todoRepository.findByOwner(user).
                stream()
                .map(this::convertToTodoResponse)
                .toList();
    }

    @Override
    @Transactional
    public TodoResponse createTodo(TodoRequest todoRequest) throws AccessDeniedException {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Todo todo = new Todo(
                todoRequest.getTitle(),
                todoRequest.getDescription(),
                todoRequest.getPriority(),
                false,
                currentUser
        );

        Todo savedTodo = todoRepository.save(todo);

       return convertToTodoResponse(savedTodo);
    }

    @Override
    @Transactional
    public TodoResponse toggleTodoCompletion(long id) throws AccessDeniedException {
        User user = findAuthenticatedUser.getAuthenticatedUser();

        Optional<Todo> optionalTodo = todoRepository.findByIdAndOwner(id, user);
        if (optionalTodo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }

        optionalTodo.get().setComplete(!optionalTodo.get().isComplete());

        Todo updatedTodo = todoRepository.save(optionalTodo.get());

        return convertToTodoResponse(updatedTodo);
    }

    @Override
    @Transactional
    public void deleteTodo(long id) throws AccessDeniedException {

        User user = findAuthenticatedUser.getAuthenticatedUser();
        Optional<Todo> optionalTodo = todoRepository.findByIdAndOwner(id, user);
        if (optionalTodo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
        todoRepository.delete(optionalTodo.get());
    }

    private TodoResponse convertToTodoResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getPriority(),
                todo.isComplete()
        );
    }
}
