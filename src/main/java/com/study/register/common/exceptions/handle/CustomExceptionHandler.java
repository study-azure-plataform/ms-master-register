package com.study.register.common.exceptions.handle;


import com.study.register.common.exceptions.data.ErrorMessage;
import com.study.register.common.exceptions.data.ErrorMessageFieldsValid;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errors.add("[Field] "+error.getField() + ": " + error.getDefaultMessage());});

        ex.getBindingResult().getGlobalErrors().forEach(error->{
            errors.add("[ObjectName] "+error.getObjectName() + ": " + error.getDefaultMessage());});

        var body = ErrorMessageFieldsValid.builder()
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .messages(errors)
                .description(request.getDescription(false))
                .build();

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException ex) {

        var message = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Error Constraint Violation: "+ ex.getMessage())
                .cause(ex.getCause().getMessage())
                .build();

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

