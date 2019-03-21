package it.contrader.view.utenteFinale;

import java.util.Scanner;

import it.contrader.controller.UtenteFinaleController;
import it.contrader.controller.Request;
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UtenteFinaleReadView implements View {

	private UtenteFinaleController utenteFinaleController;
	private Request request;

	public UtenteFinaleReadView() {
		this.utenteFinaleController = new UtenteFinaleController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String partitaIvaToRead;

		System.out.println("Inserisci la Partita Iva:");

		try {
			partitaIvaToRead = getInput();
			UtenteFinaleDTO utenteFinaleDB = utenteFinaleController.readUtenteFinale(partitaIvaToRead);

			System.out.println("Partita Iva: " + utenteFinaleDB.getPartitaIva());
			System.out.println("Nome utente finale: " + utenteFinaleDB.getDenominazioneSocieta());
			
			
			//Wait utenteFinale to show
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
		MainDispatcher.getInstance().callAction("UtenteFinale", "doControl", request);
	}

}


