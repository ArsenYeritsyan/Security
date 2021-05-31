package com.example.demo.todo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

public class ToDoValidationError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors = new ArrayList<>();
    private final String errorMessage;

    public ToDoValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void addValidationError(String errorMessage){
        errors.add(errorMessage);
    }

    public List<String> getErrors() {
        return errors;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
