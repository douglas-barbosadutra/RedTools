package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.DossierDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.DossierService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/HomeController")
public class HomeController {

	private final UserService userService;
	private final DossierService dossierService;

	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/BoManagement", method = RequestMethod.GET)
	public String chatManagement(HttpServletRequest request) {
		return "homeBO";

	}

	@RequestMapping(value = "/userManage", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		return "homeAdmin";

	}

	
	@RequestMapping(value = "/dossierManage", method = RequestMethod.GET)
	public String dossierManage(HttpServletRequest request) {
		List<DossierDTO> allDossier = this.dossierService.getListaDossierDTO();
		request.setAttribute("allDossierDTO", allDossier);
		return "manageAziendaCliente";

	}

	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "home";

	}
}