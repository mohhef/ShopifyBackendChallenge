package com.imagenest.exception;

import com.imagenest.exception.ExceptionType.IdNotFoundException;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IOException.class)
  public final ResponseEntity<Object> handleIoExceptions(Exception ex) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(
            HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "IO exception has occured");
    return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
  }


  @ExceptionHandler(IdNotFoundException.class)
  public final ResponseEntity<Object> handleIdNotFoundException(Exception ex) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(
            HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "Verify the Id of your request");
    return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
  }

}