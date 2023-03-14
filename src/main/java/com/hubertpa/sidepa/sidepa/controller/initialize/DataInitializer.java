
package com.hubertpa.sidepa.sidepa.controller.initialize;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hubertpa.sidepa.sidepa.model.Demande;
import com.hubertpa.sidepa.sidepa.model.RefEtat;
import com.hubertpa.sidepa.sidepa.model.Tiers;
import com.hubertpa.sidepa.sidepa.model.Workflow;
import com.hubertpa.sidepa.sidepa.repository.DemandeRepository;
import com.hubertpa.sidepa.sidepa.repository.RefEtatRepository;
import com.hubertpa.sidepa.sidepa.repository.TiersRepository;

@Component
public class DataInitializer {

	@Autowired
	DemandeRepository demandeRepository;

	@Autowired
	TiersRepository tiersRepository;

	@Autowired
	RefEtatRepository etatRepository;

	public void createData() {
		initialisationReferentiels();

		Tiers t1 = new Tiers("10123", "Hubert", "Paul", "Montreal", "1111", "0404");
		Tiers t2 = new Tiers("20123", "Huang", "Stephy", "Montreal", "2222", "0404");

		Demande demande = creationDemande("Description", "Info", t1, "C012", "FR7630001007941234567890185");
		Workflow wf = new Workflow(null, etatRepository.findByCode("CRE"), "Creation", LocalDate.now());
		demande.getWf().add(wf);

		Demande demande2 = creationDemande("Description - 2", "Info - 2", t2, "C012", "FR7630001007941234567890185");

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
