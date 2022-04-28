package de.choustoulakis.example.restapi.service;

import de.choustoulakis.example.restapi.persistence.entities.UserEntity;
import de.choustoulakis.example.restapi.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {

  private UserService sut;
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);
    this.sut = new UserService(userRepository);
  }

  @Test
  void shouldGetAllUsers() {
    when(userRepository.findAll()).thenReturn(List.of(UserEntity.builder().build()));

    var actual = this.sut.getAllUsers();

    assertThat(actual).hasSize(1);
  }
}
