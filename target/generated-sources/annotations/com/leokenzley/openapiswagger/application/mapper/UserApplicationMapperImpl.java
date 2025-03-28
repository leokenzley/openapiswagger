package com.leokenzley.openapiswagger.application.mapper;

import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.model.UserRequest;
import com.leokenzley.openapiswagger.model.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-27T22:02:14-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 24 (Amazon.com Inc.)"
)
@Component
public class UserApplicationMapperImpl implements UserApplicationMapper {

    @Override
    public UserDomain toDomain(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserDomain userDomain = new UserDomain();

        if ( request.getId() != null ) {
            userDomain.setId( request.getId().longValue() );
        }
        userDomain.setName( request.getName() );
        userDomain.setEmail( request.getEmail() );
        userDomain.setCpf( request.getCpf() );

        return userDomain;
    }

    @Override
    public UserResponse toResponse(UserDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        if ( domain.getId() != null ) {
            userResponse.setId( domain.getId().intValue() );
        }

        return userResponse;
    }
}
