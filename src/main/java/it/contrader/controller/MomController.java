package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.MomDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.MomService;

@Controller
@RequestMapping("/MomController")
public class MomController {

	private final MomService momService;
	private final AziendaClienteService aziendaClienteService;
	private HttpSession session;
	
	@Autowired
	public MomController(MomService momService, AziendaClienteService aziendaClienteService) {
		this.momService = momService;
		this.aziendaClienteService = aziendaClienteService;
	}
	
	
	@RequestMapping(value = "/momManagement", method = RequestMethod.GET)
	public String momManagement(HttpServletRequest request) {
		session = request.getSession();
		int idAziendaCliente = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("idAziendaCliente", idAziendaCliente);
		visualMom(request);
		return "/mom/manageMom";		
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualMom(request);
		request.setAttribute("option", "insert");
		return "/mom/insertMom";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertMom(HttpServletRequest request) {
		String luogoMom = request.getParameter("luogoMom").toString();
		String dataDelGiornoMom = request.getParameter("dataDelGiornoMom").toString();
		String orarioMom = request.getParameter("orarioMom").toString();
		String oggettoMom = request.getParameter("oggettoMom").toString();
		String progettoMom = request.getParameter("progettoMom").toString();
		String partecipantiMom = request.getParameter("partecipantiMom").toString();
		String testoAgendaMom = request.getParameter("testoAgendaMom").toString();
		String testoAzioneMom = request.getParameter("testoAzioneMom").toString();
		String testoNoteMom = request.getParameter("testoNoteMom").toString();
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		MomDTO momObj = new MomDTO(0, luogoMom, dataDelGiornoMom, orarioMom, oggettoMom,
				progettoMom, partecipantiMom, testoAgendaMom, testoAzioneMom, testoNoteMom,
				aziendaCliente);
		momService.insertMom(momObj);
		visualMom(request);
		return "/mom/manageMom";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiMom(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("readId"));
		MomDTO mom = this.momService.getMomDTOById(id);
		request.setAttribute("momDTO", mom);
		visualMom(request);
		return "/mom/readMom";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("updateId"));
		MomDTO momUpdate = new MomDTO();
		// momUpdate.setMomId(id);

		momUpdate = this.momService.getMomDTOById(id);
		request.setAttribute("momUpdate", momUpdate);
		return "/mom/updateMom";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idMom"));
		String luogoMom = request.getParameter("luogoMom").toString();
		String dataDelGiornoMom = request.getParameter("dataDelGiornoMom").toString();
		String orarioMom = request.getParameter("orarioMom").toString();
		String oggettoMom = request.getParameter("oggettoMom").toString();
		String progettoMom = request.getParameter("progettoMom").toString();
		String partecipantiMom = request.getParameter("partecipantiMom").toString();
		String testoAgendaMom = request.getParameter("testoAgendaMom").toString();
		String testoAzioneMom = request.getParameter("testoAzioneMom").toString();
		String testoNoteMom = request.getParameter("testoNoteMom").toString();
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		MomDTO momObj = new MomDTO(idUpdate, luogoMom, dataDelGiornoMom, orarioMom, oggettoMom,
				progettoMom, partecipantiMom, testoAgendaMom, testoAzioneMom, testoNoteMom,
				aziendaCliente);
		momService.updateMom(momObj);
		visualMom(request);
		return "/mom/manageMom";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		request.setAttribute("id", id);
		this.momService.deleteMomById(id);
		visualMom(request);
		return "/mom/manageMom";
	}
	
	private void visualMom(HttpServletRequest request){
		final int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaCliente aziendaCliente = this.aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		List<MomDTO> allMom = this.momService.findMomDTOByAziendaCliente(aziendaCliente);
		request.setAttribute("allMomDTO", allMom);
	}
}
