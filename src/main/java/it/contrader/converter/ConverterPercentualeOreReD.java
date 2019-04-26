package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PercentualeOreReDDTO;
import it.contrader.model.PercentualeOreReD;

public class ConverterPercentualeOreReD {

	
	public static PercentualeOreReDDTO toDTO(PercentualeOreReD percentualeOreReD) {
		PercentualeOreReDDTO percentualeOreReDDTO = null;
		if (percentualeOreReD != null) {
			percentualeOreReDDTO = new PercentualeOreReDDTO();
			percentualeOreReDDTO.setIdPercentualeOreReD(percentualeOreReD.getIdPercentualeOreReD());
			percentualeOreReDDTO.setPercentualeOreLavorateReD(percentualeOreReD.getPercentualeOreLavorateReD());
			percentualeOreReDDTO.setDossier(ConverterDossier.toDTO(percentualeOreReD.getDossier()));
			percentualeOreReDDTO.setImpiegato(ConverterImpiegato.toDTO(percentualeOreReD.getImpiegato()));
			}
		return percentualeOreReDDTO;
	}
	
	public static PercentualeOreReD toEntity(PercentualeOreReDDTO percentualeOreReDDTO) {
		PercentualeOreReD percentualeOreReD = null;
		if (percentualeOreReDDTO != null) {
			percentualeOreReD = new PercentualeOreReD();
			percentualeOreReD.setIdPercentualeOreReD(percentualeOreReDDTO.getIdPercentualeOreReD());
			percentualeOreReD.setPercentualeOreLavorateReD(percentualeOreReDDTO.getPercentualeOreLavorateReD());
			percentualeOreReD.setDossier(ConverterDossier.toEntity(percentualeOreReDDTO.getDossier()));
			percentualeOreReD.setImpiegato(ConverterImpiegato.toEntity(percentualeOreReDDTO.getImpiegato()));
			}
		return percentualeOreReD;
	}
	
	
	public static List<PercentualeOreReDDTO> toListDTO(List<PercentualeOreReD> list) {
		List<PercentualeOreReDDTO> listPercentualeOreReDDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (PercentualeOreReD percentualeOreReD : list) {
				listPercentualeOreReDDTO.add(ConverterPercentualeOreReD.toDTO(percentualeOreReD));
			}
		}
		return listPercentualeOreReDDTO;
	}

	public static List<PercentualeOreReD> toListEntity(List<PercentualeOreReDDTO> listPercentualeOreReDDTO) {
		List<PercentualeOreReD> list = new ArrayList<>();
		if (!listPercentualeOreReDDTO.isEmpty()) {
			for (PercentualeOreReDDTO percentualeOreReDDTO : listPercentualeOreReDDTO) {
				list.add(ConverterPercentualeOreReD.toEntity(percentualeOreReDDTO));
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
