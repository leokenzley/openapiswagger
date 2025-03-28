package com.leokenzley.openapiswagger.dataprovider;

import com.leokenzley.openapiswagger.core.dataprovider.UpdateUserDataProvider;
import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.dataprovider.database.repository.UserRepository;
import com.leokenzley.openapiswagger.dataprovider.database.repository.mapper.UserMapper;
import com.leokenzley.openapiswagger.dataprovider.handler.exception.DataProviderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the UpdateUserDataProvider interface.
 */
@Repository
public class UpdateUserDataProviderImpl implements UpdateUserDataProvider {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;

  @Override
  public void execute(Long id, UserDomain userDomain) {
    var entity = userRepository.findById(id).orElseThrow(
        () -> new DataProviderNotFoundException("Usuário não encontrado"));
    userDomain.setId(id);
    userRepository.save(userMapper.toEntity(userDomain));
  }
}
