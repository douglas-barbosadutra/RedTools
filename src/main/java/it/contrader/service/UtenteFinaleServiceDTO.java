package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterUtenteFinale;
import it.contrader.dao.UtenteFinaleDAO;
import it.contrader.dto.UsersDTO;
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.model.Users;
import it.contrader.model.UtenteFinale;

public class UtenteFinaleServiceDTO {

	private UtenteFinaleDAO utenteFinaleDAO;
	
	

	public UtenteFinaleServiceDTO() {
		this.utenteFinaleDAO = new UtenteFinaleDAO();
	}

	
	public List<UtenteFinaleDTO> getAllUtenteFinale() {

		List<UtenteFinale> list = utenteFinaleDAO.getAllUtenteFinale();
		List<UtenteFinaleDTO> listDTO = new ArrayList<>();
	

		for (UtenteFinale utenteFinale : list) {
			int i=1;
			if(utenteFinale.getFormaGiuridica()!= null)
				i++;
			if(utenteFinale.getSedeLegale()!= null)
				i++;
			if(utenteFinale.getPartitaIva()!= null)
				i++;
			if(utenteFinale.getTelefono()!= null)
				i++;
			if(utenteFinale.getEmail()!= null)
				i++;
			if(utenteFinale.getIndirizzoUnitaLocale()!= null)
				i++;
			if(utenteFinale.getAttivitaAzienda()!= null)
				i++;
			if(utenteFinale.getLegaleRappresentante()!= null)
				i++;
			if(utenteFinale.getNatoA()!= null)
				i++;
			if(utenteFinale.getNatoIl()!= null)
				i++;
			UtenteFinaleDTO utenteFinaleDTO=ConverterUtenteFinale.toDTO(utenteFinale);
			utenteFinaleDTO.setFilledFields(i);
			listDTO.add(utenteFinaleDTO);
			
			
			
		}

		return listDTO;
	}
	
	

	public boolean insertUtenteFinale(UtenteFinaleDTO utenteFinaleDTO) {
				return this.utenteFinaleDAO.insertUtenteFinale(ConverterUtenteFinale.toEntity(utenteFinaleDTO));
	}
	
	public UtenteFinaleDTO readUtenteFinale(int id) {
		return ConverterUtenteFinale.toDTO(this.utenteFinaleDAO.readUtenteFinale(id));
	}
	
	public boolean updateUtenteFinale(UtenteFinaleDTO utenteFinaleDTO) {
		return this.utenteFinaleDAO.updateUtenteFinale(ConverterUtenteFinale.toEntity(utenteFinaleDTO));
	}
	
	public boolean deleteUtenteFinale(int id) {
		return this.utenteFinaleDAO.deleteUtenteFinale(id);
	}
	
	
}
