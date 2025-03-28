package com.leokenzley.openapiswagger.application.service;

import com.leokenzley.openapiswagger.model.UserRequest;
import com.leokenzley.openapiswagger.model.UserResponse;
import java.util.List;

/**
 * This interface defines the contract for user-related operations.
 * It includes methods for retrieving, creating, updating, and deleting users.
 */
public interface UserService {
  /**
   * Retrieves a user by their ID.
   *
   * @param id the ID of the user to retrieve
   * @return the user with the specified ID
   */
  UserResponse getUserById(Long id);

  /**
   * Retrieves all users.
   *
   * @return a list of all users
   */
  List<UserResponse> getAllUsers();

  /**
   * Creates a new user.
   *
   * @param request the user to create
   */
  void createUser(UserRequest request);

  /**
   * Updates an existing user.
   *
   * @param id         the ID of the user to update
   * @param request the updated user information
   */
  void updateUser(Long id, UserRequest request);

  /**
   * Deletes a user by their ID.
   *
   * @param id the ID of the user to delete
   */
  void deleteUser(Long id);
}
