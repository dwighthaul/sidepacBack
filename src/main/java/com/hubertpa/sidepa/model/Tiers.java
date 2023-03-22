package com.hubertpa.sidepa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tiers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	@Column(unique = true)
	private String numeroTiers;
	@NonNull
	private String nomOuRaisonSocial;

	@NonNull
	private String prenom;

	@NonNull
	private String adresse;

	@NonNull
	private String iban;

	@NonNull
	private String codeIban;
}
