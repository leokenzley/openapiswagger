package com.leokenzley.openapiswagger.application.mapper;

import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.model.UserRequest;
import com.leokenzley.openapiswagger.model.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-29T14:27:39-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250325-2231, environment: Java 21.0.6 (Eclipse Adoptium)"
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
        userResponse.setName( domain.getName() );
        userResponse.setEmail( domain.getEmail() );
        userResponse.setCpf( domain.getCpf() );

        return userResponse;
    }
}
