package com.leokenzley.openapiswagger.core.dataprovider;

import com.leokenzley.openapiswagger.core.domain.UserDomain;
import java.util.List;

/**
 * Interface for getting all users data provider.
 * This interface defines the method for retrieving all users.
 */
public interface GetAllUsersDataProvider {
  /**
   * Retrieves all users.
   *
   * @return a list of UserDomain objects representing all users
   */
  List<UserDomain> get();
}
