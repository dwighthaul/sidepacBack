
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

		Tiers t1 = new Tiers("10123", "Hubert", "Paul", "Montreal", "1111", "0404");
		Tiers t2 = new Tiers("20123", "Huang", "Stephy", "Montreal", "2222", "0404");

		Demande demande = creationDemande("Description", "Info", t1, "C012", "FR7630001007941234567890185");
		demande.setService(serviceRepository.findByPath("/ENTREPRISE/PRODUCTION/DEV/JAVA"));
		Workflow wf = new Workflow(null, etatRepository.findByCode("CRE"), "Creation", LocalDate.now().minusDays(2));
		Workflow esh = new Workflow(null, etatRepository.findByCode("ESH"), "Envoyé validation",
				LocalDate.now().minusDays(1));
		Workflow vsh = new Workflow(null, etatRepository.findByCode("VSH"), "Validé", LocalDate.now());
		demande.getWf().add(wf);
		demande.getWf().add(esh);
		demande.getWf().add(vsh);

		Demande demande2 = creationDemande("Description - 2", "Info - 2", t2, "C012", "FR7630001007941234567890185");
		demande2.setService(serviceRepository.findByPath("/ENTREPRISE/PRODUCTION/DEV/NET"));

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
		etatRepository.save(new RefEtat(null, "CRE", "Creation"));
		etatRepository.save(new RefEtat(null, "ESH", "Envoyé sup"));
		etatRepository.save(new RefEtat(null, "VSH", "Validé sup"));
	}

}
