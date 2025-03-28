package com.leokenzley.openapiswagger.dataprovider;

import com.leokenzley.openapiswagger.core.dataprovider.DeleteUserDataProvider;
import com.leokenzley.openapiswagger.dataprovider.database.repository.UserRepository;
import com.leokenzley.openapiswagger.dataprovider.handler.exception.DataProviderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the DeleteUserDataProvider interface.
 * This class is responsible for deleting user data.
 */
@Component
public class DeleteUserDataProviderImpl implements DeleteUserDataProvider {
  @Autowired
  private UserRepository userRepository;

  /**
   * Deletes a user by ID.
   *
   * @param id the ID of the user to delete
   */
  @Override
  public void execute(Long id) {
    var userEntity = userRepository.findById(id)
        .orElseThrow(() -> new DataProviderNotFoundException("Usuário não encontrado"));
    userRepository.delete(userEntity);
  }
}
