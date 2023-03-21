package com.hubertpa.sidepa.repository;

import org.springframework.data.repository.CrudRepository;

import com.hubertpa.sidepa.model.RefEtat;

public interface RefEtatRepository extends CrudRepository<RefEtat, Long> {

	RefEtat findByCode(String code);
}
