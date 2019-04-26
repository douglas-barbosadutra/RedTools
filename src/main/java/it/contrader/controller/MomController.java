package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.MomDTO;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.MomService;


@CrossOrigin
@RestController
@RequestMapping("/MomController")

public class MomController {

    private final MomService momService;
    private final AziendaClienteService aziendaClienteService;
	
	@Autowired
	public MomController(MomService momService, AziendaClienteService aziendaClienteService) {
		this.momService = momService;
		this.aziendaClienteService = aziendaClienteService;
	}

	@RequestMapping(value = "/momManagement", method = RequestMethod.GET)
	public List<MomDTO> momManagement(@RequestParam(value = "idAziendaCliente") int idAziendaCliente) {
		return this.momService.findMomDTOByAziendaCliente(aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente));
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody MomDTO mom) {
		momService.insertMom(mom);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public MomDTO read(@RequestParam(value = "idMom") int idMom) {
		return this.momService.getMomDTOById(idMom);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody MomDTO mom) {
		momService.updateMom(mom);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idMom") int idMom) {
		this.momService.deleteMomById(idMom);
	}
}