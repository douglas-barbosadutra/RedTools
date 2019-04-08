package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.UserService;


@Controller
@RequestMapping("/AziendaClienteController")
public class AziendaClienteController {

	private AziendaClienteService aziendaClienteService;
	private HttpSession session;
	
	
	
	//int idBO = UserService.utenteCollegato.getIdUser();
	
	@Autowired
	public AziendaClienteController(AziendaClienteService aziendaClienteService) {
		this.aziendaClienteService = aziendaClienteService;
	}

	//Caricamento nella request della lista delle Aziende Clienti del Business Owner
	
	private void visualAziendaCliente(HttpServletRequest request){
		session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("utenteCollegato");
		int idBO = userDTO.getIdUser();
		List<AziendaClienteDTO> allAziendaCliente = this.aziendaClienteService.findAziendeClientiDTOByIdUser(idBO);
		request.setAttribute("allAziendaClienteDTO", CompletamentoDTO(allAziendaCliente));
	}
	
	@RequestMapping(value = "/aziendaClienteManagement", method = RequestMethod.GET)
	public String aziendaClienteManagement(HttpServletRequest request) {
		visualAziendaCliente(request);
		return "/aziendaCliente/manageAziendaCliente";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.aziendaClienteService.deleteAziendaClienteByIdAziendaCliente(id);
		visualAziendaCliente(request);
		return "/aziendaCliente/manageAziendaCliente";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiAziendaCliente(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		AziendaClienteDTO AziendaCliente = this.aziendaClienteService.getAziendaClienteDTOById(id);
		request.setAttribute("AziendaClienteDTO", AziendaCliente);
		visualAziendaCliente(request);
		return "/aziendaCliente/readAziendaCliente";
	}
	
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("utenteCollegato");
		int idBO = userDTO.getIdUser();
		visualAziendaCliente(request);
		request.setAttribute("option", "insert");
		return "/aziendaCliente/insertAziendaCliente";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertAziendaCliente(HttpServletRequest request) {
		session = request.getSession();
		UserDTO userDTOs = (UserDTO) session.getAttribute("utenteCollegato");
		//int idBOs = userDTOs.getIdUser();
		AziendaClienteDTO aziendaClienteObj = new AziendaClienteDTO();
		
		aziendaClienteObj.setDenominazioneSocieta(request.getParameter("denominazioneSocieta").toString());
		aziendaClienteObj.setFormaGiuridica(request.getParameter("formaGiuridica").toString());
		aziendaClienteObj.setSedeLegale(request.getParameter("sedeLegale").toString());
		aziendaClienteObj.setPartitaIva(request.getParameter("partitaIva").toString());
		aziendaClienteObj.setTelefono(request.getParameter("telefono").toString());
		aziendaClienteObj.setEmail(request.getParameter("email").toString());
		aziendaClienteObj.setIndirizzoUnitaLocale(request.getParameter("indirizzoUnitaLocale").toString());
		aziendaClienteObj.setAttivitaAzienda(request.getParameter("attivitaAzienda").toString());
		aziendaClienteObj.setLegaleRappresentante(request.getParameter("legaleRappresentante").toString());
		aziendaClienteObj.setNatoA(request.getParameter("natoA").toString());
		aziendaClienteObj.setNatoIl(request.getParameter("natoIl").toString());
		aziendaClienteObj.setUserDTO(userDTOs);
		
		
		aziendaClienteService.insertAziendaCliente(aziendaClienteObj);

		visualAziendaCliente(request);
		return "/aziendaCliente/manageAziendaCliente";
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