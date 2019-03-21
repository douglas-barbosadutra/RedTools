package it.contrader.view.utenteFinale;

import java.util.Scanner;

import it.contrader.controller.ProgettoController;
import it.contrader.controller.Request;
import it.contrader.controller.UtenteFinaleController;
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UtenteFinaleInsertView implements View {

	private UtenteFinaleController utenteFinaleController;
	private Request request;

	public UtenteFinaleInsertView() {
		this.utenteFinaleController = new UtenteFinaleController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String denominazioneSocieta;
		String formaGiuridica;
		String sedeLegale;
		String partitaIva;
		String telefono;
		String email;
		String indirizzoUnitaLocale;
		String attivitaAzienda;
		String legaleRappresentante;
		String natoA;
		String natoIl;
		int idUtente;
     
		System.out.println("Inserisci i campi dell' utente finale:");
		
		System.out.println("Digita la denominazione della società: ");
		denominazioneSocieta = getInput();
		System.out.println("Digita la forma giuridica: ");
		formaGiuridica = getInput();
		System.out.println("Digita la sede legale: ");
		sedeLegale = getInput();
		System.out.println("Digita la Partita Iva: ");
		partitaIva = getInput();
		System.out.println("Digita il numero di telefono: ");
		telefono = getInput();
		System.out.println("Digita l'email: ");
		email = getInput();
		System.out.println("Digita l'indirizzo dell'unità locale: ");
		indirizzoUnitaLocale = getInput();
		System.out.println("Digita il tipo di attività dell'azienda: ");
		attivitaAzienda = getInput();
		System.out.println("Digita il nome del rappresentante legale: ");
		legaleRappresentante = getInput();
		System.out.println("Digita il luogo di nascita: ");
		natoA = getInput();
		System.out.println("Digita la data di nascita: ");
		natoIl = getInput();
		System.out.println("Digita l'id utente: ");
		idUtente = Integer.parseInt(getInput());
		
		
		if (!denominazioneSocieta.equals("") ) {
			utenteFinaleController.insertUtenteFinale(new UtenteFinaleDTO(denominazioneSocieta, formaGiuridica,
					sedeLegale, telefono, email, indirizzoUnitaLocale, attivitaAzienda, legaleRappresentante,
					natoA, natoIl, idUtente));
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
		MainDispatcher.getInstance().callAction("Progetto", "doControl", request);
	}

}


