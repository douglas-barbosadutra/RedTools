package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProgettoDTO;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.ProgettoService;


@CrossOrigin
@RestController
@RequestMapping("/ProgettoController")

public class ProgettoController {

    private final ProgettoService progettoService;
    private final AziendaClienteService aziendaClienteService;
	
	@Autowired
	public ProgettoController(ProgettoService progettoService, AziendaClienteService aziendaClienteService) {
		this.progettoService = progettoService;
		this.aziendaClienteService = aziendaClienteService;
	}

	@RequestMapping(value = "/progettoManagement", method = RequestMethod.GET)
	public List<ProgettoDTO> progettoManagement(@RequestParam(value = "idAziendaCliente") int idAziendaCliente) {
		return this.progettoService.findProgettoDTOByAziendaCliente(aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente));	
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody ProgettoDTO progetto) {
		progettoService.insertProgetto(progetto);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ProgettoDTO read(@RequestParam(value = "idProgetto") int idProgetto) {
		return this.progettoService.findProgettoDTOById(idProgetto);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody ProgettoDTO progetto) {
		progettoService.updateProgetto(progetto);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idProgetto") int idProgetto) {
		this.progettoService.deleteProgettoByidProgetto(idProgetto);
	}
}