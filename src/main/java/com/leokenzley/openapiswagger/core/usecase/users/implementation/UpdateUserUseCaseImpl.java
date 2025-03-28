package com.leokenzley.openapiswagger.core.usecase.users.implementation;

import com.leokenzley.openapiswagger.core.dataprovider.GetUserDataProvider;
import com.leokenzley.openapiswagger.core.dataprovider.UpdateUserDataProvider;
import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.core.usecase.users.UpdateUserUseCase;

/**
 * Implementation of the UpdateUserUseCase interface.
 */
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
  private final UpdateUserDataProvider updateUserDataProvider;

  /**
   * Constructor for UpdateUserUseCaseImpl.
   *
   * @param updateUserDataProvider the data provider for updating users
   */
  public UpdateUserUseCaseImpl(
          GetUserDataProvider getUserDataProvider,
          UpdateUserDataProvider updateUserDataProvider) {
    this.updateUserDataProvider = updateUserDataProvider;
  }

  @Override
  public void execute(Long id, UserDomain userDomain) {
    updateUserDataProvider.execute(id, userDomain);
  }
}
