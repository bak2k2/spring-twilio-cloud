package io.pivotal.pcf.haash.repository;

import io.pivotal.pcf.haash.model.Service;

import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, String> {
}
