package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.TotaleOreReDDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import it.contrader.services.DossierService;
import it.contrader.services.ImpiegatoService;
import it.contrader.services.TotaleOreReDService;

@Controller
@RequestMapping("/TotaleOreReDController")
public class TotaleOreReDController {

	private final TotaleOreReDService totaleOreReDService;
	private final DossierService dossierService;
	private final ImpiegatoService impiegatoService;
	private HttpSession session;
	
	@Autowired
	public TotaleOreReDController(TotaleOreReDService totaleOreReDService, DossierService dossierService,
			ImpiegatoService impiegatoService) {
		this.totaleOreReDService = totaleOreReDService;
		this.dossierService = dossierService;
		this.impiegatoService = impiegatoService;
	}
	
	
	@RequestMapping(value = "/totaleOreReDManagement", method = RequestMethod.GET)
	public String totaleOreReDManagement(HttpServletRequest request) {
		session = request.getSession();
		int idDossier = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("idDossier", idDossier);
		visualTotaleOreReD(request);
		return "/totaleOreReD/manageTotaleOreReD";		
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualTotaleOreReD(request);
		request.setAttribute("option", "insert");
		return "/totaleOreReD/insertTotaleOreReD";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertTotaleOreReD(HttpServletRequest request) {
		int oreLavorateRed = Integer.parseInt(request.getParameter("oreLavorateRed"));
		int idDossier = (int) session.getAttribute("idDossier");
		Dossier dossier = dossierService.getDossierById(idDossier);
		int idNome = Integer.parseInt(request.getParameter("idNome"));
		Impiegato impiegato = impiegatoService.getImpiegatoById(idNome);
		TotaleOreReDDTO totaleOreReDObj = new TotaleOreReDDTO(0, oreLavorateRed,
				dossier, impiegato);
		totaleOreReDService.insertTotaleOreReD(totaleOreReDObj);
		visualTotaleOreReD(request);
		return "/totaleOreReD/manageTotaleOreReD";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiTotaleOreReD(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("readId"));
		TotaleOreReDDTO totaleOreReD = this.totaleOreReDService.getTotaleOreReDDTOById(id);
		request.setAttribute("totaleOreReDDTO", totaleOreReD);
		visualTotaleOreReD(request);
		return "/totaleOreReD/readTotaleOreReD";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("updateId"));
		TotaleOreReDDTO totaleOreReDUpdate = new TotaleOreReDDTO();
		// totaleOreReDUpdate.setTotaleOreReDId(id);

		totaleOreReDUpdate = this.totaleOreReDService.getTotaleOreReDDTOById(id);
		request.setAttribute("totaleOreReDUpdate", totaleOreReDUpdate);
		return "/totaleOreReD/updateTotaleOreReD";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idTotaleOreReD"));
		int idDossier = (int) session.getAttribute("idDossier");
		int oreLavorateRed = Integer.parseInt(request.getParameter("oreLavorateRed"));
		Dossier dossier = dossierService.getDossierById(idDossier);
		int idNome = Integer.parseInt(request.getParameter("idNome"));
		Impiegato impiegato = impiegatoService.getImpiegatoById(idNome);
		TotaleOreReDDTO totaleOreReDObj = new TotaleOreReDDTO(idUpdate, oreLavorateRed,
				dossier, impiegato);
		totaleOreReDService.updateTotaleOreReD(totaleOreReDObj);
		visualTotaleOreReD(request);
		return "/totaleOreReD/manageTotaleOreReD";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		request.setAttribute("id", id);
		this.totaleOreReDService.deleteTotaleOreReDById(id);
		visualTotaleOreReD(request);
		return "/totaleOreReD/manageTotaleOreReD";
	}
	
	private void visualTotaleOreReD(HttpServletRequest request){
		final int idDossier = (int) session.getAttribute("idDossier");
		Dossier dossier = this.dossierService.getDossierById(idDossier);
		List<TotaleOreReDDTO> allTotaleOreReD = this.totaleOreReDService.findTotaleOreReDDTOByDossier(dossier);
		request.setAttribute("allTotaleOreReDDTO", allTotaleOreReD);
	}
}
