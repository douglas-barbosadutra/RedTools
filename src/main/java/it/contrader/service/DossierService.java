package it.contrader.service;

import java.util.List;


import it.contrader.converter.ConverterDossier;
import it.contrader.dao.DossierDAO;
import it.contrader.dto.DossierDTO;
import it.contrader.model.Dossier;




public class DossierService {
	
	
	
	private DossierDAO dossierDAO;

	public DossierService() {
		this.dossierDAO = new DossierDAO();
	}

	public List<Dossier> getAllDossier() {
		return this.dossierDAO.getAllDossier();
	}

	public boolean insertDossier(DossierDTO dossierDTO) {
				return this.dossierDAO.insertDossier(ConverterDossier.toEntity(dossierDTO));
	}
	
	public DossierDTO readDossier(int dossierId) {
		return ConverterDossier.toDTO(this.dossierDAO.readDossier(dossierId));
	}
	
	public boolean updateDossier(DossierDTO dossierDTO) {
		return this.dossierDAO.updateDossier(ConverterDossier.toEntity(dossierDTO));
	}
	
	public boolean deleteDossier(int dossierId) {
		return this.dossierDAO.deleteDossier(dossierId);
	}
	
	
	
	

}
