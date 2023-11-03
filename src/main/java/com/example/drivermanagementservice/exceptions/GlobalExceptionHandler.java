package com.example.drivermanagementservice.exceptions;

import com.example.drivermanagementservice.dtos.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                        WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTimestamp(new Date());
        errorDetails.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DriverNotAvailableException.class)
    public ResponseEntity<ErrorDetails> handleDriverNotAvailableException(DriverNotAvailableException ex,
                                                                           WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTimestamp(new Date());
        errorDetails.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
    }
}
