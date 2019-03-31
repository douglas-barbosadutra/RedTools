package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterUtenteFinale;
import it.contrader.dao.UtenteFinaleDAO;
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.model.UtenteFinale;

public class UtenteFinaleService {

	private UtenteFinaleDAO utenteFinaleDAO;

	public UtenteFinaleService() {
		this.utenteFinaleDAO = new UtenteFinaleDAO();
	}

	public List<UtenteFinaleDTO> getAllUtenteFinaleBo(int idBO) {

		List<UtenteFinale> list = utenteFinaleDAO.getAllUtenteFinaleBo(idBO);
		List<UtenteFinaleDTO> listDTO = new ArrayList<>();
	

		for (UtenteFinale utenteFinale : list) {
			UtenteFinaleDTO utenteFinaleDTO=ConverterUtenteFinale.toDTO(utenteFinale);
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
