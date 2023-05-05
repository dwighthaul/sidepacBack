package com.hubertpa.sidepa.controller.routing;

import java.util.List;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubertpa.sidepa.model.RefTypeLigne;
import com.hubertpa.sidepa.repository.RefTypeLigneRepository;

@RestController
@RequestMapping("/data/")
public class ReferentielController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RefTypeLigneRepository refTypeLigneRepository;

	@GetMapping(path = "refTypeLigne", produces = "application/json")
	List<RefTypeLigne> trouverToutsTypeLigne() {
		return StreamSupport.stream(refTypeLigneRepository.findAll().spliterator(), false).toList();
	}

}
