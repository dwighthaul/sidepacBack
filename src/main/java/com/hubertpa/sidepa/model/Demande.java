package com.hubertpa.sidepa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Demande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String description;

	private String infoDemande;

	private String iban;
	private String codeIban;

	@ManyToOne
	private Service service;

	@ManyToOne(cascade = CascadeType.ALL)
	private Tiers tiers;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Workflow> wf = new ArrayList<Workflow>();

}