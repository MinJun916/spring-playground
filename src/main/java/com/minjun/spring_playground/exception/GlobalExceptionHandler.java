package com.minjun.spring_playground.exception;

import com.minjun.spring_playground.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ResponseDTO<Void>> handleResponseStatusException(
      ResponseStatusException exception) {

    return ResponseEntity.status(exception.getStatusCode())
        .body(new ResponseDTO<>(false, exception.getReason(), null));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseDTO<Void>> handleValidationException(
      MethodArgumentNotValidException exception) {

    String message = exception.getBindingResult().getFieldErrors().getFirst().getDefaultMessage();

    return ResponseEntity.badRequest().body(new ResponseDTO<>(false, message, null));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ResponseDTO<Void>> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException exception) {
    return ResponseEntity.badRequest().body(new ResponseDTO<>(false, "Bad Request", null));
  }
}
