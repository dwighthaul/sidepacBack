package com.hubertpa.sidepa.controller.routing;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubertpa.sidepa.model.Service;
import com.hubertpa.sidepa.service.OrganisationService;

@RestController
@RequestMapping("/data/service/")
public class ServiceController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	OrganisationService service;

	@GetMapping(path = "all", produces = "application/json")
	List<Service> trouverToutsServices() {
		return service.recuperationServices();
	}
}
