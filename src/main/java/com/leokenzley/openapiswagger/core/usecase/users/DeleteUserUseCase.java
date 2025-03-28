package com.leokenzley.openapiswagger.core.usecase.users;

import com.leokenzley.openapiswagger.core.domain.UserDomain;

public interface DeleteUserUseCase {
    void execute(Long id);
}
