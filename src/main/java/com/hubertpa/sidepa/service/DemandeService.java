package com.hubertpa.sidepa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubertpa.sidepa.model.Demande;
import com.hubertpa.sidepa.model.dto.DemandeCourtDTO;
import com.hubertpa.sidepa.repository.DemandeRepository;

@Service
public class DemandeService {

	@Autowired
	DemandeRepository demandeRepository;

	public void sauvegarderDemande(Demande demande) {
		demandeRepository.save(demande);
	}

	public List<Demande> recuperationDesDemandes() {
		return StreamSupport.stream(demandeRepository.findAll().spliterator(), false).toList();
	}

	public Optional<Demande> recuperationDemandeDepuisID(Long id) {
		return demandeRepository.findById(id);
	}

	public List<DemandeCourtDTO> recuperationDesDemandesSimple() {
		return StreamSupport.stream(demandeRepository.findAll().spliterator(), false).map(DemandeCourtDTO::convertToDTO)
				.toList();
	}
}
