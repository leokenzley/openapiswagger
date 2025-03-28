package com.leokenzley.openapiswagger.core.dataprovider;

import com.leokenzley.openapiswagger.core.domain.UserDomain;

/**
 * Interface for updating a user data provider.
 * This interface defines the method for updating a user.
 */
public interface UpdateUserDataProvider { void execute(Long id, UserDomain userDomain); }
