package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DossierDTO;
import it.contrader.dto.ImpiegatoDTO;
import it.contrader.dto.MomDTO;
import it.contrader.dto.TotaleOreReDDTO;
import it.contrader.model.AziendaCliente;
import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.DossierService;
import it.contrader.services.ImpiegatoService;
import it.contrader.services.TotaleOreReDService;

@Controller
@RestController
@RequestMapping("/ImpiegatoController")
public class ImpiegatoController {

	private final ImpiegatoService impiegatoService;
	private final AziendaClienteService aziendaClienteService;
	private final DossierService dossierService;
	private final TotaleOreReDService totaleOreReDService;
	
	@Autowired
	public ImpiegatoController(ImpiegatoService impiegatoService, AziendaClienteService aziendaClienteService, DossierService dossierService, TotaleOreReDService totaleOreReDService) {
		this.impiegatoService = impiegatoService;
		this.aziendaClienteService = aziendaClienteService;
		this.dossierService = dossierService;
		this.totaleOreReDService = totaleOreReDService;
	}
	
	
	@RequestMapping(value = "/impiegatoManagement", method = RequestMethod.GET)
	public List <ImpiegatoDTO>impiegatoManagement(@RequestParam(value="idAziendaCliente") int idAziendaCliente ) {
		AziendaCliente aziendaCliente = aziendaClienteService.getAziendaClienteById(idAziendaCliente);
		return impiegatoService.findImpiegatoDTOByAziendaCliente(aziendaCliente);

	}
		
	
//	private void AggiornaDossier(DossierDTO d) {
//		int idAz = (int) session.getAttribute("idAziendaCliente");
//		AziendaCliente a= aziendaClienteService.getAziendaClienteById(idAz);
//		List<ImpiegatoDTO> allImpiegato = this.impiegatoService.findImpiegatoDTOByAziendaCliente(a);
//		DossierDTO k = d;
//		int n = 0;
//		Double TotaleCostiRedTot = 0.0;
//		Double CostoLordoAnnuoTot = 0.0 ;
//			for (ImpiegatoDTO impiegatoDTO : allImpiegato) {
//				TotaleCostiRedTot += impiegatoDTO.getTotaleCostiRed();
//				CostoLordoAnnuoTot +=impiegatoDTO.getCostoLordoAnnuo();
//				n++;
//			}
//		k.setCostiPersonaleReD(TotaleCostiRedTot);	
//		k.setNumeroTotaleDipendenti(n);
//		k.setCostoDipendentiPeriodoDiImposta(CostoLordoAnnuoTot);
//		dossierService.updateDossier(k);
//	}
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insertImpiegato (@RequestBody ImpiegatoDTO impiegatoDTO) {
			impiegatoService.insertImpiegato(impiegatoDTO);
	
	
	
	
	
//		
//		TotaleOreReDDTO totaleOreReDDTOs = new TotaleOreReDDTO();
//		totaleOreReDDTOs.setImpiegato(im);
//		totaleOreReDDTOs.setDossier(d);
//		totaleOreReDDTOs.setOreLavorateRed(0);
//		totaleOreReDService.insertTotaleOreReD(totaleOreReDDTOs);
//		TotaleOreReDDTO oreRedImp = totaleOreReDService.getTotaleOreReDDTOByImpiegato(im);
//		oreRedImp.setOreLavorateRed(totaleOreRed);
//		totaleOreReDService.updateTotaleOreReD(oreRedImp);
//		visualImpiegato(request);
//		
//		int idDossier = (int) session.getAttribute("idDossier");
//		DossierDTO dossierDTO = this.dossierService.getDossierDTOById(idDossier);
//		dossierDTO.setCostoDipendentiPeriodoDiImposta(aggiuntaCostiPersonale(costoLordoAnnuo,dossierDTO));
//		
//		dossierService.updateDossier(dossierDTO);
//		AggiornaDossier(dossierDTO);
//		return "/impiegato/manageImpiegato";
	}
	
//	private double aggiuntaCostiPersonale (double costoLordoAnnuoImpiegato , DossierDTO dossier) {
//		DossierDTO d;
//		d=dossier;
//		double somma;
//		somma=d.getCostoDipendentiPeriodoDiImposta();
//		somma+=costoLordoAnnuoImpiegato;
//		return somma;
//	}
	

	

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
			public void updateImpiegato(@RequestBody ImpiegatoDTO impiegatoDTO) {
				impiegatoService.updateImpiegato(impiegatoDTO);
		
	}
	
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value="idImpiegato") int idImpiegato ){
			impiegatoService.deleteImpiegatoById(idImpiegato);
	}
	
	
}
