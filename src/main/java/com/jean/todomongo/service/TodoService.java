package com.jean.todomongo.service;


import com.jean.todomongo.model.Todo;
import com.jean.todomongo.model.dto.UpdateTodoRequest;
import com.jean.todomongo.repository.TodoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo update(String id, @Valid UpdateTodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow();

        if (request.title() != null) {
            todo.setTitle(request.title());
        }

        if (request.completed() != null) {
            todo.setCompleted(request.completed());
        }

        return todoRepository.save(todo);
    }

    public void delete(String id) {
        todoRepository.deleteById(id);
    }


}
