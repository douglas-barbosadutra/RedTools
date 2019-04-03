package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ProgettoDTO;
import it.contrader.services.ProgettoService;


@Controller
@RequestMapping("/Progetto")

public class ProgettoController {




	private final ProgettoService progettoService;
	private HttpSession session;
	
	@Autowired
	public ProgettoController(ProgettoService progettoService) {
		this.progettoService = progettoService;
	}

	private void visualProgetto(HttpServletRequest request){
		List<ProgettoDTO> allProgetto = this.progettoService.getListaProgettoDTO();
		request.setAttribute("allProgettoDTO", allProgetto);
	}
	
	@RequestMapping(value = "/Progetto/ProgettoManagement", method = RequestMethod.GET)
	public String ProgettoManagement(HttpServletRequest request) {
		visualProgetto(request);
		return "homeProgetto";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idProgetto = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", idProgetto);
		this.progettoService.deleteProgettoByidProgetto(idProgetto);
		visualProgetto(request);
		return "homeProgetto";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualProgetto(request);
		request.setAttribute("option", "insert");
		return "creaProgetto";
		
	}
	
	@RequestMapping(value = "/cercaProgetto", method = RequestMethod.GET)
	public String cercaProgetto(HttpServletRequest request) {

		final int content = Integer.parseInt(request.getParameter("search"));

		List<ProgettoDTO> allProgetto = this.progettoService.findProgettoDTOByidProgetto(content);
		request.setAttribute("allProgettoDTO", allProgetto);

		return "homeProgetto";

	}
	
	@RequestMapping(value = "/creaProgetto", method = RequestMethod.POST)
	public String insertProgetto(HttpServletRequest request) {
		
		int idProgetto = Integer.parseInt(request.getParameter("idProgetto").toString());
		String nomeProgetto = request.getParameter("nomeProgetto").toString();
		int idUtenteFinale = Integer.parseInt(request.getParameter("idUtenteFinale").toString());

		ProgettoDTO progettoObj = new ProgettoDTO(0, nomeProgetto, 0);
		
		progettoService.insertProgetto(progettoObj);

		visualProgetto(request);
		return "homeProgetto";
	}
	
	
}