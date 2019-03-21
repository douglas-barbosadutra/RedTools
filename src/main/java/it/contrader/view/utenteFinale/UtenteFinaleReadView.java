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
			System.out.println("Forma giuridica: " + utenteFinaleDB.getFormaGiuridica());
			System.out.println("Sede legale: " + utenteFinaleDB.getSedeLegale());
			System.out.println("Telefono: " + utenteFinaleDB.getTelefono());
			System.out.println("Email: " + utenteFinaleDB.getEmail());
			System.out.println("Indirizzo unità locale: " + utenteFinaleDB.getIndirizzoUnitaLocale());
			System.out.println("Attività azienda: " + utenteFinaleDB.getAttivitaAzienda());
			System.out.println("Legale rappresentante: " + utenteFinaleDB.getLegaleRappresentante());
			System.out.println("Nato a: " + utenteFinaleDB.getNatoA());
			System.out.println("Nato il: " + utenteFinaleDB.getNatoIl());
			System.out.println("Id utente: " + utenteFinaleDB.getIdUtente());
			
			
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


