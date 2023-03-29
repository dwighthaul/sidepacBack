package com.hubertpa.sidepa.controller.initialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hubertpa.sidepa.model.RefEtat;
import com.hubertpa.sidepa.model.RefTypeLigne;
import com.hubertpa.sidepa.repository.RefEtatRepository;
import com.hubertpa.sidepa.repository.RefTypeLigneRepository;

@Component
public class ReferentielInitializer {

	@Autowired
	RefEtatRepository etatRepository;

	@Autowired
	RefTypeLigneRepository typeLigneRepository;

	void init() {
		initialisationReferentielsEtat();
		initialisationReferentielsTypeLigne();
	}

	private void initialisationReferentielsEtat() {
		etatRepository.save(new RefEtat(null, "CRE", "Crée"));
		etatRepository.save(new RefEtat(null, "ESH", "Envoyé supérieur hiérarchique"));
		etatRepository.save(new RefEtat(null, "VSH", "Validé supérieur hiérarchique"));
		etatRepository.save(new RefEtat(null, "PAY", "Payée"));
	}

	private void initialisationReferentielsTypeLigne() {
		typeLigneRepository.save(new RefTypeLigne(null, "EXP", "Expertise"));
		typeLigneRepository.save(new RefTypeLigne(null, "COT", "Consultation"));
		typeLigneRepository.save(new RefTypeLigne(null, "CAD", "Cadrage"));
		typeLigneRepository.save(new RefTypeLigne(null, "DEV", "Developpement"));
		typeLigneRepository.save(new RefTypeLigne(null, "CHE", "Chefferie de projet"));
		typeLigneRepository.save(new RefTypeLigne(null, "STA", "Stagiaire"));

	}

}
