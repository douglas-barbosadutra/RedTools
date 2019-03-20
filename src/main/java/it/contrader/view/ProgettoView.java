package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ProgettoController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Progetto;

public class ProgettoView implements View {

	private ProgettoController progettoController;
	private Request request;
	private String choice;
	
	public ProgettoView() {
		this.progettoController = new ProgettoController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione utenti -------\n");
		
		System.out.println("ID\tUsername\tTipoUtente");
		System.out.print("------------------------------------------------------");
		List<Progetto> progetto = progettoController.getAllProgetto();
		System.out.println();
		progetto.forEach(progetto -> System.out.println(progetto.toString()));
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
		    MainDispatcher.getInstance().callAction("Progetto", "doControl", this.request);
	}

}




