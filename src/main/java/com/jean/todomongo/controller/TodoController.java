package com.jean.todomongo.controller;

import com.jean.todomongo.model.Todo;
import com.jean.todomongo.model.dto.CreateTodoRequest;
import com.jean.todomongo.model.dto.UpdateTodoRequest;
import com.jean.todomongo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
        public Todo create(@Valid @RequestBody CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .title(request.title())
                .completed(false)
                .build();
            return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PatchMapping("/{id}")
    public Todo update(
            @PathVariable String id,
            @Valid @RequestBody UpdateTodoRequest request
    ) {
        return todoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        todoService.delete(id);
    }
}
