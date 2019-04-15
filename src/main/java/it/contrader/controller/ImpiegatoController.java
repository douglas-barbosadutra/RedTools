package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.DossierDTO;
import it.contrader.dto.ImpiegatoDTO;
import it.contrader.dto.TotaleOreReDDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import it.contrader.model.TotaleOreReD;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.DossierService;
import it.contrader.services.ImpiegatoService;
import it.contrader.services.TotaleOreReDService;

@Controller
@RequestMapping("/ImpiegatoController")
public class ImpiegatoController {

	private final ImpiegatoService impiegatoService;
	private final AziendaClienteService aziendaClienteService;
	private final DossierService dossierService;
	private final TotaleOreReDService totaleOreReDService;
	private HttpSession session;
	
	@Autowired
	public ImpiegatoController(ImpiegatoService impiegatoService, AziendaClienteService aziendaClienteService, DossierService dossierService, TotaleOreReDService totaleOreReDService) {
		this.impiegatoService = impiegatoService;
		this.aziendaClienteService = aziendaClienteService;
		this.dossierService = dossierService;
		this.totaleOreReDService = totaleOreReDService;
	}
	
	
	@RequestMapping(value = "/impiegatoManagement", method = RequestMethod.GET)
	public String impiegatoManagement(HttpServletRequest request) {
		session = request.getSession();
		int idDossier = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("idDossier", idDossier);
		DossierDTO dossi = dossierService.getDossierDTOById(idDossier);
		int idAz = (int) session.getAttribute("idAziendaCliente");
		AziendaClienteDTO az = this.aziendaClienteService.getAziendaClienteDTOById(idAz);
		request.setAttribute("nomeAziendaCliente", az.getDenominazioneSocieta());
		visualImpiegato(request);
		AggiornaDossier(dossi);
		return "/impiegato/manageImpiegato";		
	}
	
	private void AggiornaDossier(DossierDTO d) {
		int idAz = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente a= aziendaClienteService.getAziendaClienteById(idAz);
		List<ImpiegatoDTO> allImpiegato = this.impiegatoService.findImpiegatoDTOByAziendaCliente(a);
		DossierDTO k = d;
		int n = 0;
		Double TotaleCostiRedTot = 0.0;
		Double CostoLordoAnnuoTot = 0.0 ;
			for (ImpiegatoDTO impiegatoDTO : allImpiegato) {
				TotaleCostiRedTot += impiegatoDTO.getTotaleCostiRed();
				CostoLordoAnnuoTot +=impiegatoDTO.getCostoLordoAnnuo();
				n++;
			}
		k.setCostiPersonaleReD(TotaleCostiRedTot);	
		k.setNumeroTotaleDipendenti(n);
		k.setCostoDipendentiPeriodoDiImposta(CostoLordoAnnuoTot);
		dossierService.updateDossier(k);
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualImpiegato(request);
		request.setAttribute("option", "insert");
		return "/impiegato/insertImpiegato";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertImpiegato(HttpServletRequest request) {
		String nominativo = request.getParameter("nominativo");
		Integer livello = Integer.parseInt(request.getParameter("livello"));
		String qualifica = request.getParameter("qualifica").toString();
		String mansione = request.getParameter("mansione").toString();
		String titoloDiStudio = request.getParameter("titoloDiStudio").toString();
		Integer totaleOreLavorate = Integer.parseInt(request.getParameter("totaleOreLavorate"));
		Double costoLordoAnnuo = Double.parseDouble(request.getParameter("costoLordoAnnuo"));
		Double percTotRed = Double.parseDouble(request.getParameter("percTotRed"));
		
		Double costoOrario = (costoLordoAnnuo / totaleOreLavorate);
		Double totaleOreRed = (totaleOreLavorate*percTotRed)/100;
		Double totaleCostiRed = (totaleOreRed*costoOrario);
		
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		
		ImpiegatoDTO impiegatoObj = new ImpiegatoDTO(0, nominativo, livello, qualifica, mansione, titoloDiStudio,
				totaleOreLavorate, costoLordoAnnuo, percTotRed, costoOrario, totaleOreRed, totaleCostiRed, aziendaCliente);
		impiegatoService.insertImpiegato(impiegatoObj);
		
		Impiegato im = impiegatoService.findImpiegatoByNominativo(nominativo);
		int id =(int)session.getAttribute("idDossier");
		Dossier d = dossierService.getDossierById(id);
		
		TotaleOreReDDTO totaleOreReDDTOs = new TotaleOreReDDTO();
		totaleOreReDDTOs.setImpiegato(im);
		totaleOreReDDTOs.setDossier(d);
		totaleOreReDDTOs.setOreLavorateRed(0);
		totaleOreReDService.insertTotaleOreReD(totaleOreReDDTOs);
		TotaleOreReDDTO oreRedImp = totaleOreReDService.getTotaleOreReDDTOByImpiegato(im);
		oreRedImp.setOreLavorateRed(totaleOreRed);
		totaleOreReDService.updateTotaleOreReD(oreRedImp);
		visualImpiegato(request);
		
		int idDossier = (int) session.getAttribute("idDossier");
		DossierDTO dossierDTO = this.dossierService.getDossierDTOById(idDossier);
		dossierDTO.setCostoDipendentiPeriodoDiImposta(aggiuntaCostiPersonale(costoLordoAnnuo,dossierDTO));
		
		dossierService.updateDossier(dossierDTO);
		AggiornaDossier(dossierDTO);
		return "/impiegato/manageImpiegato";
	}
	
	private double aggiuntaCostiPersonale (double costoLordoAnnuoImpiegato , DossierDTO dossier) {
		DossierDTO d;
		d=dossier;
		double somma;
		somma=d.getCostoDipendentiPeriodoDiImposta();
		somma+=costoLordoAnnuoImpiegato;
		return somma;
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiImpiegato(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("readId"));
		ImpiegatoDTO impiegato = this.impiegatoService.getImpiegatoDTOById(id);
		request.setAttribute("impiegatoDTO", impiegato);
		visualImpiegato(request);
		return "/impiegato/readImpiegato";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("updateId"));
		ImpiegatoDTO impiegatoUpdate = new ImpiegatoDTO();
		// impiegatoUpdate.setImpiegatoId(id);

		impiegatoUpdate = this.impiegatoService.getImpiegatoDTOById(id);
		request.setAttribute("impiegatoUpdate", impiegatoUpdate);
		return "/impiegato/updateImpiegato";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idImpiegato"));
		String nominativo = request.getParameter("nominativo").toString();
		Integer livello = Integer.parseInt(request.getParameter("livello"));
		String qualifica = request.getParameter("qualifica").toString();
		String mansione = request.getParameter("mansione").toString();
		String titoloDiStudio = request.getParameter("titoloDiStudio").toString();
		Integer totaleOreLavorate = Integer.parseInt(request.getParameter("totaleOreLavorate"));
		Double costoLordoAnnuo = Double.parseDouble(request.getParameter("costoLordoAnnuo"));
		Double percTotRed = Double.parseDouble(request.getParameter("percTotRed"));
		Double costoOrario = (costoLordoAnnuo / totaleOreLavorate);
		Double totaleOreRed = (totaleOreLavorate*percTotRed)/100;
		Double totaleCostiRed = (totaleOreRed*costoOrario);
		
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		ImpiegatoDTO impiegatoObj = new ImpiegatoDTO(idUpdate, nominativo, livello, qualifica, mansione, titoloDiStudio,
			 totaleOreLavorate, costoLordoAnnuo, percTotRed, costoOrario, totaleOreRed, totaleCostiRed, aziendaCliente);
		impiegatoService.updateImpiegato(impiegatoObj);
		
		Impiegato im = impiegatoService.findImpiegatoByNominativo(nominativo);
		TotaleOreReDDTO oreRedImp = totaleOreReDService.getTotaleOreReDDTOByImpiegato(im);
		oreRedImp.setOreLavorateRed(totaleOreRed);
		totaleOreReDService.updateTotaleOreReD(oreRedImp);
		
		visualImpiegato(request);
		
		int idDossier = (int) session.getAttribute("idDossier");
		DossierDTO dossi = dossierService.getDossierDTOById(idDossier);
		AggiornaDossier(dossi);
		return "/impiegato/manageImpiegato";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		request.setAttribute("id", id);
		this.impiegatoService.deleteImpiegatoById(id);
		visualImpiegato(request);
		int idDossier = (int) session.getAttribute("idDossier");
		DossierDTO dossi = dossierService.getDossierDTOById(idDossier);
		AggiornaDossier(dossi);
		return "/impiegato/manageImpiegato";
	}
	
	private void visualImpiegato(HttpServletRequest request){
		final int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = this.aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		List<ImpiegatoDTO> allImpiegato = this.impiegatoService.findImpiegatoDTOByAziendaCliente(aziendaCliente);
		request.setAttribute("allImpiegatoDTO", allImpiegato);
	}
}
