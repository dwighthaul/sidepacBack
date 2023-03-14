package com.hubertpa.sidepa.sidepa.repository;

import org.springframework.data.repository.CrudRepository;

import com.hubertpa.sidepa.sidepa.model.RefEtat;

public interface RefEtatRepository extends CrudRepository<RefEtat, Long> {

	RefEtat findByCode(String code);
}
