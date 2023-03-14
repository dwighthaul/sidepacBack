package com.hubertpa.sidepa.sidepa.controller.routing;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubertpa.sidepa.sidepa.model.Demande;
import com.hubertpa.sidepa.sidepa.model.dto.DemandeCourtDTO;
import com.hubertpa.sidepa.sidepa.repository.DemandeRepository;
import com.hubertpa.sidepa.sidepa.service.DemandeService;

@RestController
@RequestMapping("/data/demande/")
//@CrossOrigin(origins = "http://localhost:4200")
public class DemandeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	DemandeRepository demandeRepository;

	@Autowired
	DemandeService demandeService;

	@GetMapping(path = "all")
	List<Demande> trouverToutesDemandes() {
		return demandeService.recuperationDesDemandes();
	}

	@GetMapping(path = "allSimple")
	List<DemandeCourtDTO> trouverToutesDemandesSimple() {
		return demandeService.recuperationDesDemandesSimple();
	}

	@GetMapping(path = "parId")
	Optional<Demande> recuperationDemande(@RequestParam Long id) {
		return demandeService.recuperationDemandeDepuisID(id);

	}

}
