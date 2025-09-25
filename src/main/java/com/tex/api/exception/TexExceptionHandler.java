package com.tex.api.exception;

import com.tex.api.entity.ErrorEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TexExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorEntity> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorEntity error = new ErrorEntity("INVALID_ARGUMENT", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Handle @Valid validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorEntity> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Collect all field errors into a single message
        List<String> errorMessages = ex.getBindingResult()
                                       .getFieldErrors()
                                       .stream()
                                       .map(FieldError::getDefaultMessage)
                                       .collect(Collectors.toList());

        String combinedMessage = String.join("; ", errorMessages);

        ErrorEntity error = new ErrorEntity("VALIDATION_ERROR", combinedMessage);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorEntity> handleGenericException(Exception ex) {
        ErrorEntity error = new ErrorEntity("INTERNAL_ERROR", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
