package io.pivotal.pcf.haash.repository;

import io.pivotal.pcf.haash.model.ServiceBinding;

import org.springframework.data.repository.CrudRepository;

public interface ServiceBindingRepository extends CrudRepository<ServiceBinding,String> {
}
