package com.hubertpa.sidepa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hubertpa.sidepa.model.Tiers;

public interface TiersRepository extends CrudRepository<Tiers, Long> {

	Optional<Tiers> findByNumeroTiers(String numeroTiers);
}
