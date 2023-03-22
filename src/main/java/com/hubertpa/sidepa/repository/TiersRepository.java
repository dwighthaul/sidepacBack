package com.hubertpa.sidepa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hubertpa.sidepa.model.Tiers;

public interface TiersRepository extends CrudRepository<Tiers, Long> {

	Optional<Tiers> findByNumeroTiers(String numeroTiers);

	@Query("SELECT t FROM Tiers t WHERE t.numeroTiers LIKE %?1% OR t.nomOuRaisonSocial LIKE %?1%")
	public List<Tiers> findByNumeroOuNom(String nomOuNumero);
}
