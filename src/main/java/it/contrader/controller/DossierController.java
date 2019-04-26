package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DossierDTO;
import it.contrader.services.DossierService;
import it.contrader.services.ProgettoService;

@CrossOrigin
@RestController
@RequestMapping("/DossierController")

public class DossierController {

    private final DossierService dossierService;
    private final ProgettoService progettoService;
	
	@Autowired
	public DossierController(DossierService dossierService, ProgettoService progettoService) {
		this.dossierService = dossierService;
		this.progettoService = progettoService;
	}

	@RequestMapping(value = "/dossierManagement", method = RequestMethod.GET)
	public List<DossierDTO> dossierManagement(@RequestParam(value = "progettoId") int progettoId) {
		List<DossierDTO> listaDossier = completamentoDTO(this.dossierService.findDossierDTOByProgetto(progettoService.findProgettoDTOById(progettoId)));
		return listaDossier;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody DossierDTO dossier) {
		dossierService.insertDossier(dossier);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public DossierDTO read(@RequestParam(value = "id") int id) {
		return this.dossierService.getDossierDTOById(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody DossierDTO dossier) {
		dossierService.updateDossier(dossier);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "id") int id) {
		this.dossierService.deleteDossierById(id);
	}
	
	private List<DossierDTO> completamentoDTO(List<DossierDTO> allDossier) {
		List<DossierDTO> retAllDossier = new ArrayList<DossierDTO>();
		
		
		for(DossierDTO dossier : allDossier) {
			int y=2;
			if((dossier.getPeriodoDiImposta() != null && dossier.getPeriodoDiImposta().equals("")));
				y++;
			if((dossier.getCostoDipendentiPeriodoDiImposta() !=0))
				y++;
			if(dossier.getFatturatoPeriodoDiImposta() !=0)
				y++;
			if(dossier.getNumeroTotaleDipendenti() !=0)
				y++;
			DossierDTO d = new DossierDTO();
			d = dossier;
			d.setFilledFields(y);
			retAllDossier.add(d);
			
			
		}
		return retAllDossier;
	
	}
	
}





