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
		return "manageAziendaCliente";
	}
	
//	@RequestMapping(value = "/cercaAziendaCliente", method = RequestMethod.GET)
//	public String cercaAziendaCliente(HttpServletRequest request) {
//		int content = Integer.parseInt(request.getParameter("idAziendaCliente"));
//		AziendaClienteDTO AziendaCliente = this.aziendaClienteService.getAziendaClienteDTOById(content);
//		request.setAttribute("AziendaClienteDTO", AziendaCliente);
//		return "homeAziendaCliente";
//	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualAziendaCliente(request);
		request.setAttribute("option", "insert");
		return "insertAziendaCliente";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertAziendaCliente(HttpServletRequest request) {
		
		String denominazioneSocieta = request.getParameter("denominazioneSocieta").toString();
		String formaGiuridica = request.getParameter("formaGiuridica").toString();
		String sedeLegale = request.getParameter("sedeLegale").toString();
		String partitaIva = request.getParameter("partitaIva").toString();
		String telefono = request.getParameter("telefono").toString();
		String email = request.getParameter("email").toString();
		String indirizzoUnitaLocale = request.getParameter("indirizzoUnitaLocale").toString();
		String attivitaAzienda = request.getParameter("attivitaAzienda").toString();
		String legaleRappresentante = request.getParameter("legaleRappresentante").toString();
		String natoA = request.getParameter("natoA").toString();
		String natoIl = request.getParameter("natoIl").toString();
		int idUser =Integer.parseInt(request.getParameter("idUser"));
		
		AziendaClienteDTO aziendaClienteObj = new AziendaClienteDTO();
		aziendaClienteService.insertAziendaCliente(aziendaClienteObj);

		visualAziendaCliente(request);
		return "manageAziendaCliente";
	}
	
	private List<AziendaClienteDTO> CompletamentoDTO(List<AziendaClienteDTO> allAziendeComplet) {
		List<AziendaClienteDTO> retAllUtenteFinale = new ArrayList<AziendaClienteDTO>();
		
		for(AziendaClienteDTO azienda : allAziendeComplet) {
			int i = 1;
			
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