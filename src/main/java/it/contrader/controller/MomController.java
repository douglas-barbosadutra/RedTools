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
import it.contrader.model.Progetto;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.MomService;


@Controller
@RequestMapping("/Mom")
public class MomController {

	private final MomService momService;
	private AziendaClienteService aziendaClienteService;
	private HttpSession session;
	
	@Autowired
	public MomController(MomService momService) {
		this.momService = momService;
	}
	
	private void visualMom(HttpServletRequest request){
		final int idAziendaCliente = Integer.parseInt(request.getParameter("idAziendaCliente"));
		AziendaClienteDTO aziendaClienteDTO = this.aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		List<MomDTO> allMom = this.momService.findMomDTOByIdAziendaCliente(aziendaClienteDTO);
		request.setAttribute("allMomDTO", allMom);
	}
	
	@RequestMapping(value = "/momManagement", method = RequestMethod.GET)
	public String momManagement(HttpServletRequest request) {
		visualMom(request);
		return "homeMom";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.momService.deleteMomById(id);
		visualMom(request);
		return "homeMom";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualMom(request);
		request.setAttribute("option", "insert");
		return "creaMom";
		
	}
	
	
	
	@RequestMapping(value = "/creaMom", method = RequestMethod.POST)
	public String insertMom(HttpServletRequest request) {
		
		String luogoMom = request.getParameter("luogoMom").toString();
		
		String dataDelGiornoMom = request.getParameter("dataDelGiornoMom").toString();
		
		String orarioMom = request.getParameter("orarioMom").toString();
		
		String oggettoMom = request.getParameter("oggettoMom").toString();
		
		String partecipantiMom = request.getParameter("partecipantiMom").toString();
		
		String testoAgendaMom = request.getParameter("testoAgendaMom").toString();
		
		String testoAzioneMom = request.getParameter("testoAzioneMom").toString();
		
		String testoNoteMom = request.getParameter("testoNoteMom").toString();

		MomDTO momObj = new MomDTO(0, luogoMom, dataDelGiornoMom, orarioMom, oggettoMom,
				partecipantiMom, testoAgendaMom, testoAzioneMom, testoNoteMom);
		
		momService.insertMom(momObj);

		visualMom(request);
		return "homeMom";
	}
	
}
