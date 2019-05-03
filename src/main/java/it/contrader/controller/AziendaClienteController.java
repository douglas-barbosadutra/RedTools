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

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.UserService;


@CrossOrigin
@RestController
@RequestMapping("/AziendaClienteController")

public class AziendaClienteController {

    private final AziendaClienteService aziendaClienteService;
	private final UserService userService;
	@Autowired
	public AziendaClienteController(AziendaClienteService aziendaClienteService, UserService userService) {
		this.aziendaClienteService = aziendaClienteService;
		this.userService = userService;
	}
	
	@RequestMapping(value = "/aziendaCliente", method = RequestMethod.POST)
	public void findAzienda(@RequestBody UserDTO user) {
		aziendaClienteService.getAziendaClienteByCliente(user);
	}

	@RequestMapping(value = "/aziendaClienteManagement", method = RequestMethod.GET)
	public List<AziendaClienteDTO> aziendaClienteManagement(@RequestParam(value = "idBo") int idBo) {
		List<AziendaClienteDTO> listaAziendaCliente = CompletamentoDTO(this.aziendaClienteService.findAziendeClientiDTOByIdUser(idBo));
		return listaAziendaCliente;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody AziendaClienteDTO aziendaCliente) {
		aziendaClienteService.insertAziendaCliente(aziendaCliente);
		AziendaClienteDTO aziendaClienteDTO = aziendaClienteService.getAziendaClienteByCliente(aziendaCliente.getCliente());
		
		userService.updateUser(aziendaClienteDTO.getCliente());
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public AziendaClienteDTO read(@RequestParam(value = "id") int id) {
		return this.aziendaClienteService.getAziendaClienteDTOById(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody AziendaClienteDTO aziendaCliente) {
		aziendaClienteService.updateAziendaCliente(aziendaCliente);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "id") int id) {
		this.aziendaClienteService.deleteAziendaClienteByIdAziendaCliente(id);
	}
	
	private List<AziendaClienteDTO> CompletamentoDTO(List<AziendaClienteDTO> allAziendeComplet) {
		List<AziendaClienteDTO> retAllUtenteFinale = new ArrayList<AziendaClienteDTO>();
		
		for(AziendaClienteDTO azienda : allAziendeComplet) {
			int i = 1;
			if(azienda.getDenominazioneSocieta() != null && !azienda.getDenominazioneSocieta().equals(""))
				i++;
			if(azienda.getFormaGiuridica() != null && !azienda.getFormaGiuridica().equals(""))
				i++;
			if(azienda.getSedeLegale() != null && !azienda.getSedeLegale().equals(""))
				i++;
			if(azienda.getPartitaIva() != null && !azienda.getPartitaIva().equals(""))
				i++;
			if(azienda.getTelefono() != null && !azienda.getTelefono().equals(""))
				i++;
			if(azienda.getEmail() != null && !azienda.getEmail().equals(""))
				i++;
			if(azienda.getIndirizzoUnitaLocale() != null && !azienda.getIndirizzoUnitaLocale().equals(""))
				i++;
			if(azienda.getAttivitaAzienda() != null && !azienda.getAttivitaAzienda().equals(""))
				i++;
			if(azienda.getLegaleRappresentante() != null && !azienda.getLegaleRappresentante().equals(""))
				i++;
			if(azienda.getNatoA() != null && !azienda.getNatoA().equals(""))
				i++;
			if(azienda.getNatoIl() != null && !azienda.getNatoIl().equals(""))
				i++;
			AziendaClienteDTO uf = new AziendaClienteDTO();
			uf = azienda;
			uf.setFilledFields(i);
			retAllUtenteFinale.add(uf);
			
		}
		
		return retAllUtenteFinale;
		
	}
}