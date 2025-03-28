package com.leokenzley.openapiswagger.core.dataprovider;

import com.leokenzley.openapiswagger.core.domain.UserDomain;

/**
 * Interface for getting a user data provider.
 * This interface defines the method for retrieving a user by ID.
 */
public interface GetUserDataProvider { UserDomain get(Long id); }
