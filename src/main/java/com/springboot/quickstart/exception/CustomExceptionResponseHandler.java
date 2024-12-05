package com.springboot.quickstart.exception;

import com.springboot.quickstart.model.users.UserNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionResponseHandler extends ResponseEntityExceptionHandler {
    // So the ResponseEntityExceptionHandler is responsible for handling
    // all the exceptions raised by spring MVC



    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),
                request.getDescription(false));
        // So over here what we are doing here is we are making use of our own customer exception message strcture and
        // we are returning back as response with the help of ResponseEntity
        return  new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundExceptionException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),
                request.getDescription(false));
        // So over here what we are doing here is we are making use of our own customer exception message strcture and
        // we are returning back as response with the help of ResponseEntity
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }


}
