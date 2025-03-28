package com.leokenzley.openapiswagger.dataprovider.database.repository.mapper;

import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.dataprovider.database.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-27T22:04:39-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 24 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserDomain userDomain) {
        if ( userDomain == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName( userDomain.getName() );
        userEntity.setEmail( userDomain.getEmail() );
        userEntity.setCpf( userDomain.getCpf() );
        userEntity.setId( userDomain.getId() );

        return userEntity;
    }

    @Override
    public UserDomain toDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDomain userDomain = new UserDomain();

        userDomain.setId( userEntity.getId() );
        userDomain.setName( userEntity.getName() );
        userDomain.setEmail( userEntity.getEmail() );
        userDomain.setCpf( userEntity.getCpf() );

        return userDomain;
    }
}
