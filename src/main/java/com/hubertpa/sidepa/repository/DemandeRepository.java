package com.hubertpa.sidepa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hubertpa.sidepa.model.Demande;

public interface DemandeRepository extends CrudRepository<Demande, Long> {

	Optional<Demande> findByDescription(String description);
}
