package com.hubertpa.sidepa.controller.routing;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Default {
	Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping(path = "test", produces = "application/json")
	Map<String, String> trouverToutesDemandes() {
		Map map = new HashMap<String, String>();
		map.put("String", "String");
		return map;
	}

	@GetMapping(path = "user", produces = "application/json")
	public String user(Principal principal) {
		logger.info("user");
		return principal.toString();
	}
}
