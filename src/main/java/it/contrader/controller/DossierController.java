package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.converter.ConverterAziendaCliente;
import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.DossierDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.DossierService;



@Controller
@RequestMapping("/DossierController")
public class DossierController {
	
	//private static final AziendaCliente AziendaCliente = null;
	private DossierService dossierService;
	private AziendaClienteService aziendaClienteService;
	private HttpSession session;
	
	@Autowired
	public DossierController(DossierService dossierService, AziendaClienteService aziendaClienteService) {
		this.dossierService = dossierService;
		this.aziendaClienteService = aziendaClienteService;
	}
	
	private void visualDossier(HttpServletRequest request){
		int idAziendaCliente = Integer.parseInt(request.getParameter("id"));
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		List<DossierDTO> allDossier = this.dossierService.findDossierDTOByAziendaCliente(aziendaCliente);
		request.setAttribute("allDossierDTO", allDossier);
	}

	
	@RequestMapping(value = "/dossierManagement", method = RequestMethod.GET)
	public String dossierManagement(HttpServletRequest request) {
		int idAziendacliente = Integer.parseInt(request.getParameter("id"));
		
		session.setAttribute("idAziendaCliente", idAziendacliente);
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
	
	
	
	@RequestMapping(value = "/cercaDossier", method = RequestMethod.GET)
	public String cercaDossier(HttpServletRequest request) {
		final String content = request.getParameter("search");

		List<DossierDTO> allDossier = this.dossierService.findDossierDTOByPeriodoDiImposta(content);
		request.setAttribute("allDossierDTO", allDossier);

		return "/dossier/manageDossier";

	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int idAzienda = Integer.parseInt(request.getParameter("idAzienda"));
		int idBO= Integer.parseInt(request.getParameter("idBO"));
		DossierDTO dossierUpdate = new DossierDTO();
		// userUpdate.setUserId(id);

		dossierUpdate = this.dossierService.getDossierDTOById(id);
		request.setAttribute("dossierUpdate", dossierUpdate);
		return "/dossier/updateDossier";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idDossierUpdate = Integer.parseInt(request.getParameter("dossierId"));
		String periodoDiImpostaUpdate = request.getParameter("periodoDiImposta");
		int costoDipendentiPeriodoDiImpostaUpdate = Integer.parseInt(request.getParameter("costoDipendentiPeriodoDiImposta"));
		double fatturatoPeriodoDiImpostaUpdate = Integer.parseInt(request.getParameter("fatturatoPeriodoDiImposta"));
		int numeroTotaleDipendentiUpdate = Integer.parseInt(request.getParameter("numeroTotaleDipendenti"));
		
		DossierDTO dossier = new DossierDTO();
		dossier.setIdDossier(idDossierUpdate);
		dossier.setPeriodoDiImposta(periodoDiImpostaUpdate);
		dossier.setCostoDipendentiPeriodoDiImposta(costoDipendentiPeriodoDiImpostaUpdate);
		dossier.setFatturatoPeriodoDiImposta(fatturatoPeriodoDiImpostaUpdate);
		dossier.setNumeroTotaleDipendenti(numeroTotaleDipendentiUpdate);
		dossierService.updateDossier(dossier);
		visualDossier(request);
		return "/dossier/manageDossier";
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualDossier(request);
		request.setAttribute("option", "insert");
		return "/dossier/manageDossier";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertDossier(HttpServletRequest request) {
		int idAzienda = Integer.parseInt(request.getParameter("idAzienda"));
		int idBO= Integer.parseInt(request.getParameter("idBO"));
		String periodoDiImposta = request.getParameter("priodoDiImposta").toString();
		double costoDipendentiPeriodoDiImposta = Double.parseDouble(request.getParameter("costoDipendentiPeriodoDiImposta"));
		double fatturatoPeriodoDiImposta = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
		int numeroTotaleDipendenti = Integer.parseInt(request.getParameter("numeroTotaleDipendenti"));
		DossierDTO dossierObj = new DossierDTO(0, periodoDiImposta, 0, 0, 0, null,null, 0);
		
		dossierService.insertDossier(dossierObj);

		visualDossier(request);
		return "/dossier/manageDossier";
	}
	
	
	
	/**	
	 *   verificare correttezza per istanziare filledfields
	 * 
	 * private List<DossierDTO> prepareDTO(List<DossierDTO> allDossier) {
		List<DossierDTO> retAllDossier = new ArrayList<DossierDTO>();
		
		for(DossierDTO dossier : allDossier) {
			int y=1;
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
	
	                      **/
	
	
}
