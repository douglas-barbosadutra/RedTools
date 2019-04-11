package it.contrader.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.DossierDTO;
import it.contrader.dto.FatturaDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Progetto;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.DossierService;
import it.contrader.services.FatturaService;
import it.contrader.services.ProgettoService;



@Controller
@RequestMapping("/DossierController")
public class DossierController {
	
	//private static final AziendaCliente AziendaCliente = null;
	private final DossierService dossierService;
	private final AziendaClienteService aziendaClienteService;
	private final ProgettoService progettoService;
	private final FatturaService fatturaService;
	private HttpSession session;
	
	@Autowired
	public DossierController(DossierService dossierService, AziendaClienteService aziendaClienteService,
			ProgettoService progettoService, FatturaService fatturaService) {
		this.dossierService = dossierService;
		this.aziendaClienteService = aziendaClienteService;
		this.progettoService = progettoService;
		this.fatturaService = fatturaService;
	}
	
	@RequestMapping(value = "/dossierManagement", method = RequestMethod.GET)
	public String dossierManagement(HttpServletRequest request) {
		session = request.getSession();
		int idProgetto = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("idProgetto", idProgetto);
		visualDossier(request);
		return "/dossier/manageDossier";		
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualDossier(request);
		request.setAttribute("option", "insert");
		return "/dossier/insertDossier";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertDossier(HttpServletRequest request) {
		
		String periodoDiImposta = request.getParameter("periodoDiImposta");
		double costoDipendentiPeriodoDiImposta = Double.parseDouble(request.getParameter("costoDipendentiPeriodoDiImposta"));
		double fatturatoPeriodoDiImposta = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
		int numeroTotaleDipendenti = Integer.parseInt(request.getParameter("numeroTotaleDipendenti"));
		
		int idProgetto = (int) session.getAttribute("idProgetto");
		Progetto progetto = progettoService.getProgettoById(idProgetto);
		
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaClienteDTO aziendaClienteDTO = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		

		DossierDTO dossierObj = new DossierDTO(0, periodoDiImposta, costoDipendentiPeriodoDiImposta, fatturatoPeriodoDiImposta, numeroTotaleDipendenti, 0,0,aziendaClienteDTO, progetto, 0);
		
		dossierService.insertDossier(dossierObj);

		visualDossier(request);
		return "/dossier/manageDossier";
	}
	
	
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		DossierDTO dossierUpdate = new DossierDTO();
		
		dossierUpdate = this.dossierService.getDossierDTOById(id);
		request.setAttribute("dossierUpdate", dossierUpdate);
		return "/dossier/updateDossier";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		
		Integer idDossierUpdate = Integer.parseInt(request.getParameter("dossierId"));
		String periodoDiImpostaUpdate = request.getParameter("periodoDiImposta");
		double costoDipendentiPeriodoDiImpostaUpdate = Double.parseDouble(request.getParameter("costoDipendentiPeriodoDiImposta"));
		double fatturatoPeriodoDiImpostaUpdate = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
		int numeroTotaleDipendentiUpdate = Integer.parseInt(request.getParameter("numeroTotaleDipendenti"));
		
		int idProgetto = (int) session.getAttribute("idProgetto");
		Progetto progetto = progettoService.getProgettoById(idProgetto);
		
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaClienteDTO aziendaCliente = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		
		DossierDTO dossierObj = new DossierDTO(idDossierUpdate, periodoDiImpostaUpdate, costoDipendentiPeriodoDiImpostaUpdate, fatturatoPeriodoDiImpostaUpdate, numeroTotaleDipendentiUpdate, 0, 0, aziendaCliente, progetto, 0);
		dossierService.updateDossier(dossierObj);
		visualDossier(request);
		return "/dossier/manageDossier";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.dossierService.deleteDossierById(id);
		visualDossier(request);
		return "/dossier/manageDossier" ;
		
	}	
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiDossier(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		DossierDTO dossier = this.dossierService.getDossierDTOById(id);
		request.setAttribute("ReadDossierDTO", dossier);
//		visualDossier(request);
		
		return "/dossier/readDossier";
	}
	
	@RequestMapping(value = "/visualizzaFatture", method = RequestMethod.GET)
	public String visualizzaFatture(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Dossier dossier = this.dossierService.getDossierById(id);
		List<FatturaDTO> allFattura = this.fatturaService.findFatturaDTOByDossier(dossier);
		request.setAttribute("allFatturaDTO", calcoloTotaleAmmissibileDTO(allFattura, id));
		return "/dossier/visualizzaFatture";		
	}
	
	@RequestMapping(value = "/readPratica", method = RequestMethod.GET)
	public String leggiPratica(HttpServletRequest request) {
		
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaClienteDTO aziendaCliente = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		request.setAttribute("ReadAziendaCliente", aziendaCliente);
		int id = Integer.parseInt(request.getParameter("id"));
		DossierDTO dossier = this.dossierService.getDossierDTOById(id);
		request.setAttribute("ReadDossierDTO", dossier);
		return "/dossier/readPratica";
	}
	
	
	private void visualDossier(HttpServletRequest request){
		final int idProgetto = (int) session.getAttribute("idProgetto");
		Progetto progetto = progettoService.getProgettoById(idProgetto);
		List<DossierDTO> allDossier = this.dossierService.findDossierDTOByProgetto(progetto);
		request.setAttribute("allDossierDTO", completamentoDTO(allDossier));
	}

	
	
	  
	private List<DossierDTO> completamentoDTO(List<DossierDTO> allDossier) {
		List<DossierDTO> retAllDossier = new ArrayList<DossierDTO>();
		
		
		for(DossierDTO dossier : allDossier) {
			int y=2;
			if((dossier.getPeriodoDiImposta() != null && dossier.getPeriodoDiImposta().equals("")));
				y++;
			if((dossier.getCostoDipendentiPeriodoDiImposta() !=0))
				y++;
			if(dossier.getFatturatoPeriodoDiImposta() !=0)
				y++;
			if(dossier.getNumeroTotaleDipendenti() !=0)
				y++;
			DossierDTO d = new DossierDTO();
			d = dossier;
			d.setFilledFields(y);
			retAllDossier.add(d);
			
		}
		return retAllDossier;
	
	                     
	
	
}
	
	private List<FatturaDTO> calcoloTotaleAmmissibileDTO(List<FatturaDTO> allFattura, int id) {
		
		List<FatturaDTO> retAllFattura = new ArrayList<FatturaDTO>();
		
		double totaleAmmissibile = 0;
		Set<Integer> fornitori = new HashSet<>(Arrays.asList());
		for(FatturaDTO fattura : allFattura) {
			
			FatturaDTO f = new FatturaDTO();
			f = fattura;
			fornitori.add(f.getFornitore().getIdFornitore());
			totaleAmmissibile += f.getTotaleAmmissibile();
			f.setTotaleAmmissibile((fattura.getTotaleImponibile() * fattura.getPercentualeAmmissibile()) / 100);
			retAllFattura.add(f);
			
		}
		
		DossierDTO dossier = this.dossierService.getDossierDTOById(id);
		dossier.setTotaleAmmissibile(totaleAmmissibile);
		dossier.setNumeroFornitori(fornitori.size());
		dossierService.updateDossier(dossier);
		
		return retAllFattura;
		
	}
}
