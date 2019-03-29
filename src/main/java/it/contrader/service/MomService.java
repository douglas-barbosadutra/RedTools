package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterMom;

import it.contrader.dao.MomDAO;

import it.contrader.dto.MomDTO;

import it.contrader.model.Mom;



public class MomService {

	private MomDAO momDAO;
	
	public MomService() {
		this.momDAO = new MomDAO();
	
	}
	public List<MomDTO> getAllMom(int idUtenteFinale) {

		List<Mom> list = momDAO.getAllMom(idUtenteFinale);
		List<MomDTO> listDTO = new ArrayList<>();

		for (Mom mom : list) {
			listDTO.add(ConverterMom.toDTO(mom));
		}

		return listDTO;
	}
	public boolean insertMom(MomDTO momDTO) {
		return this.momDAO.insertMom(ConverterMom.toEntity(momDTO));
	}
	
	public MomDTO readMom(int momId) {
		return ConverterMom.toDTO(this.momDAO.readMom(momId));
	}

	public boolean updateMom(MomDTO momDTO) {
			return this.momDAO.updateMom(ConverterMom.toEntity(momDTO));
		}
		
	public boolean deleteMom(int id_mom) {
			return this.momDAO.deleteMom(id_mom);
		}
		
	
	public MomDTO searchMom(String momId) {
		return ConverterMom.toDTO(this.momDAO.searchMom(momId));
	}
	
	
}
