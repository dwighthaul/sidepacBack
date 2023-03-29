package com.hubertpa.sidepa.repository;

import org.springframework.data.repository.CrudRepository;

import com.hubertpa.sidepa.model.RefTypeLigne;

public interface RefTypeLigneRepository extends CrudRepository<RefTypeLigne, Long> {

	RefTypeLigne findByCode(String code);
}
