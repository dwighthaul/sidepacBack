package com.hubertpa.sidepa.sidepa.model.dto;

import java.io.Serializable;

import com.hubertpa.sidepa.sidepa.model.Demande;
import com.hubertpa.sidepa.sidepa.model.Workflow;

import lombok.Data;

@Data
public class DemandeCourtDTO implements Serializable {

	Long id;
	String description;
	String iban;
	String nomTiers;
	String dernierStatus;

	DemandeCourtDTO(Demande demande) {
		this.id = demande.getId();
		this.iban = demande.getIban();
		this.nomTiers = demande.getTiers().getNomOuRaisonSocial();
		this.description = demande.getDescription();
	}

	public static DemandeCourtDTO convertToDTO(Demande demande) {
		DemandeCourtDTO demandeDTO = new DemandeCourtDTO(demande);

		String dernierStatus = "";

		if (null != demande.getWf() && demande.getWf().size() > 0) {
			Workflow wf = demande.getWf().get(demande.getWf().size() - 1);

			if (null != wf) {
				dernierStatus = wf.getEtat().getCode() + " - " + wf.getEtat().getLibelle();
			}

		}
		demandeDTO.dernierStatus = dernierStatus;

		return demandeDTO;
	}
}
