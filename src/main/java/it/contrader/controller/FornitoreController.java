package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.FornitoreDTO;
import it.contrader.services.FornitoreService;

@CrossOrigin
@RestController
@RequestMapping("/FornitoreController")
public class FornitoreController {

	private final FornitoreService fornitoreService;
	
	@Autowired
	public FornitoreController(FornitoreService fornitoreService) {
		this.fornitoreService = fornitoreService;
	}
	
	@RequestMapping(value = "/fornitoreManagement", method = RequestMethod.GET)
	public List<FornitoreDTO> fornitoreManagement() {
		return this.fornitoreService.getAllFornitoreDTO();	
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody FornitoreDTO fornitore) {
		fornitoreService.insertFornitore(fornitore);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public FornitoreDTO read(@RequestParam(value = "fornitoreId") int id) {
		return this.fornitoreService.getFornitoreDTOById(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody FornitoreDTO fornitore) {
		fornitoreService.updateFornitore(fornitore);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "fornitoreId") int id) {
		this.fornitoreService.deleteFornitoreById(id);
	}

}