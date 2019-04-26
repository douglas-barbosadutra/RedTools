package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.model.AziendaCliente;

public class ConverterAziendaCliente {

		public static AziendaClienteDTO toDTO(AziendaCliente aziendaCliente) {
		AziendaClienteDTO aziendaClienteDTO = null;
		if (aziendaCliente != null) {
			aziendaClienteDTO = new AziendaClienteDTO();
			aziendaClienteDTO.setIdAziendaCliente(aziendaCliente.getIdAziendaCliente());
			aziendaClienteDTO.setDenominazioneSocieta(aziendaCliente.getDenominazioneSocieta());
			aziendaClienteDTO.setFormaGiuridica(aziendaCliente.getFormaGiuridica());
			aziendaClienteDTO.setSedeLegale(aziendaCliente.getSedeLegale());
			aziendaClienteDTO.setPartitaIva(aziendaCliente.getPartitaIva());
			aziendaClienteDTO.setTelefono(aziendaCliente.getTelefono());
			aziendaClienteDTO.setEmail(aziendaCliente.getEmail());
			aziendaClienteDTO.setIndirizzoUnitaLocale(aziendaCliente.getIndirizzoUnitaLocale());
			aziendaClienteDTO.setAttivitaAzienda(aziendaCliente.getAttivitaAzienda());
			aziendaClienteDTO.setLegaleRappresentante(aziendaCliente.getLegaleRappresentante());
			aziendaClienteDTO.setNatoA(aziendaCliente.getNatoA());
			aziendaClienteDTO.setNatoIl(aziendaCliente.getNatoIl());
			aziendaClienteDTO.setUser(ConverterUser.toDTO(aziendaCliente.getUser()));
			
			
			
		}
		return aziendaClienteDTO;
	}

	public static AziendaCliente toEntity(AziendaClienteDTO aziendaClienteDTO) {
		AziendaCliente aziendaCliente = null;
		if (aziendaClienteDTO != null) {
			aziendaCliente = new AziendaCliente();
			
			aziendaCliente.setIdAziendaCliente(aziendaClienteDTO.getIdAziendaCliente());
			aziendaCliente.setDenominazioneSocieta(aziendaClienteDTO.getDenominazioneSocieta());
			aziendaCliente.setFormaGiuridica(aziendaClienteDTO.getFormaGiuridica());
			aziendaCliente.setSedeLegale(aziendaClienteDTO.getSedeLegale());
			aziendaCliente.setPartitaIva(aziendaClienteDTO.getPartitaIva());
			aziendaCliente.setTelefono(aziendaClienteDTO.getTelefono());
			aziendaCliente.setEmail(aziendaClienteDTO.getEmail());
			aziendaCliente.setIndirizzoUnitaLocale(aziendaClienteDTO.getIndirizzoUnitaLocale());
			aziendaCliente.setAttivitaAzienda(aziendaClienteDTO.getAttivitaAzienda());
			aziendaCliente.setLegaleRappresentante(aziendaClienteDTO.getLegaleRappresentante());
			aziendaCliente.setNatoA(aziendaClienteDTO.getNatoA());
			aziendaCliente.setNatoIl(aziendaClienteDTO.getNatoIl());
			aziendaCliente.setUser(ConverterUser.toEntity(aziendaClienteDTO.getUser()));
			
			
			
		}
		return aziendaCliente;
	}

	public static List<AziendaClienteDTO> toListDTO(List<AziendaCliente> listAziendaCliente) {
		List<AziendaClienteDTO> listAziendaClienteDTO = new ArrayList<>();
		if (!listAziendaCliente.isEmpty()) {
			for (AziendaCliente aziendaCliente : listAziendaCliente) {
				listAziendaClienteDTO.add(ConverterAziendaCliente.toDTO(aziendaCliente));
			}
		}
		return listAziendaClienteDTO;
	}

	public static List<AziendaCliente> toListEntity(List<AziendaClienteDTO> listAziendaClienteDTO) {
		List<AziendaCliente> list = new ArrayList<>();
		if (!listAziendaClienteDTO.isEmpty()) {
			for (AziendaClienteDTO aziendaClienteDTO : listAziendaClienteDTO) {
				list.add(ConverterAziendaCliente.toEntity(aziendaClienteDTO));
			}
		}
		return list;
	}
	
	
}
