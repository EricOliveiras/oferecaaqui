package com.ericoliveiras.oferecaaqui.domain.service;

import com.ericoliveiras.oferecaaqui.domain.service.payload.request.CreateServiceRequest;
import com.ericoliveiras.oferecaaqui.domain.service.payload.response.ServiceResponse;

import java.util.List;

public interface IServiceResource {
  ServiceResponse create(CreateServiceRequest createServiceRequest);
  ServiceResponse find(Long id);
  List<ServiceResponse> findAll();
}
