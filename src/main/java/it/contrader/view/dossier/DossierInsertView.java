package it.contrader.view.dossier;

import java.util.Scanner;

import it.contrader.controller.DossierController;
import it.contrader.controller.Request;
import it.contrader.dto.DossierDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DossierInsertView implements View  {
	
	private DossierController dossierController;
	private Request request;

	public DossierInsertView() {
		this.dossierController = new DossierController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		int idDossier;
		int costoDipendenti;
		double fatturatoPeriodoDiImposta;
		int numeroDipendenti;
		double costiAttivitaRd;
		double costiPersonaleRd;
		String partitaIva;
		int idProgetto;
		String periodoDiImposta;
		String nomedossier;
     
		System.out.println("Inserisci i campi del dossier:");
		
		System.out.println(" costoDipendenti: ");
		costoDipendenti = Integer.parseInt(getInput());
		System.out.println(" fatturatoPeriodoDiImposta: ");
		fatturatoPeriodoDiImposta =Integer.parseInt(getInput());
		System.out.println("numeroDipendenti: ");
		numeroDipendenti= Integer.parseInt(getInput());
		System.out.println("costiAttivitaRd: ");
		costiAttivitaRd = Integer.parseInt(getInput());
		System.out.println("costiPersonaleRd: ");
		costiPersonaleRd = Integer.parseInt(getInput());
		System.out.println(" partitaIva: ");
		partitaIva = (getInput());
		System.out.println("idProgetto: ");
		idProgetto = Integer.parseInt(getInput());
		System.out.println("periodoDiImposta: ");
		periodoDiImposta = (getInput());
		System.out.println(" iserisci id dossier ");
		idDossier = Integer.parseInt(getInput());
		System.out.println(" nome dossier ");
		nomedossier = (getInput());
		
		
		
		if (!nomedossier.equals("") ) {
			dossierController.insertDossier(new DossierDTO(costoDipendenti, fatturatoPeriodoDiImposta,numeroDipendenti,
					costiAttivitaRd,costiPersonaleRd, partitaIva, idProgetto, idDossier, periodoDiImposta));
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Dossier", "doControl", request);
	}

	

}
