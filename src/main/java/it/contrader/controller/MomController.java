package it.contrader.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.MomDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.MomService;

@Controller
@RestController
@RequestMapping("/MomController")
public class MomController {

	private final MomService momService;
	private final AziendaClienteService aziendaClienteService;
	private  MomDTO  momDTO; 
;
	
	@Autowired
	public MomController(MomService momService, AziendaClienteService aziendaClienteService) {
		this.momService = momService;
		this.aziendaClienteService = aziendaClienteService;
	}
	
	
	@RequestMapping(value = "/momManagement", method = RequestMethod.GET)
	public List <MomDTO> momManagement(@RequestParam(value="idAziendaCliente") int idAziendaCliente ) {
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		return 	momService.findMomDTOByAziendaCliente(aziendaCliente);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertMom(@RequestBody MomDTO momDTO) {
		momService.insertMom(momDTO);
	
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody MomDTO momDTO) {
		momService.updateMom(momDTO);
		
	}	
		
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value="idMom") int idMom ){
		momService.deleteMomById(idMom);
	
	}
}
