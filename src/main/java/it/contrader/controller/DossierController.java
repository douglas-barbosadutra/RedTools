package it.contrader.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.DossierDTO;
import it.contrader.dto.FatturaDTO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.dto.TotaleOreReDDTO;
import it.contrader.model.Dossier;
import it.contrader.model.Progetto;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.DossierService;
import it.contrader.services.FatturaService;
import it.contrader.services.ProgettoService;
import it.contrader.services.TotaleOreReDService;
import it.contrader.utils.GestoreEccezioni;



@Controller
@RequestMapping("/DossierController")
public class DossierController {
	
	private final DossierService dossierService;
	private final AziendaClienteService aziendaClienteService;
	private final ProgettoService progettoService;
	private final FatturaService fatturaService;
	private final TotaleOreReDService totaleOreReDService;
	private HttpSession session;
	
	@Autowired
	public DossierController(DossierService dossierService, AziendaClienteService aziendaClienteService,
			ProgettoService progettoService, FatturaService fatturaService, TotaleOreReDService totaleOreReDService) {
		this.dossierService = dossierService;
		this.aziendaClienteService = aziendaClienteService;
		this.progettoService = progettoService;
		this.fatturaService = fatturaService;
		this.totaleOreReDService = totaleOreReDService;
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
		double costoDipendentiPeriodoDiImposta = 0;
		double fatturatoPeriodoDiImposta = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
//		int numeroTotaleDipendenti = Integer.parseInt(request.getParameter("numeroTotaleDipendenti"));
		
		int idProgetto = (int) session.getAttribute("idProgetto");
		ProgettoDTO progetto = progettoService.findProgettoDTOById(idProgetto);
		
		DossierDTO dossierObj = new DossierDTO(0, periodoDiImposta, costoDipendentiPeriodoDiImposta, fatturatoPeriodoDiImposta, 0, 0, 0, 0, 0, progetto, 0);
		
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
//		double costoDipendentiPeriodoDiImpostaUpdate = Double.parseDouble(request.getParameter("costoDipendentiPeriodoDiImposta"));
		double fatturatoPeriodoDiImpostaUpdate = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
//		int numeroTotaleDipendentiUpdate = Integer.parseInt(request.getParameter("numeroTotaleDipendenti"));
		
		int idProgetto = (int) session.getAttribute("idProgetto");
		ProgettoDTO progetto = progettoService.findProgettoDTOById(idProgetto);
		
		DossierDTO doss = this.dossierService.getDossierDTOById(idDossierUpdate);
//		DossierDTO dossierObj = new DossierDTO(idDossierUpdate, periodoDiImpostaUpdate, costoDipendentiPeriodoDiImpostaUpdate, fatturatoPeriodoDiImpostaUpdate, numeroTotaleDipendentiUpdate, 0, 0, 0, 0, progetto, 0);
		doss.setPeriodoDiImposta(periodoDiImpostaUpdate);
		doss.setFatturatoPeriodoDiImposta(fatturatoPeriodoDiImpostaUpdate);
		dossierService.updateDossier(doss);
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
	
	@RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
	public void getFile(
	    @PathVariable("file_name") String fileName, 
	    HttpServletResponse response, HttpServletRequest request) {
//		String path="C:\\Users\\Contrader\\Desktop\\CONTRADER\\RedToolSpring\\RedTools\\src\\main\\resources\\files\\";
		int idProgetto = (int) session.getAttribute("idProgetto");
		Progetto progetto = progettoService.getProgettoById(idProgetto);
		
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaClienteDTO aziendaCliente = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		int id = Integer.parseInt(request.getParameter("id"));
		Dossier dossier = this.dossierService.getDossierById(id);
		List<FatturaDTO> allFattura = this.fatturaService.findFatturaDTOByDossier(dossier);
		allFattura = calcoloTotaleAmmissibileDTO(allFattura, id);
		List<TotaleOreReDDTO> allTotaleOreReDDTO = this.totaleOreReDService.findTotaleOreReDDTOByDossier(dossier);
		allTotaleOreReDDTO = sommaOreReDDTO(allTotaleOreReDDTO, id);
		
		
		try {
			File sourceFile = ResourceUtils.getFile("classpath:files\\docTables.xlsm");
			InputStream sourceIs = new FileInputStream(sourceFile);
		    Workbook workbook;
		    workbook = new XSSFWorkbook(
		        OPCPackage.open(sourceIs)
		    );

		    //DO STUF WITH WORKBOOK
		    Sheet sheet = workbook.getSheetAt(0);
		    Cell cell2Update = sheet.getRow(2).getCell(2);
		    cell2Update.setCellValue(dossier.getPeriodoDiImposta());
		    cell2Update = sheet.getRow(4).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getDenominazioneSocieta());
		    cell2Update = sheet.getRow(5).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getFormaGiuridica());
		    cell2Update = sheet.getRow(7).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getSedeLegale());
		    cell2Update = sheet.getRow(8).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getPartitaIva());
		    cell2Update = sheet.getRow(9).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getTelefono());
		    cell2Update = sheet.getRow(10).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getEmail());
		    cell2Update = sheet.getRow(12).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getIndirizzoUnitaLocale());
		    cell2Update = sheet.getRow(14).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getAttivitaAzienda());
		    cell2Update = sheet.getRow(16).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getLegaleRappresentante());
		    cell2Update = sheet.getRow(17).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getNatoA());
		    cell2Update = sheet.getRow(18).getCell(2);
		    cell2Update.setCellValue(aziendaCliente.getNatoIl());
		    cell2Update = sheet.getRow(20).getCell(2);
		    cell2Update.setCellValue(dossier.getCostoDipendentiPeriodoDiImposta());
		    cell2Update = sheet.getRow(21).getCell(2);
		    cell2Update.setCellValue(dossier.getFatturatoPeriodoDiImposta());
		    cell2Update = sheet.getRow(22).getCell(2);
		    cell2Update.setCellValue(dossier.getNumeroTotaleDipendenti());
		    cell2Update = sheet.getRow(24).getCell(2);
		    double sum = dossier.getTotaleCostiReD() + dossier.getCostiPersonaleReD();
		    cell2Update.setCellValue(sum);
		    cell2Update = sheet.getRow(25).getCell(2);
		    cell2Update.setCellValue(dossier.getCostiPersonaleReD());
		    cell2Update = sheet.getRow(27).getCell(2);
		    cell2Update.setCellValue(progetto.getTitoloProgetto());
		    cell2Update = sheet.getRow(28).getCell(2);
		    cell2Update.setCellValue(progetto.getDettagliProgetto());
		    cell2Update = sheet.getRow(29).getCell(2);
		    cell2Update.setCellValue(progetto.getCoordinateDIIN());
		    cell2Update = sheet.getRow(31).getCell(2);
		    cell2Update.setCellValue(dossier.getTotaleAmmissibile());
		    
		    sheet = workbook.getSheetAt(1);
		    
		    int i=4;
		    for (FatturaDTO fattura : allFattura) {
		    	
		    	cell2Update = sheet.getRow(i).getCell(2);
			    cell2Update.setCellValue(fattura.getFornitore().getNomeFornitore());
			    cell2Update = sheet.getRow(i).getCell(3);
			    cell2Update.setCellValue(fattura.getDataFattura());
			    cell2Update = sheet.getRow(i).getCell(4);
			    cell2Update.setCellValue(fattura.getNumeroFattura());
			    cell2Update = sheet.getRow(i).getCell(5);
			    cell2Update.setCellValue(fattura.getDescrizione());
			    cell2Update = sheet.getRow(i).getCell(6);
			    cell2Update.setCellValue(fattura.getTotaleImponibile());
			    cell2Update = sheet.getRow(i).getCell(7);
			    cell2Update.setCellValue((fattura.getPercentualeAmmissibile())/100);
			    cell2Update = sheet.getRow(i).getCell(8);
			    cell2Update.setCellValue(fattura.getTotaleAmmissibile());
			    i++; 
			}

		    if (allFattura.size()>0 && allFattura.get(0) != null) {
		    	cell2Update = sheet.getRow(8).getCell(8);
		    	cell2Update.setCellValue(allFattura.get(0).getDossier().getTotaleAmmissibile());
		    	
		    	cell2Update = sheet.getRow(10).getCell(8);
		    	cell2Update.setCellValue(allFattura.get(0).getDossier().getNumeroFornitori());
		    	
		    }
		    
		    sheet = workbook.getSheetAt(2);
		    
		    i=3;
			for (TotaleOreReDDTO totaleOreReD : allTotaleOreReDDTO) {
				
				cell2Update = sheet.getRow(i).getCell(5);
			    cell2Update.setCellValue((totaleOreReD.getImpiegato().getPercTotRed())/100);
				cell2Update = sheet.getRow(i).getCell(12);
			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getNominativo());
			    cell2Update = sheet.getRow(i).getCell(13);
			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getLivello());
			    cell2Update = sheet.getRow(i).getCell(14);
			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getQualifica());
			    cell2Update = sheet.getRow(i).getCell(15);
			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getMansione());
			    cell2Update = sheet.getRow(i).getCell(16);
			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getTitoloDiStudio());
//			    cell2Update = sheet.getRow(i).getCell(17);
//			    cell2Update.setCellValue(totaleOreReD.getOreLavorateRed());
//			    cell2Update = sheet.getRow(i).getCell(18);
//			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getCostoOrario());
//			    cell2Update = sheet.getRow(i).getCell(19);
//			    cell2Update.setCellValue(totaleOreReD.getTotaleCostiReD());
			    cell2Update = sheet.getRow(i).getCell(7);
			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getTotaleOreLavorate());
			    cell2Update = sheet.getRow(i).getCell(8);
			    cell2Update.setCellValue(totaleOreReD.getImpiegato().getCostoLordoAnnuo());
				i++;
			}
			File resultFile = ResourceUtils.getFile("classpath:files\\" + fileName);
			
			FileOutputStream out = new FileOutputStream(resultFile);
		    workbook.write(out);
		    out.close();
		    System.out.println("xlsm created successfully..");

		
		
		// file download 
	   
	      // get your file as InputStream
	      InputStream is = new FileInputStream(resultFile);
	      // copy it to response's OutputStream
	      
	      String type = "vnd.ms-excel";
	      response.setHeader("content-disposition", "attachment; filename=mod_docTables.xlsm");
	      response.setContentType(type);
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
	    } catch (IOException ex) {
	    	GestoreEccezioni.getInstance().gestisciEccezione(ex);
		} catch (InvalidFormatException e) {
		    e.printStackTrace();
		}

	}	
	@RequestMapping(value = "/visualizzaCostiEsterni", method = RequestMethod.GET)
	public String visualizzaCostiEsterni(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Dossier dossier = this.dossierService.getDossierById(id);
		List<FatturaDTO> allFattura = this.fatturaService.findFatturaDTOByDossier(dossier);
		request.setAttribute("allFatturaDTO", calcoloTotaleAmmissibileDTO(allFattura, id));
		return "/dossier/visualizzaCostiEsterni";		
	}
	
	@RequestMapping(value = "/visualizzaDipendenti", method = RequestMethod.GET)
	public String visualizzaDipendenti(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Dossier dossier = this.dossierService.getDossierById(id);
		List<TotaleOreReDDTO> allTotaleOreReD = this.totaleOreReDService.findTotaleOreReDDTOByDossier(dossier);
		request.setAttribute("allTotaleOreReD", sommaOreReDDTO(allTotaleOreReD, id));
		return "/dossier/visualizzaDipendenti";		
	}
	
	@RequestMapping(value = "/readPratica", method = RequestMethod.GET)
	public String leggiPratica(HttpServletRequest request) {
		
		int idDossier = Integer.parseInt(request.getParameter("id"));
		Dossier dossier = this.dossierService.getDossierById(idDossier);
		List<TotaleOreReDDTO> allTotaleOreReDDTO = this.totaleOreReDService.findTotaleOreReDDTOByDossier(dossier);
		List<TotaleOreReDDTO> lista = sommaOreReDDTO(allTotaleOreReDDTO, idDossier);
		
		List<FatturaDTO> allFattura = this.fatturaService.findFatturaDTOByDossier(dossier);
		List<FatturaDTO> lista2 = calcoloTotaleAmmissibileDTO(allFattura, idDossier);
		
		int idAziendaCliente = (int) session.getAttribute("idAziendaCliente");
		AziendaClienteDTO aziendaCliente = aziendaClienteService.getAziendaClienteDTOById(idAziendaCliente);
		request.setAttribute("ReadAziendaCliente", aziendaCliente);
		
		DossierDTO dossierDTO = this.dossierService.getDossierDTOById(idDossier);
		request.setAttribute("ReadDossierDTO", dossierDTO);
		
		ProgettoDTO progetto = dossierDTO.getProgettoDTO();
		request.setAttribute("ReadProgetto", progetto);
		
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
		double totaleCostiReD = 0;
		Set<Integer> fornitori = new HashSet<>(Arrays.asList());
		for(FatturaDTO fattura : allFattura) {
			
			FatturaDTO f = new FatturaDTO();
			f = fattura;
			fornitori.add(f.getFornitore().getIdFornitore());
			f.setTotaleAmmissibile((fattura.getTotaleImponibile() * fattura.getPercentualeAmmissibile()) / 100);
			totaleAmmissibile += f.getTotaleAmmissibile();
			totaleCostiReD += f.getTotaleImponibile();
			retAllFattura.add(f);
			
		}
		
		DossierDTO dossier = this.dossierService.getDossierDTOById(id);
		dossier.setTotaleAmmissibile(totaleAmmissibile);
		dossier.setTotaleCostiReD(totaleCostiReD);
		dossier.setNumeroFornitori(fornitori.size());
		dossierService.updateDossier(dossier);
		
		return retAllFattura;
		
	}
	
	private List<TotaleOreReDDTO> sommaOreReDDTO(List<TotaleOreReDDTO> TotaleOreReDDTO, int id) {
		
		List<TotaleOreReDDTO> retAllTotaleOreReD = new ArrayList<TotaleOreReDDTO>();
		
		double costiPersonaleReD = 0;
		for (TotaleOreReDDTO totaleOreReD : TotaleOreReDDTO ) {
			
			TotaleOreReDDTO totOre = new TotaleOreReDDTO();
			totOre = totaleOreReD;
			double totaleCostiReD = totaleOreReD.getOreLavorateRed() * totaleOreReD.getImpiegato().getCostoOrario();
			costiPersonaleReD += totaleCostiReD; 
			totOre.setTotaleCostiReD(totaleCostiReD);
			retAllTotaleOreReD.add(totOre);
			
		}
		DossierDTO dossier = this.dossierService.getDossierDTOById(id);
		dossier.setCostiPersonaleReD(costiPersonaleReD);
		dossierService.updateDossier(dossier);
		
		return retAllTotaleOreReD;
		
	}
	
	
	
	
	
	
	
	
	
	
}





