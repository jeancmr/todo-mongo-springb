package com.jean.todomongo.service;


import com.jean.todomongo.model.Todo;
import com.jean.todomongo.repository.TodoRepository;
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

    public Todo toggle(String id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow();

        todo.setCompleted(!todo.isCompleted());

        return todoRepository.save(todo);
    }

    public void delete(String id) {
        todoRepository.deleteById(id);
    }
}
