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
			aziendaClienteDTO.setIdAzienda(aziendaCliente.getIdAziendaCliente());
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
			aziendaClienteDTO.setNatoIl(aziendaCliente.getNatoIl());
		}
		return aziendaClienteDTO;
	}

	public static AziendaCliente toEntity(AziendaClienteDTO aziendaClienteDTO) {
		AziendaCliente aziendaCliente = null;
		if (aziendaClienteDTO != null) {
			aziendaCliente = new AziendaCliente();
			aziendaCliente.setIdAzienda(aziendaClienteDTO.getIdAziendaCliente());
			aziendaCliente.setUsername(aziendaClienteDTO.getUsername());
			aziendaCliente.setPassword(aziendaClienteDTO.getPassword());
			aziendaCliente.setEmail(aziendaClienteDTO.getEmail());
			aziendaCliente.setRuolo(aziendaClienteDTO.getRuolo());
		}
		return aziendaCliente;
	}

	public static List<AziendaClienteDTO> toListDTO(List<AziendaCliente> list) {
		List<AziendaClienteDTO> listAziendaClienteDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (AziendaCliente user : list) {
				listAziendaClienteDTO.add(ConverterAziendaCliente.toDTO(user));
			}
		}
		return listAziendaClienteDTO;
	}

	public static List<AziendaCliente> toListEntity(List<AziendaClienteDTO> listAziendaClienteDTO) {
		List<AziendaCliente> list = new ArrayList<>();
		if (!listAziendaClienteDTO.isEmpty()) {
			for (AziendaClienteDTO userDTO : listAziendaClienteDTO) {
				list.add(ConverterAziendaCliente.toEntity(userDTO));
			}
		}
		return list;
	}
	
	
}
