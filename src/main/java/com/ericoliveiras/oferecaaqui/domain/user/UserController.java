package com.ericoliveiras.oferecaaqui.domain.user;

import com.ericoliveiras.oferecaaqui.config.error.CustomException;
import com.ericoliveiras.oferecaaqui.domain.user.payload.request.CreateUserRequest;
import com.ericoliveiras.oferecaaqui.domain.user.payload.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
  private final IUserService service;

  public UserController(IUserService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<UserResponse> create(@RequestBody CreateUserRequest createUserRequest) {
    if (
      service.findByEmail(createUserRequest.email) != null
        || service.findByDocumentID(createUserRequest.documentID) != null
    ) {
      throw new CustomException("User already exists", HttpStatus.CONFLICT);
    }
    UserResponse userResponse = service.create(createUserRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
  }

  @GetMapping
  public ResponseEntity<List<UserResponse>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> find(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.find(UUID.fromString(id)));
  }
}
