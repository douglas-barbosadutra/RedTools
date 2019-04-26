package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PercentualeOreReDDTO;
import it.contrader.services.DossierService;
import it.contrader.services.ImpiegatoService;
import it.contrader.services.PercentualeOreReDService;

@CrossOrigin
@RestController
@RequestMapping("/PercentualeOreReDController")
public class PercentualeOreReDController {

	private final PercentualeOreReDService percentualeOreReDService;
	private final ImpiegatoService impiegatoService;
	private final DossierService dossierService;
    
	
	@Autowired
	public PercentualeOreReDController(PercentualeOreReDService percentualeOreReDService,
			ImpiegatoService impiegatoService, DossierService dossierService) {
		this.percentualeOreReDService = percentualeOreReDService;
		this.impiegatoService = impiegatoService;
		this.dossierService = dossierService;
		
	}
	
	@RequestMapping(value = "/percentualeOreReDManagement", method = RequestMethod.GET)
	public PercentualeOreReDDTO percentualeOreReDManagement(@RequestParam(value = "impiegatoId") int impiegatoId, 
			@RequestParam(value = "dossierId") int dossierId) {
		return this.percentualeOreReDService.findPercentualeOreReDDTOByImpiegatoAndDossier(impiegatoService.getImpiegatoDTOById(impiegatoId),
				dossierService.getDossierDTOById(dossierId));
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody PercentualeOreReDDTO percentualeOreReD) {
		percentualeOreReDService.insertPercentualeOreReD(percentualeOreReD);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public PercentualeOreReDDTO read(@RequestParam(value = "percentualeOreReDId") int id) {
		return this.percentualeOreReDService.getPercentualeOreReDDTOById(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody PercentualeOreReDDTO percentualeOreReD) {
		percentualeOreReDService.updatePercentualeOreReD(percentualeOreReD);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "percentualeOreReDId") int id) {
		this.percentualeOreReDService.deletePercentualeOreReDById(id);
	}

}