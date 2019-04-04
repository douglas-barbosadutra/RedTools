package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.services.AziendaClienteService;


@Controller
@RequestMapping("/AziendaCliente")
public class AziendaClienteController {

	private final AziendaClienteService aziendaClienteService;
	private HttpSession session;
	
	@Autowired
	public AziendaClienteController(AziendaClienteService aziendaClienteService) {
		this.aziendaClienteService = aziendaClienteService;
	}

	private void visualAziendaCliente(HttpServletRequest request){
		List<AziendaClienteDTO> allAziendaCliente = this.aziendaClienteService.getListaAziendaClienteDTO();
		request.setAttribute("allAziendaClienteDTO", allAziendaCliente);
	}
	
	@RequestMapping(value = "/aziendaCliente/aziendaClienteManagement", method = RequestMethod.GET)
	public String aziendaClienteManagement(HttpServletRequest request) {
		visualAziendaCliente(request);
		return "homeAziendaCliente";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.aziendaClienteService.deleteAziendaClienteByIdAziendaCliente(id);
		visualAziendaCliente(request);
		return "homeAziendaCliente";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualAziendaCliente(request);
		request.setAttribute("option", "insert");
		return "creaAziendaCliente";
		
	}
	
	@RequestMapping(value = "/cercaAziendaCliente", method = RequestMethod.GET)
	public String cercaAziendaCliente(HttpServletRequest request) {

		int content = Integer.parseInt(request.getParameter("idAziendaCliente"));

		AziendaClienteDTO AziendaCliente = this.aziendaClienteService.getAziendaClienteDTOById(content);
		request.setAttribute("AziendaClienteDTO", AziendaCliente);

		return "homeAziendaCliente";

	}
	
	
	@RequestMapping(value = "/creaAziendaCliente", method = RequestMethod.POST)
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
		return "homeAziendaCliente";
	}
	
	
}