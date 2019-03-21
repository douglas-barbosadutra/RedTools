package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UtenteFinaleController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.UtenteFinale;

public class UtenteFinaleView implements View {

	private UtenteFinaleController utentiFinaliController;
	private Request request;
	private String choice;
	
	public UtenteFinaleView() {
		this.utentiFinaliController = new UtenteFinaleController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione utenti finali -------\n");
		
		System.out.println("DenominazioneSocieta\tFormaGiuridica\tSedeLegale\tPartitaIva"
				+ "Telefono\tEmail\tIndirizzoUnitaLocale\tAttivitaAzienda"
				+ "LegaleRappresentante\tNatoA\tNatoIl\tIdUtente");
		System.out.print("------------------------------------------------------");
		List<UtenteFinale> utentiFinali = utentiFinaliController.getAllUtenteFinale();
		System.out.println();
		utentiFinali.forEach(utenteFinale -> System.out.println(utenteFinale.toString()));
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
		    MainDispatcher.getInstance().callAction("UtenteFinale", "doControl", this.request);
	}

}
