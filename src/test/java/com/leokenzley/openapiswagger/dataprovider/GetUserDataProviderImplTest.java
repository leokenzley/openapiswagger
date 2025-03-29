package com.leokenzley.openapiswagger.dataprovider;

import com.leokenzley.openapiswagger.core.domain.UserDomain;
import com.leokenzley.openapiswagger.dataprovider.database.entity.UserEntity;
import com.leokenzley.openapiswagger.dataprovider.database.repository.UserRepository;
import com.leokenzley.openapiswagger.dataprovider.database.repository.mapper.UserMapper;
import com.leokenzley.openapiswagger.dataprovider.handler.exception.DataProviderNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GetUserDataProviderImplTest {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private GetUserDataProviderImpl getUserDataProvider;

    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        getUserDataProvider = new GetUserDataProviderImpl();

        setPrivateField(getUserDataProvider, "userRepository", userRepository);
        setPrivateField(getUserDataProvider, "mapper", userMapper);
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGet_UserExists() {
        Long userId = 1L;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        UserDomain expectedUser = new UserDomain(userId, "John Doe", "john.doe@example.com", "123.456.789-00");

        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        when(userMapper.toDomain(userEntity)).thenReturn(expectedUser);

        UserDomain actualUser = getUserDataProvider.get(userId);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGet_UserNotFound() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(DataProviderNotFoundException.class, () -> getUserDataProvider.get(userId));
    }
}