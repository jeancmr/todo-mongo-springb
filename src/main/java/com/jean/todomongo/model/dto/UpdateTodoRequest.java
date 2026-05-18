package com.jean.todomongo.model.dto;

import jakarta.validation.constraints.AssertTrue;

public record UpdateTodoRequest(

        String title,

        Boolean completed

) {

    @AssertTrue(message = "Title cannot be blank")
    public boolean isTitleValid() {

        return title == null || !title.trim().isEmpty();
    }

    @AssertTrue(message = "At least one field must be provided")
    public boolean hasFieldsToUpdate() {

        return title != null || completed != null;
    }
}