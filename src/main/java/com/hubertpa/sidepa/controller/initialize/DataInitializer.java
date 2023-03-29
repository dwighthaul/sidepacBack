
package com.hubertpa.sidepa.controller.initialize;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hubertpa.sidepa.model.Demande;
import com.hubertpa.sidepa.model.Ligne;
import com.hubertpa.sidepa.model.RefTypeLigne;
import com.hubertpa.sidepa.model.Tiers;
import com.hubertpa.sidepa.model.Workflow;
import com.hubertpa.sidepa.repository.DemandeRepository;
import com.hubertpa.sidepa.repository.RefEtatRepository;
import com.hubertpa.sidepa.repository.RefTypeLigneRepository;
import com.hubertpa.sidepa.repository.ServiceRepository;
import com.hubertpa.sidepa.repository.TiersRepository;

@Component
public class DataInitializer {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	DemandeRepository demandeRepository;

	@Autowired
	TiersRepository tiersRepository;

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	ReferentielServiceInitializer referentielServiceInitializer;

	@Autowired
	ReferentielInitializer referentielInitializer;

	@Autowired
	RefEtatRepository etatRepository;

	@Autowired
	RefTypeLigneRepository refTypeLigneRepository;

	public void createData() {
		referentielServiceInitializer.init();
		referentielInitializer.init();
		initialisationReferentiels();

		Tiers tiers1 = tiersRepository.findByNumeroTiers("12345678901").get();
		Tiers tiers2 = tiersRepository.findByNumeroTiers("12345678902").get();

		Demande demande = creationDemande("Description", "Info", tiers1, "C012", "FR7630001007941234567890185");
		demande.setService(serviceRepository.findByPath("/ENTREPRISE/PRODUCTION/DEV/JAVA"));
		demande.getWf()
				.add(new Workflow(null, etatRepository.findByCode("CRE"), "Creation", LocalDate.now().minusDays(2)));
		demande.getWf().add(new Workflow(null, etatRepository.findByCode("ESH"), "Envoyé validation",
				LocalDate.now().minusDays(1)));
		demande.getWf().add(new Workflow(null, etatRepository.findByCode("VSH"), "Validé", LocalDate.now()));

		List<Ligne> lignesDemande1 = new ArrayList<Ligne>();
		lignesDemande1.add(creationLigne("EXP", 1251.5, 1, "Consultation expertise Jean Michel"));
		lignesDemande1.add(creationLigne("CAD", 1007.8, 2, "Cadrage de 2 jours par Etienne"));
		lignesDemande1.add(creationLigne("STA", 507.8, 4, "Arrivée de par Etienne"));

		demande.setLignes(lignesDemande1);

		Demande demande2 = creationDemande("Description - 2", "Info - 2", tiers2, "C012",
				"FR7630001007941234567890185");
		demande2.setService(serviceRepository.findByPath("/ENTREPRISE/PRODUCTION/DEV/NET"));
		demande2.getWf()
				.add(new Workflow(null, etatRepository.findByCode("CRE"), "Creation", LocalDate.now().minusDays(2)));

		demandeRepository.save(demande);
		demandeRepository.save(demande2);
	}

	private Demande creationDemande(String description, String infoDemande, Tiers tiers, String codeIban, String iban) {
		Demande demande = new Demande();
		demande.setCodeIban(codeIban);
		demande.setIban(iban);

		demande.setDescription(description);
		demande.setInfoDemande(infoDemande);

		demande.setTiers(tiers);

		return demande;
	}

	private Ligne creationLigne(String codeLigne, Double montant, int nbrJour, String description) {
		logger.info("ref.getCode() : " + codeLigne);
		RefTypeLigne ref = refTypeLigneRepository.findByCode(codeLigne);
		logger.info("ref.getCode() : " + ref.getCode());
		return new Ligne(null, ref, montant, nbrJour, description);
	}

	private void initialisationReferentiels() {
		tiersRepository.save(new Tiers("12345678901", "Banque de France", "", "1 rue de la Vrillière 75001 PARIS",
				"FR7630001007941234567890185", "30001"));
		tiersRepository.save(new Tiers("12345678902", "Crédit Agricole‎", "",
				"12, place des États-Unis 92127 Montrouge Cedex", "FR7630006000011234567890189", "30006"));

	}

}
