package com.hubertpa.sidepa.controller.initialize;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hubertpa.sidepa.model.Service;
import com.hubertpa.sidepa.service.OrganisationService;

@Component
public class ReferentielServiceInitializer {
	Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	OrganisationService organisationService;

	public void init() {
		List<Service> services = recuperationDonneesServiceFichier();
		organisationService.sauvegarderServices(services);

	}

	public List<Service> recuperationDonneesServiceFichier() {
		List<Service> listeServices = new ArrayList<Service>();
		DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
		Resource resource = defaultResourceLoader.getResource("classpath:initData/organisation.xml");
		String content = "";
		try {
			InputStream inputStream = resource.getInputStream();
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

			content = new String(bdata, StandardCharsets.UTF_8);

		} catch (IOException e) {
			LOGGER.error("File not found");
			e.printStackTrace();
		}

		try {
			listeServices = new XmlMapper().readValue(content, new TypeReference<List<Service>>() {
			});
		} catch (JsonMappingException e) {
			LOGGER.error("JsonMappingException");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			LOGGER.error("JsonProcessingException");
			e.printStackTrace();
		}

		return listeServices;
	}

}
