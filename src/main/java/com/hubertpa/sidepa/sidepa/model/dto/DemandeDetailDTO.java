package com.hubertpa.sidepa.sidepa.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.hubertpa.sidepa.sidepa.model.Tiers;
import com.hubertpa.sidepa.sidepa.model.Workflow;

import lombok.Data;

@Data
public class DemandeDetailDTO {

	private Long id;

	private String description;

	private String infoDemande;

	private String iban;

	private String codeIban;

	private Tiers tiers;

	private List<Workflow> wf = new ArrayList<Workflow>();

	public String _nomTiers;
}
