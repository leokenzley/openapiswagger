package com.leokenzley.openapiswagger.application.service.implementation;

import com.leokenzley.openapiswagger.application.mapper.UserApplicationMapper;
import com.leokenzley.openapiswagger.application.service.UserService;
import com.leokenzley.openapiswagger.core.usecase.users.*;
import com.leokenzley.openapiswagger.model.UserRequest;
import com.leokenzley.openapiswagger.model.UserResponse;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * This class implements the UserService interface, providing methods for user-related operations.
 * It includes methods for retrieving, creating, updating, and deleting users.
 */
//@Service
public class UserServiceImpl{} /**implements UserService {

  private final CreateUserUseCase createUserUseCase;
  private final UpdateUserUseCase updateUserUseCase;
  private final GetUserUserCase getUserUserCase;
  private final GetAllUsersUseCase getAllUsersUseCase;
  private final DeleteUserUseCase deleteUserUseCase;
  
  /**
   * Constructor for UserServiceImpl.
   *
   * @param createUserUseCase Use case for creating a user
   * @param updateUserUseCase Use case for updating a user
   * @param getAllUsersUseCase Use case for retrieving all users
   */
//  public UserServiceImpl(CreateUserUseCase createUserUseCase,
//                         UpdateUserUseCase updateUserUseCase,
//                         GetAllUsersUseCase getAllUsersUseCase,
//                         GetUserUserCase getUserUserCase,
//                         DeleteUserUseCase deleteUserUseCase) {
//    this.createUserUseCase = createUserUseCase;
//    this.updateUserUseCase = updateUserUseCase;
//    this.getAllUsersUseCase = getAllUsersUseCase;
//    this.getUserUserCase = getUserUserCase;
//    this.deleteUserUseCase = deleteUserUseCase;
//  }
//
//  /**
//   * Retrieves a user by their ID.
//   *
//   * @param id the ID of the user to retrieve
//   * @return the user with the specified ID
//   */
//  @Override
//  public UserResponse getUserById(Long id) {
//    return UserApplicationMapper.INSTANCE.toResponse(getUserUserCase.execute(id));
//  }
//
//  /**
//   * Retrieves all users.
//   *
//   * @return a list of all users
//   */
//  @Override
//  public List<UserResponse> getAllUsers() {
//    return getAllUsersUseCase
//      .execute()
//      .stream()
//      .map(UserApplicationMapper.INSTANCE::toResponse).toList();
//  }
//
//  /**
//   * Creates a new user.
//   *
//   * @param request the user to create
//   */
//  @Override
//  public void createUser(UserRequest request) {
//    var userDomain = UserApplicationMapper.INSTANCE.toDomain(request);
//    createUserUseCase.execute(userDomain);
//  }
//
//  /**
//   * Updates an existing user.
//   *
//   * @param id         the ID of the user to update
//   * @param request the updated user information
//   */
//  @Override
//  public void updateUser(Long id, UserRequest request) {
//    updateUserUseCase.execute(id, UserApplicationMapper.INSTANCE.toDomain(request));
//  }
//
//  /**
//   * Deletes a user by their ID.
//   *
//   * @param id the ID of the user to delete
//   */
//  @Override
//  public void deleteUser(Long id) {
//    deleteUserUseCase.execute(id);
//  }
//}
