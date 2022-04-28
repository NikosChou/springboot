package de.choustoulakis.example.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.choustoulakis.example.model.ApiUser;
import de.choustoulakis.example.model.ApiUsers;
import de.choustoulakis.example.restapi.service.UserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UsersController.class)
public class UsersControllerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @MockBean private UserService userService;

  @Test
  @SneakyThrows
  void shouldGetAllUsers() {
    when(userService.getAllUsers()).thenReturn(List.of(new ApiUser(), new ApiUser()));
    var response =
        mockMvc
            .perform(get("/api/v1/users"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn();

    var json = response.getResponse().getContentAsString();
    var users = objectMapper.readValue(json, ApiUsers.class);

    assertThat(users).isNotNull();
    assertThat(users.getData()).isNotNull();
    assertThat(users.getData()).hasSize(2);
  }
}
