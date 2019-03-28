package it.contrader.service;

import it.contrader.converter.ConverterMom;

import it.contrader.dao.MomDAO;

import it.contrader.dto.MomDTO;


public class MomService {

	private MomDAO momDAO;
	
	public MomService() {
		this.momDAO = new MomDAO();
	}
	
	
	public boolean insertMom(MomDTO momDTO) {
		return this.momDAO.insertMom(ConverterMom.toEntity(momDTO));
	}
	
	public boolean updateMom(MomDTO momDTO) {
			return this.momDAO.updateMom(ConverterMom.toEntity(momDTO));
		}
		
	public boolean deleteMom(int id_mom) {
			return this.momDAO.deleteMom(id_mom);
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
