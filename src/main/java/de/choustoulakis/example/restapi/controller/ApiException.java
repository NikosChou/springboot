package de.choustoulakis.example.restapi.controller;

public class ApiException extends Exception {
  public ApiException(String message) {
    super(message);
  }
}
