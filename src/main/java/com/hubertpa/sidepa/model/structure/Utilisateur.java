package com.hubertpa.sidepa.model.structure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private final String name;
	private final String email;
}
