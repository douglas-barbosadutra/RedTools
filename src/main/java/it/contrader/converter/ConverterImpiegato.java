package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ImpiegatoDTO;
import it.contrader.model.Impiegato;

public class ConverterImpiegato {

	
	public static ImpiegatoDTO toDTO(Impiegato impiegato) {
		ImpiegatoDTO impiegatoDTO = null;
		if (impiegato != null) {
			impiegatoDTO = new ImpiegatoDTO();
			impiegatoDTO.setIdNome(impiegato.getIdNome());
			impiegatoDTO.setNominativo(impiegato.getNominativo());
			impiegatoDTO.setLivello(impiegato.getLivello());
			impiegatoDTO.setQualifica(impiegato.getQualifica());
			impiegatoDTO.setMansione(impiegato.getMansione());
			impiegatoDTO.setTitoloDiStudio(impiegato.getTitoloDiStudio());
			impiegatoDTO.setCostoOrario(impiegato.getCostoOrario());
			impiegatoDTO.setTotaleOreLavorate(impiegato.getTotaleOreLavorate());
			impiegatoDTO.setCostoLordoAnnuo(impiegato.getCostoLordoAnnuo());
			impiegatoDTO.setAziendaCliente(impiegato.getAziendaCliente());
			
			}
		return impiegatoDTO;
	}
	
	public static Impiegato toEntity(ImpiegatoDTO impiegatoDTO) {
		Impiegato impiegato = null;
		if (impiegatoDTO != null) {
			impiegato = new Impiegato();
			impiegato.setIdNome(impiegatoDTO.getIdNome());
			impiegato.setNominativo(impiegatoDTO.getNominativo());
			impiegato.setLivello(impiegatoDTO.getLivello());
			impiegato.setQualifica(impiegatoDTO.getQualifica());
			impiegato.setMansione(impiegatoDTO.getMansione());
			impiegato.setTitoloDiStudio(impiegatoDTO.getTitoloDiStudio());
			impiegato.setCostoOrario(impiegatoDTO.getCostoOrario());
			impiegato.setTotaleOreLavorate(impiegatoDTO.getTotaleOreLavorate());
			impiegato.setCostoLordoAnnuo(impiegatoDTO.getCostoLordoAnnuo());
			impiegato.setAziendaCliente(impiegatoDTO.getAziendaCliente());
			}
		return impiegato;
	}
	
	
	public static List<ImpiegatoDTO> toListDTO(List<Impiegato> list) {
		List<ImpiegatoDTO> listImpiegatoDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Impiegato impiegato : list) {
				listImpiegatoDTO.add(ConverterImpiegato.toDTO(impiegato));
			}
		}
		return listImpiegatoDTO;
	}

	public static List<Impiegato> toListEntity(List<ImpiegatoDTO> listImpiegatoDTO) {
		List<Impiegato> list = new ArrayList<>();
		if (!listImpiegatoDTO.isEmpty()) {
			for (ImpiegatoDTO impiegatoDTO : listImpiegatoDTO) {
				list.add(ConverterImpiegato.toEntity(impiegatoDTO));
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
