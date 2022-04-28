package de.choustoulakis.example.restapi.controller;

import de.choustoulakis.example.api.UsersApi;
import de.choustoulakis.example.model.ApiUsers;
import de.choustoulakis.example.restapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
@AllArgsConstructor
public class UsersController implements UsersApi {

  private UserService userService;

  @Override
  public ResponseEntity<ApiUsers> getAllUsers() {
    var users = userService.getAllUsers();

    return log.traceExit(ResponseEntity.ok(ApiUsers.builder().data(users).build()));
  }
}
