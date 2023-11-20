package com.persona.demo_personas.Exceptions;

import com.persona.demo_personas.Exceptions.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LocalNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> localNotFoundException(LocalNotFoundException exception){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(EmailExist.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ErrorMessage> emailExist(EmailExist emailExist){
        ErrorMessage message = new ErrorMessage(HttpStatus.ACCEPTED, emailExist.getMessage());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }
}
