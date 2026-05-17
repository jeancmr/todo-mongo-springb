package com.jean.todomongo.controller;

import com.jean.todomongo.model.Todo;
import com.jean.todomongo.service.TodoService;
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
    public Todo create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PatchMapping("/{id}/toggle")
    public Todo toggle(@PathVariable String id) {
        return todoService.toggle(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        todoService.delete(id);
    }
}
