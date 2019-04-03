package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MomDTO;
import it.contrader.model.Mom;

public class ConverterMom {

	
	public static MomDTO toDTO(Mom mom) {
		MomDTO momDTO = null;
		if (mom != null) {
			momDTO = new MomDTO();
			momDTO.setIdMom(mom.getIdMom());
			momDTO.setLuogoMom(mom.getLuogoMom());
			momDTO.setDataDelGiornoMom(mom.getDataDelGiornoMom());
			momDTO.setOrarioMom(mom.getOrarioMom());
			momDTO.setOggettoMom(mom.getOggettoMom());
			momDTO.setPartecipantiMom(mom.getPartecipantiMom());
			momDTO.setTestoAgendaMom(mom.getTestoAgendaMom());
			momDTO.setTestoAzioneMom(mom.getTestoAzioneMom());
			momDTO.setTestoNoteMom(mom.getTestoNoteMom());
			}
		return momDTO;
	}
	
	public static Mom toEntity(MomDTO momDTO) {
		Mom mom = null;
		if (momDTO != null) {
			mom = new Mom();
			mom.setIdMom(momDTO.getIdMom());
			mom.setLuogoMom(momDTO.getLuogoMom());
			mom.setDataDelGiornoMom(momDTO.getDataDelGiornoMom());
			mom.setOrarioMom(momDTO.getOrarioMom());
			mom.setOggettoMom(momDTO.getOggettoMom());
			mom.setPartecipantiMom(momDTO.getPartecipantiMom());
			mom.setTestoAgendaMom(momDTO.getTestoAgendaMom());
			mom.setTestoAzioneMom(momDTO.getTestoAzioneMom());
			mom.setTestoNoteMom(momDTO.getTestoNoteMom());
			
			}
		return mom;
	}
	
	
	public static List<MomDTO> toListDTO(List<Mom> list) {
		List<MomDTO> listMomDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Mom mom : list) {
				listMomDTO.add(ConverterMom.toDTO(mom));
			}
		}
		return listMomDTO;
	}

	public static List<Mom> toListEntity(List<MomDTO> listMomDTO) {
		List<Mom> list = new ArrayList<>();
		if (!listMomDTO.isEmpty()) {
			for (MomDTO momDTO : listMomDTO) {
				list.add(ConverterMom.toEntity(momDTO));
			}
		}
		return list;
	}	
	
}
