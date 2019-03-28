package it.contrader.service;

import java.util.ArrayList;
import java.util.List;


import it.contrader.converter.ConverterDossier;
import it.contrader.converter.ConverterDossier;
import it.contrader.dao.DossierDAO;
import it.contrader.dto.DossierDTO;
import it.contrader.dto.DossierDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Dossier;




public class DossierService {
	
	
	
	private DossierDAO dossierDAO;

	public DossierService() {
		this.dossierDAO = new DossierDAO();
	}

	public List<DossierDTO> getAllDossier(int idUtenteFinale) {

		List<Dossier> list = dossierDAO.getAllDossier(idUtenteFinale);
		List<DossierDTO> listDTO = new ArrayList<>();
	

		for (Dossier dossier : list) {
			int i=1;
			if(dossier.getCostoDipendenti()!= 0)
				i++;
			if(dossier.getFatturatoPeriodoDiImposta()!= 0)
				i++;
			if(dossier.getNumeroDipendenti()!= 0)
				i++;
			if(dossier.getCostiAttivitaRd()!= 0)
				i++;
			if(dossier.getCostiPersonaleRd()!= 0)
				i++;
			
			DossierDTO dossierDTO=ConverterDossier.toDTO(dossier);
			dossierDTO.setFilledFields(i);
			listDTO.add(dossierDTO);
			
			
			
		}

		return listDTO;
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
