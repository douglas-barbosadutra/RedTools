package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TotaleOreReDDTO;
import it.contrader.model.TotaleOreReD;

public class ConverterTotaleOreReD {

	
	public static TotaleOreReDDTO toDTO(TotaleOreReD totaleOreReD) {
		TotaleOreReDDTO totaleOreReDDTO = null;
		if (totaleOreReD != null) {
			totaleOreReDDTO = new TotaleOreReDDTO();
			totaleOreReDDTO.setIdTotaleOreReD(totaleOreReD.getIdTotaleOreReD());
			totaleOreReDDTO.setOreLavorateRed(totaleOreReD.getOreLavorateRed());
			totaleOreReDDTO.setDossier(totaleOreReD.getDossier());
			}
		return totaleOreReDDTO;
	}
	
	public static TotaleOreReD toEntity(TotaleOreReDDTO totaleOreReDDTO) {
		TotaleOreReD totaleOreReD = null;
		if (totaleOreReDDTO != null) {
			totaleOreReD = new TotaleOreReD();
			totaleOreReD.setIdTotaleOreReD(totaleOreReDDTO.getIdTotaleOreReD());
			totaleOreReD.setOreLavorateRed(totaleOreReDDTO.getOreLavorateRed());
			totaleOreReD.setDossier(totaleOreReDDTO.getDossier());
			}
		return totaleOreReD;
	}
	
	
	public static List<TotaleOreReDDTO> toListDTO(List<TotaleOreReD> list) {
		List<TotaleOreReDDTO> listTotaleOreReDDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (TotaleOreReD totaleOreReD : list) {
				listTotaleOreReDDTO.add(ConverterTotaleOreReD.toDTO(totaleOreReD));
			}
		}
		return listTotaleOreReDDTO;
	}

	public static List<TotaleOreReD> toListEntity(List<TotaleOreReDDTO> listTotaleOreReDDTO) {
		List<TotaleOreReD> list = new ArrayList<>();
		if (!listTotaleOreReDDTO.isEmpty()) {
			for (TotaleOreReDDTO totaleOreReDDTO : listTotaleOreReDDTO) {
				list.add(ConverterTotaleOreReD.toEntity(totaleOreReDDTO));
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
