
package com.hubertpa.sidepa.controller.initialize;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hubertpa.sidepa.model.Demande;
import com.hubertpa.sidepa.model.RefEtat;
import com.hubertpa.sidepa.model.Tiers;
import com.hubertpa.sidepa.model.Workflow;
import com.hubertpa.sidepa.repository.DemandeRepository;
import com.hubertpa.sidepa.repository.RefEtatRepository;
import com.hubertpa.sidepa.repository.ServiceRepository;
import com.hubertpa.sidepa.repository.TiersRepository;

@Component
public class DataInitializer {

	@Autowired
	DemandeRepository demandeRepository;

	@Autowired
	TiersRepository tiersRepository;

	@Autowired
	RefEtatRepository etatRepository;

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	ReferentielServiceInitializer referentielServiceInitializer;

	public void createData() {
		referentielServiceInitializer.init();
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

	private void initialisationReferentiels() {
		etatRepository.save(new RefEtat(null, "CRE", "Crée"));
		etatRepository.save(new RefEtat(null, "ESH", "Envoyé supérieur hiérarchique"));
		etatRepository.save(new RefEtat(null, "VSH", "Validé supérieur hiérarchique"));
		etatRepository.save(new RefEtat(null, "PAY", "Payée"));

		tiersRepository.save(new Tiers("12345678901", "Banque de France", "", "1 rue de la Vrillière 75001 PARIS",
				"FR7630001007941234567890185", "30001"));
		tiersRepository.save(new Tiers("12345678902", "Crédit Agricole‎", "",
				"12, place des États-Unis 92127 Montrouge Cedex", "FR7630006000011234567890189", "30006"));

	}

}
