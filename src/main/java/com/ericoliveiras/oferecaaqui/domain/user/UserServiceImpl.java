package com.ericoliveiras.oferecaaqui.domain.user;

import com.ericoliveiras.oferecaaqui.domain.user.payload.request.CreateUserRequest;
import com.ericoliveiras.oferecaaqui.domain.user.payload.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }
  @Override
  public UserResponse create(CreateUserRequest createUserRequest) {
    User user = userMapper.toEntity(createUserRequest);
    user.password = hashPassword(user.getPassword());
    return userMapper.toDto(userRepository.save(user));
  }

  @Override
  public UserResponse find(UUID id) {
    return userMapper.toDto(findUser(id));
  }

  @Override
  public List<UserResponse> findAll() {
    Page<User> users = userRepository.findAll(
      PageRequest.of(0, 20, Sort.by("fullName"))
    );
    return users
      .stream()
      .map(userMapper::toDto)
      .collect(Collectors.toList());
  }

  private User findUser(UUID id) {
    return userRepository
      .findById(id)
      .orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
      );
  }

  private String hashPassword(String password) {
    return passwordEncoder.encode(password);
  }
}
