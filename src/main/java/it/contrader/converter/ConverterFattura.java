package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.FatturaDTO;
import it.contrader.model.Fattura;

public class ConverterFattura {

	
	public static FatturaDTO toDTO(Fattura fattura) {
		FatturaDTO fatturaDTO = null;
		if (fattura != null) {
			fatturaDTO = new FatturaDTO();
			fatturaDTO.setIdFattura(fattura.getIdFattura());
			fatturaDTO.setDataFattura(fattura.getDataFattura());
			fatturaDTO.setNumeroFattura(fattura.getNumeroFattura());
			fatturaDTO.setDescrizione(fattura.getDescrizione());
			fatturaDTO.setTotaleImponibile(fattura.getTotaleImponibile());
			fatturaDTO.setPercentualeAmmissibile(fattura.getPercentualeAmmissibile());
			fatturaDTO.setDossier(fattura.getDossier());
			fatturaDTO.setFornitore(fattura.getFornitore());
			}
		return fatturaDTO;
	}
	
	public static Fattura toEntity(FatturaDTO fatturaDTO) {
		Fattura fattura = null;
		if (fatturaDTO != null) {
			fattura = new Fattura();
			fattura.setIdFattura(fatturaDTO.getIdFattura());
			fattura.setDataFattura(fatturaDTO.getDataFattura());
			fattura.setNumeroFattura(fatturaDTO.getNumeroFattura());
			fattura.setDescrizione(fatturaDTO.getDescrizione());
			fattura.setTotaleImponibile(fatturaDTO.getTotaleImponibile());
			fattura.setPercentualeAmmissibile(fatturaDTO.getPercentualeAmmissibile());
			fattura.setDossier(fatturaDTO.getDossier());
			fattura.setFornitore(fatturaDTO.getFornitore());
			}
		return fattura;
	}
	
	
	public static List<FatturaDTO> toListDTO(List<Fattura> list) {
		List<FatturaDTO> listFatturaDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Fattura fattura : list) {
				listFatturaDTO.add(ConverterFattura.toDTO(fattura));
			}
		}
		return listFatturaDTO;
	}

	public static List<Fattura> toListEntity(List<FatturaDTO> listFatturaDTO) {
		List<Fattura> list = new ArrayList<>();
		if (!listFatturaDTO.isEmpty()) {
			for (FatturaDTO fatturaDTO : listFatturaDTO) {
				list.add(ConverterFattura.toEntity(fatturaDTO));
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
