package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.FatturaDTO;
import it.contrader.services.DossierService;
import it.contrader.services.FatturaService;
import it.contrader.services.FornitoreService;

@CrossOrigin
@RestController
@RequestMapping("/FatturaController")

public class FatturaController {

    private final FatturaService fatturaService;
    private final FornitoreService fornitoreService;
    private final DossierService dossierService;
	
	@Autowired
	public FatturaController(FatturaService fatturaService, FornitoreService fornitoreService,
			DossierService dossierService) {
		this.fatturaService = fatturaService;
		this.fornitoreService = fornitoreService;
		this.dossierService = dossierService;
	}

	@RequestMapping(value = "/fatturaManagement", method = RequestMethod.GET)
	public List<FatturaDTO> fatturaManagement(@RequestParam(value = "fornitoreId") int fornitoreId,
			@RequestParam(value = "dossierId") int dossierId) {
		return this.fatturaService.findFatturaDTOByFornitoreAndDossier(fornitoreService.getFornitoreDTOById(fornitoreId),
				dossierService.getDossierDTOById(dossierId));
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody FatturaDTO fattura) {
		fatturaService.insertFattura(fattura);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public FatturaDTO read(@RequestParam(value = "idFattura") int idFattura) {
		return this.fatturaService.getFatturaDTOById(idFattura);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody FatturaDTO fattura) {
		fatturaService.updateFattura(fattura);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idFattura") int idFattura) {
		this.fatturaService.deleteFatturaById(idFattura);
	}
	
}
