package it.contrader.view;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import it.contrader.controller.DossierController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Dossier;

public class DossierView implements View {
	
	
	private DossierController dossierController;
	private Request request;
	private String choice;
	
	public DossierView() {
		this.dossierController = new DossierController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione dossier -------\n");
		
		System.out.println("costoDipendenti\tfatturatoPeriodoDiImposta\tnumeroDipendenti" + 
				"\tcostiAttivitaRd\tcostiPersonale\tpartitaIva\tidProgetto\tidDossier" + 
				"\tperiodoDiImposta");
		System.out.print("------------------------------------------------------");
		List<Dossier> progetti = dossierController.getAllDossier();
		System.out.println();
		progetti.forEach(dossier -> System.out.println(dossier.toString()));
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Dossier", "doControl", this.request);
	}

	

}
