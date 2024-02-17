package com.ericoliveiras.oferecaaqui.domain.service.payload.request;

import java.util.UUID;

public class CreateServiceRequest {
  public UUID userID;
  public String name;
  public String description;
  public Double price;

  public UUID getUserID() {
    return userID;
  }

  public void setUserID(UUID userID) {
    this.userID = userID;
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
}
