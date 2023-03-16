package com.hubertpa.sidepa.sidepa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubertpa.sidepa.sidepa.model.Demande;
import com.hubertpa.sidepa.sidepa.model.dto.DemandeCourtDTO;
import com.hubertpa.sidepa.sidepa.model.dto.DemandeDetailDTO;
import com.hubertpa.sidepa.sidepa.repository.DemandeRepository;

@Service
public class DemandeService {

	@Autowired
	DemandeRepository demandeRepository;

	public List<Demande> recuperationDesDemandes() {
		return StreamSupport.stream(demandeRepository.findAll().spliterator(), false).toList();
	}

	public Demande recuperationDemandeDepuisID(Long id) {
		DemandeDetailDTO demandeDetailDTO = null;
		Optional<Demande> demandeOPT = demandeRepository.findById(id);

		if (demandeOPT.isPresent()) {
		}
		return demandeOPT.get();
	}

	public List<DemandeCourtDTO> recuperationDesDemandesSimple() {
		return StreamSupport.stream(demandeRepository.findAll().spliterator(), false).map(DemandeCourtDTO::convertToDTO)
				.toList();
	}
}
