package com.leokenzley.openapiswagger.dataprovider;

import com.leokenzley.openapiswagger.core.dataprovider.CreateUserDataProvider;
import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.dataprovider.database.entity.UserEntity;
import com.leokenzley.openapiswagger.dataprovider.database.repository.UserRepository;
import com.leokenzley.openapiswagger.dataprovider.database.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the CreateUserDataProvider interface.
 * This class is responsible for creating a new user in the database.
 */
@Component
public class CreateUserDataProviderImpl implements CreateUserDataProvider {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;

  @Override
  public void execute(UserDomain userDomain) {
    UserEntity entity = userMapper.toEntity(userDomain);
    userRepository.save(entity);
  }
}
