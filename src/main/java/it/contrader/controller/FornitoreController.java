package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.FornitoreDTO;
import it.contrader.services.FornitoreService;

@Controller
@RequestMapping("/FornitoreController")
public class FornitoreController {

	private final FornitoreService fornitoreService;
	
	@Autowired
	public FornitoreController(FornitoreService fornitoreService) {
		this.fornitoreService = fornitoreService;
	}
	
	
	@RequestMapping(value = "/fornitoreManagement", method = RequestMethod.GET)
	public String fornitoreManagement(HttpServletRequest request) {
		visualFornitore(request);
		return "/fornitore/manageFornitore";		
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualFornitore(request);
		request.setAttribute("option", "insert");
		return "/fornitore/insertFornitore";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertFornitore(HttpServletRequest request) {
		String nomeFornitore = request.getParameter("nomeFornitore");
		FornitoreDTO fornitoreObj = new FornitoreDTO(0, nomeFornitore);
		fornitoreService.insertFornitore(fornitoreObj);
		visualFornitore(request);
		return "/fornitore/manageFornitore";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String leggiFornitore(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("readId"));
		FornitoreDTO fornitore = this.fornitoreService.getFornitoreDTOById(id);
		request.setAttribute("fornitoreDTO", fornitore);
		visualFornitore(request);
		return "/fornitore/readFornitore";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("updateId"));
		FornitoreDTO fornitoreUpdate = new FornitoreDTO();
		// fornitoreUpdate.setFornitoreId(id);

		fornitoreUpdate = this.fornitoreService.getFornitoreDTOById(id);
		request.setAttribute("fornitoreUpdate", fornitoreUpdate);
		return "/fornitore/updateFornitore";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idFornitore"));
		String nomeFornitore = request.getParameter("nomeFornitore");
		FornitoreDTO fornitoreObj = new FornitoreDTO(idUpdate, nomeFornitore);
		fornitoreService.updateFornitore(fornitoreObj);
		visualFornitore(request);
		return "/fornitore/manageFornitore";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		request.setAttribute("id", id);
		this.fornitoreService.deleteFornitoreById(id);
		visualFornitore(request);
		return "/fornitore/manageFornitore";
	}
	
	private void visualFornitore(HttpServletRequest request){
		List<FornitoreDTO> allFornitore = this.fornitoreService.getAllFornitoreDTO();
		request.setAttribute("allFornitoreDTO", allFornitore);
	}
}
