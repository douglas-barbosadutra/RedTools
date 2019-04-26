package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ImpiegatoDTO;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.ImpiegatoService;


@CrossOrigin
@RestController
@RequestMapping("/ImpiegatoController")

public class ImpiegatoController {

    private final ImpiegatoService impiegatoService;
    private final AziendaClienteService aziendaClienteService;
	
	@Autowired
	public ImpiegatoController(ImpiegatoService impiegatoService, AziendaClienteService aziendaClienteService) {
		this.impiegatoService = impiegatoService;
		this.aziendaClienteService = aziendaClienteService;
	}

	@RequestMapping(value = "/impiegatoManagement", method = RequestMethod.GET)
	public List<ImpiegatoDTO> impiegatoManagement(@RequestParam(value = "idAziendaCliente") int idAziendaCliente) {
		return this.impiegatoService.findImpiegatoDTOByAziendaCliente(aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente));	
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody ImpiegatoDTO impiegato) {
		impiegatoService.insertImpiegato(impiegato);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ImpiegatoDTO read(@RequestParam(value = "idImpiegato") int idImpiegato) {
		return this.impiegatoService.getImpiegatoDTOById(idImpiegato);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody ImpiegatoDTO impiegato) {
		impiegatoService.updateImpiegato(impiegato);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idImpiegato") int idImpiegato) {
		this.impiegatoService.deleteImpiegatoById(idImpiegato);
	}
}