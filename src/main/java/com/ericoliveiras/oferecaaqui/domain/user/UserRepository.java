package com.ericoliveiras.oferecaaqui.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
  User findByEmail(String email);
  User findByDocumentID(String documentID);
}
