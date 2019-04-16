package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ProgettoDTO;
import it.contrader.model.Progetto;


public class ConverterProgetto {

	public static ProgettoDTO toDTO(Progetto progetto) {
		ProgettoDTO progettoDTO = null;
		if (progetto != null) {
			progettoDTO = new ProgettoDTO();
			progettoDTO.setIdProgetto(progetto.getIdProgetto());
			progettoDTO.setTitoloProgetto(progetto.getTitoloProgetto());
			progettoDTO.setAziendaClienteDTO(ConverterAziendaCliente.toDTO(progetto.getAziendaCliente()));
			progettoDTO.setDettagliProgetto(progetto.getDettagliProgetto());
			progettoDTO.setCoordinateDIIN(progetto.getCoordinateDIIN());
			
			}
		return progettoDTO;
	}

	public static Progetto toEntity(ProgettoDTO progettoDTO) {
		Progetto progetto = null;
		if (progettoDTO != null) {
			progetto = new Progetto();
			progetto.setIdProgetto(progettoDTO.getIdProgetto());
			progetto.setTitoloProgetto(progettoDTO.getTitoloProgetto());
			progetto.setAziendaCliente(ConverterAziendaCliente.toEntity(progettoDTO.getAziendaClienteDTO()));
			progetto.setDettagliProgetto(progettoDTO.getDettagliProgetto());
			progetto.setCoordinateDIIN(progettoDTO.getCoordinateDIIN());
			
		}
		return progetto;
	}

	public static List<ProgettoDTO> toListDTO(List<Progetto> list) {
		List<ProgettoDTO> listProgettoDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Progetto progetto : list) {
				listProgettoDTO.add(ConverterProgetto.toDTO(progetto));
			}
		}
		return listProgettoDTO;
	}

	public static List<Progetto> toListEntity(List<ProgettoDTO> listProgettoDTO) {
		List<Progetto> list = new ArrayList<>();
		if (!listProgettoDTO.isEmpty()) {
			for (ProgettoDTO progettoDTO : listProgettoDTO) {
				list.add(ConverterProgetto.toEntity(progettoDTO));
			}
		}
		return list;
	}
}