package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.converter.ConverterAziendaCliente;
import it.contrader.converter.ConverterProgetto;
import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.MomDTO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.model.Progetto;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.MomService;
import it.contrader.services.ProgettoService;

@Controller
@RequestMapping("/MomController")
public class MomController {

	private final MomService momService;
	private AziendaClienteService aziendaClienteService;
	private ProgettoService progettoService;
	private HttpSession session;
	
	@Autowired
	public MomController(MomService momService) {
		this.momService = momService;
	}
	
	
	@RequestMapping(value = "/momManagement", method = RequestMethod.GET)
	public String momManagement(HttpServletRequest request) {
		session = request.getSession();
		visualMom(request);
		return "/mom/manageMom";		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualMom(request);
		request.setAttribute("option", "insert");
		return "/mom/creaMom";
		
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
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		int idProgetto = Integer.parseInt(request.getParameter("idProgetto"));
		AziendaClienteDTO aziendaClienteDTO = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		AziendaCliente aziendaCliente = ConverterAziendaCliente.toEntity(aziendaClienteDTO);
		ProgettoDTO progettoDTO = progettoService.getProgettoDTOById(idProgetto);
		Progetto progetto = ConverterProgetto.toEntity(progettoDTO);
		MomDTO momObj = new MomDTO(0, luogoMom, dataDelGiornoMom, orarioMom, oggettoMom,
				partecipantiMom, testoAgendaMom, testoAzioneMom, testoNoteMom,
				aziendaCliente, progetto);
		momService.insertMom(momObj);
		visualMom(request);
		return "/mom/manageMom";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
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
		String partecipantiMom = request.getParameter("partecipantiMom").toString();
		String testoAgendaMom = request.getParameter("testoAgendaMom").toString();
		String testoAzioneMom = request.getParameter("testoAzioneMom").toString();
		String testoNoteMom = request.getParameter("testoNoteMom").toString();
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		int idProgetto = Integer.parseInt(request.getParameter("idProgetto"));
		AziendaClienteDTO aziendaClienteDTO = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		AziendaCliente aziendaCliente = ConverterAziendaCliente.toEntity(aziendaClienteDTO);
		ProgettoDTO progettoDTO = progettoService.getProgettoDTOById(idProgetto);
		Progetto progetto = ConverterProgetto.toEntity(progettoDTO);
		MomDTO momObj = new MomDTO(idUpdate, luogoMom, dataDelGiornoMom, orarioMom, oggettoMom,
				partecipantiMom, testoAgendaMom, testoAzioneMom, testoNoteMom,
				aziendaCliente, progetto);
		momService.updateMom(momObj);
		visualMom(request);
		return "/mom/manageMom";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.momService.deleteMomById(id);
		visualMom(request);
		return "/mom/manageMom";
	}
	
	private void visualMom(HttpServletRequest request){
		final int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaClienteDTO aziendaClienteDTO = this.aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		List<MomDTO> allMom = this.momService.findMomDTOByAziendaCliente(aziendaClienteDTO);
		request.setAttribute("allMomDTO", allMom);
	}
}
