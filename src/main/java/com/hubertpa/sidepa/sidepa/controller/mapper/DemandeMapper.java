package com.hubertpa.sidepa.sidepa.controller.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.hubertpa.sidepa.sidepa.model.Demande;
import com.hubertpa.sidepa.sidepa.model.dto.DemandeDetailDTO;

@Mapper
public abstract class DemandeMapper {
	DemandeMapper INSTANCE = Mappers.getMapper(DemandeMapper.class);

	public abstract DemandeDetailDTO demandeToDemandeDetailDto(Demande demande);

	@AfterMapping
	protected void enrichDTOTiersName(Demande demande, @MappingTarget DemandeDetailDTO demandeDetailDto) {
		if (null != demande.getTiers()) {
			demandeDetailDto.set_nomTiers(
					demande.getTiers().getNumeroTiers() + " - " + demande.getTiers().getNomOuRaisonSocial());
		}
	}

}
