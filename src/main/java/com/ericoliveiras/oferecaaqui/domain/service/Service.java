package com.ericoliveiras.oferecaaqui.domain.service;

import com.ericoliveiras.oferecaaqui.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "services")
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  public User user;
  public String name;
  public String description;
  public Double price;
  public LocalDate createdAt;
  public LocalDate updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDate.now();
    updatedAt = LocalDate.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDate.now();
  }

  public Service() {
  }

  public Service(
    Long id,
    User user,
    String name,
    String description,
    Double price,
    LocalDate createdAt,
    LocalDate updatedAt) {
    this.id = id;
    this.user = user;
    this.name = name;
    this.description = description;
    this.price = price;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }
}
