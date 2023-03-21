package com.hubertpa.sidepa.controller.initialize;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hubertpa.sidepa.model.Service;

class ReferentielServiceInitializerTest {
	Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Test
	void test() {
		ReferentielServiceInitializer referentielServiceInitializer = new ReferentielServiceInitializer();

		List<Service> services = referentielServiceInitializer.recuperationDonneesServiceFichier();
		LOGGER.info("TT - Nbr de service récupérés : {}", services.size());
		LOGGER.info("ICI : {}", services.getClass());
		LOGGER.info("ICI : {}", services.size());
		LOGGER.info("ICI : {}", services.get(0));
		LOGGER.info("ICI : {}", services.get(0).getPath());

	}

}
