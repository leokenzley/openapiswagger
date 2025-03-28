package com.leokenzley.openapiswagger.configurations.usecase.users;

import com.leokenzley.openapiswagger.core.dataprovider.DeleteUserDataProvider;
import com.leokenzley.openapiswagger.core.dataprovider.GetAllUsersDataProvider;
import com.leokenzley.openapiswagger.core.dataprovider.GetUserDataProvider;
import com.leokenzley.openapiswagger.core.dataprovider.UpdateUserDataProvider;
import com.leokenzley.openapiswagger.core.usecase.users.GetAllUsersUseCase;
import com.leokenzley.openapiswagger.core.usecase.users.implementation.*;
import com.leokenzley.openapiswagger.dataprovider.CreateUserDataProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for User Use Cases.
 * This class defines the beans for the use cases related to user operations.
 */
@Configuration
public class UserUserCaseConfig {
  /**
   * Bean for CreateUserUseCaseImpl.
   *
   * @param dataProvider the data provider for creating users
   * @return an instance of CreateUserUseCaseImpl
   */
  @Bean
  public CreateUserUseCaseImpl createUserUseCase(CreateUserDataProviderImpl dataProvider) {
    return new CreateUserUseCaseImpl(dataProvider);
  }

  /**
   * Bean for UpdateUserUseCaseImpl.
   *
   * @param getUserDataProvider the data provider for getting users
   * @param updateUserDataProvider the data provider for updating users
   * @return an instance of UpdateUserUseCaseImpl
   */
  @Bean
  public UpdateUserUseCaseImpl updateUserUseCase(
      GetUserDataProvider getUserDataProvider,
      UpdateUserDataProvider updateUserDataProvider) {
    return new UpdateUserUseCaseImpl(getUserDataProvider, updateUserDataProvider);
  }

  @Bean
  public GetUserUseCaseImpl getUserUseCase(GetUserDataProvider getUserDataProvider) {
    return new GetUserUseCaseImpl(getUserDataProvider);
  }

  @Bean
  public DeleteUserUseCaseImpl deleteUserUseCase(
      DeleteUserDataProvider deleteUserDataProvider,
      GetUserDataProvider getUserDataProvider) {
    return new DeleteUserUseCaseImpl(deleteUserDataProvider, getUserDataProvider);
  }

  @Bean
  public GetAllUserUseCaseImpl getAllUserUseCase(
      GetAllUsersDataProvider getAllUsersDataProvider) {
    return new GetAllUserUseCaseImpl(getAllUsersDataProvider);
  }
}
