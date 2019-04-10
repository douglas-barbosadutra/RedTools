package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.FatturaDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Fornitore;
import it.contrader.services.DossierService;
import it.contrader.services.FatturaService;
import it.contrader.services.FornitoreService;

@Controller
@RequestMapping("/FatturaController")
public class FatturaController {

	private final FatturaService fatturaService;
	private final DossierService dossierService;
	private final FornitoreService fornitoreService;
	private HttpSession session;
	
	@Autowired
	public FatturaController(FatturaService fatturaService, DossierService dossierService,
			FornitoreService fornitoreService) {
		this.fatturaService = fatturaService;
		this.dossierService = dossierService;
		this.fornitoreService = fornitoreService;
	}
	
	
	@RequestMapping(value = "/fatturaManagement", method = RequestMethod.GET)
	public String fatturaManagement(HttpServletRequest request) {
		session = request.getSession();
		int idFornitore = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("idFornitore", idFornitore);
		visualFattura(request);
		return "/fattura/manageFattura";		
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualFattura(request);
		request.setAttribute("option", "insert");
		return "/fattura/insertFattura";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertFattura(HttpServletRequest request) {
		String dataFattura = request.getParameter("dataFattura");
		String numeroFattura = request.getParameter("numeroFattura");
		String descrizione = request.getParameter("descrizione");
		double totaleImponibile = Double.parseDouble(request.getParameter("totaleImponibile"));
		int percentualeAmmissibile = Integer.parseInt(request.getParameter("percentualeAmmissibile"));
		int idDossier = (int) session.getAttribute("idDossier");
		Dossier dossier = dossierService.getDossierById(idDossier);
		int idFornitore = (int) session.getAttribute("idFornitore");
		Fornitore fornitore = fornitoreService.getFornitoreById(idFornitore);
		FatturaDTO fatturaObj = new FatturaDTO(0, dataFattura, numeroFattura, descrizione,
				totaleImponibile, percentualeAmmissibile, dossier, fornitore);
		fatturaService.insertFattura(fatturaObj);
		visualFattura(request);
		return "/fattura/manageFattura";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiFattura(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("readId"));
		FatturaDTO fattura = this.fatturaService.getFatturaDTOById(id);
		request.setAttribute("fatturaDTO", fattura);
		visualFattura(request);
		return "/fattura/readFattura";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("updateId"));
		FatturaDTO fatturaUpdate = new FatturaDTO();
		// fatturaUpdate.setFatturaId(id);

		fatturaUpdate = this.fatturaService.getFatturaDTOById(id);
		request.setAttribute("fatturaUpdate", fatturaUpdate);
		return "/fattura/updateFattura";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idFattura"));
		String dataFattura = request.getParameter("dataFattura");
		String numeroFattura = request.getParameter("numeroFattura");
		String descrizione = request.getParameter("descrizione");
		double totaleImponibile = Double.parseDouble(request.getParameter("totaleImponibile"));
		int percentualeAmmissibile = Integer.parseInt(request.getParameter("percentualeAmmissibile"));
		int idDossier = (int) session.getAttribute("idDossier");
		Dossier dossier = dossierService.getDossierById(idDossier);
		int idFornitore = (int) session.getAttribute("idFornitore");
		Fornitore fornitore = fornitoreService.getFornitoreById(idFornitore);
		FatturaDTO fatturaObj = new FatturaDTO(idUpdate, dataFattura, numeroFattura, descrizione,
				totaleImponibile, percentualeAmmissibile, dossier, fornitore);
		fatturaService.updateFattura(fatturaObj);
		visualFattura(request);
		return "/fattura/manageFattura";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		request.setAttribute("id", id);
		this.fatturaService.deleteFatturaById(id);
		visualFattura(request);
		return "/fattura/manageFattura";
	}
	
	private void visualFattura(HttpServletRequest request){
		final int idFornitore = (int) session.getAttribute("idFornitore");
		final int idDossier = (int) session.getAttribute("idDossier");
		Fornitore fornitore = this.fornitoreService.getFornitoreById(idFornitore);
		Dossier dossier = this.dossierService.getDossierById(idDossier);
		List<FatturaDTO> allFattura = this.fatturaService.findFatturaDTOByFornitoreAndDossier(fornitore, dossier);
		request.setAttribute("allFatturaDTO", allFattura);
	}
}
