package it.contrader.controller;


import java.util.List;

import it.contrader.dto.DossierDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Dossier;

import it.contrader.service.DossierService;

public class DossierController implements Controller {
	
	
	private static String sub_package = "dossier.";
	private DossierService dossierService;
	
	

	
	public DossierController() {
		
		this.dossierService =  new DossierService();
	
	}
	
	
	public List<Dossier> getAllDossier() {
		return this.dossierService.getAllDossier();
	}
	
	
	public DossierDTO readDossier(int dossierId) {
		return this.dossierService.readDossier(dossierId);
	}

	
	public boolean insertDossier(DossierDTO dossierDTO) {
		return this.dossierService.insertDossier(dossierDTO);
	}

	public boolean updateDossier(DossierDTO dossierDTO) {
		return this.dossierService.updateDossier(dossierDTO);
	}

	public boolean deleteDossier(Integer dossierId) {
		
		return this.dossierService.deleteDossier(dossierId);
	}
	
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Dossier", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DossierRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DossierInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DossierUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DossierDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}