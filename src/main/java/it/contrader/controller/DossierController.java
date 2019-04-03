package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.DossierDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.DossierService;
import it.contrader.services.UserService;

import java.util.List;



@Controller
@RequestMapping("/Dossier")


public class DossierController {
	
	private final DossierService dossierService;
	private HttpSession session;
	
	
	@Autowired
	public DossierController(DossierService dossierService) {
		this.dossierService = dossierService;
	}
	
	private void visualDossier(HttpServletRequest request){
		List<DossierDTO> allDossier = this.dossierService.getListaDossierDTO();
		request.setAttribute("allDossierDTO", allDossier);
	}

	
	
	@RequestMapping(value = "/dossierManagement", method = RequestMethod.GET)
	public String dossierManagement(HttpServletRequest request) {
		visualDossier(request);
		return "homeDossier";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.dossierService.deleteDossierById(id);
		visualDossier(request);
		return "homeDossier" ;
		
	}	
	
	
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualDossier(request);
		request.setAttribute("option", "insert");
		return "creaDossier";
		
	}
	
	
	@RequestMapping(value = "/cercaDossier", method = RequestMethod.GET)
	public String cercaDossier(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<DossierDTO> allDossier = this.dossierService.findDossierDTOByPeriodoDiImposta(content);
		request.setAttribute("allDossierDTO", allDossier);

		return "homeDossier";

	}
	
	
	@RequestMapping(value = "/creaDossier", method = RequestMethod.POST)
	public String insertDossier(HttpServletRequest request) {
		String periodoDiImposta = request.getParameter("priodoDiImposta").toString();
		double costoDipendentiPeriodoDiImposta = Double.parseDouble(request.getParameter("costoDipendentiPeriodoDiImposta"));
		double fatturatoPeriodoDiImposta = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
		int numeroTotaleDipendenti = Integer.parseInt(request.getParameter("numeroTotaleDipendenti"));
		DossierDTO dossierObj = new DossierDTO(0, periodoDiImposta, 0, 0, 0, 0);
		
		dossierService.insertDossier(dossierObj);

		visualDossier(request);
		return "homeDossier";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
