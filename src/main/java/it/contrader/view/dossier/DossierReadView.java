package it.contrader.view.dossier;

import java.util.Scanner;

import it.contrader.controller.DossierController;
import it.contrader.controller.Request;
import it.contrader.dto.DossierDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DossierReadView  implements View {
	
	
	
	private DossierController dossierController;
	private Request request;

	public DossierReadView() {
		this.dossierController = new DossierController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int iddossierToRead;

		System.out.println("Inserisci l'ID del dossier:");

		try {
			iddossierToRead = Integer.parseInt(getInput());
			DossierDTO dossierDB = dossierController.readDossier(iddossierToRead);

			System.out.println("costo dipendenti: " + dossierDB.getCostoDipendenti());
			System.out.println("fatturato periodo di imposta: " + dossierDB.getFatturatoPeriodoDiImposta());
			System.out.println("numero dipendenti: " + dossierDB.getNumeroDipendenti());
			System.out.println("costi attivita : " + dossierDB.getCostiAttivitaRd());
			System.out.println("costi personale: " + dossierDB.getCostiPersonaleRd());
			System.out.println("partita iva: " + dossierDB.getPartitaIva());
			System.out.println("id progetto: " + dossierDB.getIdProgetto());
			System.out.println("Id dossier: " + dossierDB.getIdDossier());
			System.out.println("periodo di imposta: " + dossierDB.getPeriodoDiImposta());
			
			
			//Wait dossier to show
			System.out.println("Premi un tasto per continuare");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
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
