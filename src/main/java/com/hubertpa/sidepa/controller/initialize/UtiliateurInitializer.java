package com.hubertpa.sidepa.controller.initialize;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.hubertpa.sidepa.model.structure.Utilisateur;
import com.hubertpa.sidepa.repository.UtilisateurRepository;

public class UtiliateurInitializer {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	private void init() {
		Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
			Utilisateur user = new Utilisateur(name, name.toLowerCase() + "@domain.com");
			// utilisateurRepository.save(user);
		});
	}
}
