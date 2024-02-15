package com.ericoliveiras.oferecaaqui.domain.user;

import com.ericoliveiras.oferecaaqui.domain.user.payload.request.CreateUserRequest;
import com.ericoliveiras.oferecaaqui.domain.user.payload.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
  private final IUserService service;

  public UserController(IUserService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<UserResponse> create(@RequestBody CreateUserRequest createUserRequest) {
    UserResponse userResponse = service.create(createUserRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
  }

  @GetMapping
  public ResponseEntity<List<UserResponse>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
  }
}
