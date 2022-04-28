package de.choustoulakis.example.restapi.controller;

import de.choustoulakis.example.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(ApiException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiError returnError(ApiException exception) {
    var apiError = new ApiError();
    apiError.setCode(400);
    apiError.setMessage(exception.getMessage());
    return apiError;
  }
}
