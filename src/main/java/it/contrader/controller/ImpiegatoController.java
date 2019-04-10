package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ImpiegatoDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.ImpiegatoService;

@Controller
@RequestMapping("/ImpiegatoController")
public class ImpiegatoController {

	private final ImpiegatoService impiegatoService;
	private final AziendaClienteService aziendaClienteService;
	private HttpSession session;
	
	@Autowired
	public ImpiegatoController(ImpiegatoService impiegatoService, AziendaClienteService aziendaClienteService) {
		this.impiegatoService = impiegatoService;
		this.aziendaClienteService = aziendaClienteService;
	}
	
	
	@RequestMapping(value = "/impiegatoManagement", method = RequestMethod.GET)
	public String impiegatoManagement(HttpServletRequest request) {
		session = request.getSession();
		int idDossier = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("idDossier", idDossier);
		visualImpiegato(request);
		return "/impiegato/manageImpiegato";		
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualImpiegato(request);
		request.setAttribute("option", "insert");
		return "/impiegato/insertImpiegato";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertImpiegato(HttpServletRequest request) {
		String nominativo = request.getParameter("nominativo").toString();
		Integer livello = Integer.parseInt(request.getParameter("livello"));
		String qualifica = request.getParameter("qualifica").toString();
		String mansione = request.getParameter("mansione").toString();
		String titoloDiStudio = request.getParameter("titoloDiStudio").toString();
		Double costoOrario = Double.parseDouble(request.getParameter("costoOrario"));
		Integer totaleOreLavorate = Integer.parseInt(request.getParameter("totaleOreLavorate"));
		Double costoLordoAnnuo = Double.parseDouble(request.getParameter("costoLordoAnnuo"));
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		ImpiegatoDTO impiegatoObj = new ImpiegatoDTO(0, nominativo, livello, qualifica, mansione, titoloDiStudio,
				costoOrario, totaleOreLavorate, costoLordoAnnuo, aziendaCliente);
		impiegatoService.insertImpiegato(impiegatoObj);
		visualImpiegato(request);
		return "/impiegato/manageImpiegato";
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
		Double costoOrario = Double.parseDouble(request.getParameter("costoOrario"));
		Integer totaleOreLavorate = Integer.parseInt(request.getParameter("totaleOreLavorate"));
		Double costoLordoAnnuo = Double.parseDouble(request.getParameter("costoLordoAnnuo"));
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		ImpiegatoDTO impiegatoObj = new ImpiegatoDTO(idUpdate, nominativo, livello, qualifica, mansione, titoloDiStudio,
				costoOrario, totaleOreLavorate, costoLordoAnnuo, aziendaCliente);
		impiegatoService.updateImpiegato(impiegatoObj);
		visualImpiegato(request);
		return "/impiegato/manageImpiegato";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		request.setAttribute("id", id);
		this.impiegatoService.deleteImpiegatoById(id);
		visualImpiegato(request);
		return "/impiegato/manageImpiegato";
	}
	
	private void visualImpiegato(HttpServletRequest request){
		final int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = this.aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		List<ImpiegatoDTO> allImpiegato = this.impiegatoService.findImpiegatoDTOByAziendaCliente(aziendaCliente);
		request.setAttribute("allImpiegatoDTO", allImpiegato);
	}
}
