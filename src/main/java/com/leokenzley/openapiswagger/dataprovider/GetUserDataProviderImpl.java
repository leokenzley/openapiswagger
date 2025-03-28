package com.leokenzley.openapiswagger.dataprovider;

import com.leokenzley.openapiswagger.core.dataprovider.GetUserDataProvider;
import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.dataprovider.database.repository.UserRepository;
import com.leokenzley.openapiswagger.dataprovider.database.repository.mapper.UserMapper;
import com.leokenzley.openapiswagger.dataprovider.handler.exception.DataProviderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the GetUserDataProviderImpl interface.
 */
@Component
public class GetUserDataProviderImpl implements GetUserDataProvider {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserMapper mapper;

  @Override
  public UserDomain get(Long id) {
    var userEntity = userRepository.findById(id)
         .orElseThrow(() -> new DataProviderNotFoundException("User not found"));
    return mapper.toDomain(userEntity);
  }
}
