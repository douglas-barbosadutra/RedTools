package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/HomeController")
public class HomeController {

	private final UserService userService;
	private final AziendaClienteService aziendaClienteService;
	

	@Autowired
	public HomeController(UserService userService, AziendaClienteService aziendaClienteService ) {
		this.userService = userService;
		this.aziendaClienteService = aziendaClienteService;
	}

	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public String homeAdmin(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		return "homeAdmin";
	}
	
	@RequestMapping(value = "/homeBO", method = RequestMethod.GET)
	public String homeBO(HttpServletRequest request) {
		int idBO = (int) request.getAttribute("idBO");
		List<AziendaClienteDTO> allAziendaCliente = this.aziendaClienteService.findAziendeClientiDTOByIdUser(idBO);
		request.setAttribute("allAziendaClienteDTO", allAziendaCliente);
		return "homeBO";
	}

	@RequestMapping(value = "/homeCliente", method = RequestMethod.GET)
	public String homeCliente(HttpServletRequest request) {
		return "homeCliente";
	}
			
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	
}