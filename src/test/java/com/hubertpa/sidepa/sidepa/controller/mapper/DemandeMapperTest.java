package com.hubertpa.sidepa.sidepa.controller.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import com.hubertpa.sidepa.sidepa.model.Demande;
import com.hubertpa.sidepa.sidepa.model.Tiers;
import com.hubertpa.sidepa.sidepa.model.dto.DemandeDetailDTO;

public class DemandeMapperTest {

	@Test
	public void test() {

		DemandeMapper demandeMapper = Mappers.getMapper(DemandeMapper.class);

		Demande demande = new Demande();
		demande.setTiers(new Tiers("1234", "nom", "prenom", "adresse", "1234", "01"));

		DemandeDetailDTO demandeDTO = demandeMapper.demandeToDemandeDetailDto(demande);
		assertEquals("1234 - nom", demandeDTO.get_nomTiers());
	}

}
