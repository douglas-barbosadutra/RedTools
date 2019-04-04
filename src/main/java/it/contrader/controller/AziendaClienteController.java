package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.services.AziendaClienteService;

import java.util.List;


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
		this.aziendaClienteService.deleteAziendaClienteById(id);
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

		final String content = request.getParameter("search");

		List<AziendaClienteDTO> allAziendaCliente = this.aziendaClienteService.findAziendaClienteDTOByUsername(content);
		request.setAttribute("allAziendaClienteDTO", allAziendaCliente);

		return "homeAziendaCliente";

	}
	
	@RequestMapping(value = "/creaAziendaCliente", method = RequestMethod.POST)
	public String insertAziendaCliente(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String ruolo = request.getParameter("ruolo").toString();

		AziendaClienteDTO aziendaClienteObj = new AziendaClienteDTO(0, username, password, ruolo,"");
		
		aziendaClienteService.insertAziendaCliente(aziendaClienteObj);

		visualAziendaCliente(request);
		return "homeAziendaCliente";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final AziendaClienteDTO aziendaClienteDTO = aziendaClienteService.getByUsernameAndPassword(username, password);
		final String ruolo = aziendaClienteDTO.getRuolo();
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", aziendaClienteDTO);
			if (ruolo.equals("ADMIN")) {
				return "home";
			} else if (ruolo.equals("CHATMASTER")) {
				return "home";
			}
		}
		return "index";
	}
}