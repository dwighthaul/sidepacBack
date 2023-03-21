package com.hubertpa.sidepa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hubertpa.sidepa.model.Service;
import com.hubertpa.sidepa.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class OrganisationService {

	Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	ServiceRepository serviceRepository;

	public void sauvegarderServices(List<Service> listeServices) {
		LOGGER.info("Nbr données à persister dans Repo: {}", listeServices.size());
		serviceRepository.saveAll(listeServices);
	}

	public List<Service> recuperationServices() {
		LOGGER.info("Nbr données à persister dans Repo: {}", serviceRepository.findAll());
		return (List<Service>) serviceRepository.findAll();
	}
}
