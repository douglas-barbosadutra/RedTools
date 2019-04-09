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
import it.contrader.dto.ProgettoDTO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.ProgettoService;


@Controller
@RequestMapping("/ProgettoController")

public class ProgettoController {

	private final AziendaClienteService aziendaClienteService ;
    private final ProgettoService progettoService;
	private HttpSession session;
	
	@Autowired
	public ProgettoController(ProgettoService progettoService, AziendaClienteService aziendaClienteService) {
		this.progettoService = progettoService;
		this.aziendaClienteService = aziendaClienteService;
	}

	private void visualProgetto(HttpServletRequest request){
		final int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		List<ProgettoDTO> allProgetto = this.progettoService.findProgettoDTOByAziendaCliente(idAziendaCliente);
		request.setAttribute("allProgettoDTO", allProgetto);
	}
	
	@RequestMapping(value = "/progettoManagement", method = RequestMethod.GET)
	public String ProgettoManagement(HttpServletRequest request) {
		session = request.getSession();
		int idAziendaCliente = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("idAziendaCliente", idAziendaCliente);
		visualProgetto(request);
		return "/progetto/manageProgetto";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idProgetto = Integer.parseInt(request.getParameter("idProgettoDelete"));
		request.setAttribute("id", idProgetto);
		this.progettoService.deleteProgettoByidProgetto(idProgetto);
		visualProgetto(request);
		return "/progetto/manageProgetto";
		
	}
	
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idProgettoUpdate"));
		ProgettoDTO progettoUpdate = new ProgettoDTO();
		// progettoUpdate.setProgettoId(id);

		progettoUpdate = this.progettoService.findProgettoDTOById(id);
		request.setAttribute("progettoUpdate", progettoUpdate);
		return "/progetto/updateProgetto";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idProgetto = Integer.parseInt(request.getParameter("idProgetto"));
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		
		String titoloProgetto = request.getParameter("titoloProgetto");
		String dettagliProgetto = request.getParameter("dettaglioProgetto");
		String coordinateDIIN  = request.getParameter("coordinateDIIN");
		AziendaClienteDTO aziendaClientes = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		ProgettoDTO progettoObj = new ProgettoDTO(idProgetto, titoloProgetto, aziendaClientes, dettagliProgetto, coordinateDIIN);
		progettoService.updateProgetto(progettoObj);
		visualProgetto(request);
		return "/progetto/manageProgetto";
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		//visualProgetto(request);
		request.setAttribute("option", "insert");
		return "/progetto/insertProgetto";
		
	}
	
//	@RequestMapping(value = "/cercaProgetto", method = RequestMethod.GET)
//	public String cercaProgetto(HttpServletRequest request) {
//
//		final int content = Integer.parseInt(request.getParameter("search"));
//
//		List<ProgettoDTO> allProgetto = this.progettoService.findProgettoDTOByidProgetto(content);
//		request.setAttribute("allProgettoDTO", allProgetto);
//
//		return "homeProgetto";
//
//	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertProgetto(HttpServletRequest request) {
		session = request.getSession();
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		System.out.println(idAziendaCliente);
		ProgettoDTO progettoObj = new ProgettoDTO();
		progettoObj.setIdProgetto(0);
		progettoObj.setTitoloProgetto(request.getParameter("titoloProgetto").toString());
		progettoObj.setDettagliProgetto(request.getParameter("dettaglioProgetto").toString());
		progettoObj.setCoordinateDIIN(request.getParameter("coordinateDIIN").toString());
		AziendaClienteDTO aziendaClientes = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		progettoObj.setAziendaClienteDTO(aziendaClientes);

		//int idAziendaCliente = Integer.parseInt(request.getParameter("idAziendaCliente").toString());
		progettoService.insertProgetto(progettoObj);

		visualProgetto(request);
		return "/progetto/manageProgetto";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiProgetto(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idProgettoRead"));
		ProgettoDTO progetto = this.progettoService.findProgettoDTOById(id);
		request.setAttribute("ProgettoDTO", progetto);
		visualProgetto(request);
		return "/progetto/readProgetto";
	}
	
}