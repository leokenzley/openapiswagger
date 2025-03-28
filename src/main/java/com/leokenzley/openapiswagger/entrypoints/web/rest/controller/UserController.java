package com.leokenzley.openapiswagger.entrypoints.web.rest.controller;

import com.leokenzley.openapiswagger.api.UsersApi;
import com.leokenzley.openapiswagger.application.mapper.UserApplicationMapper;
import com.leokenzley.openapiswagger.core.usecase.users.*;
import com.leokenzley.openapiswagger.model.UserRequest;
import com.leokenzley.openapiswagger.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author leokenzley
 * @date 2023/10/12
 */
@RestController
public class UserController implements UsersApi {

  private final CreateUserUseCase createUserUseCase;
  private final UpdateUserUseCase updateUserUseCase;
  private final GetAllUsersUseCase getAllUsersUseCase;
  private final GetUserUserCase getUserUserCase;
  private final DeleteUserUseCase deleteUserUseCase;
  private final UserApplicationMapper mapper;

  public UserController(
      CreateUserUseCase createUserUseCase,
      UpdateUserUseCase updateUserUseCase,
      GetAllUsersUseCase getAllUsersUseCase,
      GetUserUserCase getUserUserCase,
      DeleteUserUseCase deleteUserUseCase,
      UserApplicationMapper mapper) {
    this.createUserUseCase = createUserUseCase;
    this.updateUserUseCase = updateUserUseCase;
    this.getAllUsersUseCase = getAllUsersUseCase;
    this.getUserUserCase = getUserUserCase;
    this.deleteUserUseCase = deleteUserUseCase;
    this.mapper = mapper;
  }

  @Override
  public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
    createUserUseCase.execute(mapper.toDomain(userRequest));
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> deleteUserById(Integer id) {
    deleteUserUseCase.execute(Long.valueOf(id));
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<UserResponse> getUserById(Integer id) {
    return ResponseEntity.ok(mapper.toResponse(getUserUserCase.execute(Long.valueOf(id))));
  }

  @Override
  public ResponseEntity<UserResponse> updateUser(Integer id, UserRequest userRequest) {
    return ResponseEntity.noContent().build();
  }
}
