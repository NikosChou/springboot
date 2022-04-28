package de.choustoulakis.example.restapi.service;

import de.choustoulakis.example.model.ApiGender;
import de.choustoulakis.example.model.ApiUser;
import de.choustoulakis.example.restapi.persistence.entities.UserEntity;
import de.choustoulakis.example.restapi.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

  private UserRepository userRepository;

  public List<ApiUser> getAllUsers() {
    return this.userRepository.findAll().stream().map(this::mapToApiModel).toList();
  }

  private ApiUser mapToApiModel(UserEntity entity) {
    return ApiUser.builder()
        .id(entity.getUuid())
        .firstName(entity.getFirstName())
        .name(entity.getLastName())
        .gender(Objects.equals(entity.getGender(), "f") ? ApiGender.FEMALE : ApiGender.MALE)
        .createdAt(entity.getCreatedAt())
        .build();
  }
}
