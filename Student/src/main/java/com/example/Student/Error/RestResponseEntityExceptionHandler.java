package com.example.Student.Error;

import com.example.Student.Entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.xml.sax.ErrorHandler;

import java.util.logging.ErrorManager;

@RestControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorMessage> userNotFound(UserNotFound notFound,WebRequest webRequest)
    {
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,notFound.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
