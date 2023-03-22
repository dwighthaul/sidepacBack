package com.hubertpa.sidepa.controller.routing;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubertpa.sidepa.model.Tiers;
import com.hubertpa.sidepa.repository.TiersRepository;

@RestController
@RequestMapping("/data/tiers/")
public class TiersController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	TiersRepository tiersRepository;

	@GetMapping(path = "all", produces = "application/json")
	List<Tiers> trouverToutesDemandesSimple() {
		return (List<Tiers>) tiersRepository.findAll();
	}

	@GetMapping(path = "trouverParNumeroOuNom", produces = "application/json")
	List<Tiers> trouverParNumeroOuNom(@RequestParam String numeroOuNom) {
		return tiersRepository.findByNumeroOuNom(numeroOuNom);
	}

}
