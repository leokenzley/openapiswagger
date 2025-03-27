package com.leokenzley.openapiswagger.entrypoints.web.rest.controller;

import com.leokenzley.openapiswagger.api.UsersApi;
import com.leokenzley.openapiswagger.model.UserRequest;
import com.leokenzley.openapiswagger.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsersApi {
    @Override
    public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(Integer id, UserRequest userRequest) {
        return null;
    }
}
