package com.hubertpa.sidepa.controller.routing;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubertpa.sidepa.model.Demande;
import com.hubertpa.sidepa.model.dto.DemandeCourtDTO;
import com.hubertpa.sidepa.service.DemandeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/data/demande/")
public class DemandeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	DemandeService demandeService;

	@PostMapping(path = "update", consumes = "application/json")
	void mettreAJourDemande(@RequestBody Demande demande, HttpServletRequest request) {
		demande.setDescription("Toto");
		logger.info(demande.toString());

		demandeService.sauvegarderDemande(demande);
	}

	@GetMapping(path = "all", produces = "application/json")
	List<Demande> trouverToutesDemandes() {
		return demandeService.recuperationDesDemandes();
	}

	@GetMapping(path = "allSimple", produces = "application/json")
	List<DemandeCourtDTO> trouverToutesDemandesSimple() {
		return demandeService.recuperationDesDemandesSimple();
	}

	@GetMapping(path = "parId", produces = "application/json")
	Optional<Demande> recuperationDemande(@RequestParam Long id) {
		return demandeService.recuperationDemandeDepuisID(id);

	}

}
