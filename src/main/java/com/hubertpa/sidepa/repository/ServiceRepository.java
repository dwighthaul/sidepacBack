package com.hubertpa.sidepa.repository;

import org.springframework.data.repository.CrudRepository;

import com.hubertpa.sidepa.model.Service;

public interface ServiceRepository extends CrudRepository<Service, Long> {

	Service findByPath(String path);
}
