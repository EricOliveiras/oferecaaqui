package com.ericoliveiras.oferecaaqui.domain.user;

import com.ericoliveiras.oferecaaqui.domain.user.payload.request.CreateUserRequest;
import com.ericoliveiras.oferecaaqui.domain.user.payload.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface IUserService {
  UserResponse create(CreateUserRequest createUserRequest);
  UserResponse find(UUID id);
  UserResponse findByEmail(String email);
  UserResponse findByDocumentID(String documentID);
  List<UserResponse> findAll();
}
