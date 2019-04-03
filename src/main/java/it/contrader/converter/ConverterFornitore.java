package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.FornitoreDTO;
import it.contrader.model.Fornitore;

public class ConverterFornitore {

	
	public static FornitoreDTO toDTO(Fornitore fornitore) {
		FornitoreDTO fornitoreDTO = null;
		if (fornitore != null) {
			fornitoreDTO = new FornitoreDTO();
			fornitoreDTO.setIdFornitore(fornitore.getIdFornitore());
			fornitoreDTO.setNomeFornitore(fornitore.getNomeFornitore());
			}
		return fornitoreDTO;
	}
	
	public static Fornitore toEntity(FornitoreDTO fornitoreDTO) {
		Fornitore fornitore = null;
		if (fornitoreDTO != null) {
			fornitore = new Fornitore();
			fornitore.setIdFornitore(fornitoreDTO.getIdFornitore());
			fornitore.setNomeFornitore(fornitoreDTO.getNomeFornitore());
			}
		return fornitore;
	}
	
	
	public static List<FornitoreDTO> toListDTO(List<Fornitore> list) {
		List<FornitoreDTO> listFornitoreDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Fornitore fornitore : list) {
				listFornitoreDTO.add(ConverterFornitore.toDTO(fornitore));
			}
		}
		return listFornitoreDTO;
	}

	public static List<Fornitore> toListEntity(List<FornitoreDTO> listFornitoreDTO) {
		List<Fornitore> list = new ArrayList<>();
		if (!listFornitoreDTO.isEmpty()) {
			for (FornitoreDTO fornitoreDTO : listFornitoreDTO) {
				list.add(ConverterFornitore.toEntity(fornitoreDTO));
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
