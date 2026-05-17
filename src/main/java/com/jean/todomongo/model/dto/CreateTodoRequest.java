package com.jean.todomongo.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTodoRequest(

        @NotBlank(message = "Title is required")
        String title
) {
}
