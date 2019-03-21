package it.contrader.view.utenteFinale;

import java.util.Scanner;

import it.contrader.controller.UtenteFinaleController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UtenteFinaleUpdateView implements View {

	private UtenteFinaleController utenteFinaleController;
	private Request request;

	public UtenteFinaleUpdateView() {
		this.utenteFinaleController = new UtenteFinaleController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String partitaIvaToUpdate;
		String denominazioneSocieta;
		String formaGiuridica;
		String sedeLegale;
		String telefono;
		String email;
		String indirizzoUnitaLocale;
		String attivitaAzienda;
		String legaleRappresentante;
		String natoA;
		String natoIl;
		int idUtente;

		/*
		 * List<UtenteFinale> utenteFinale; Integer idutenteFinale; utenteFinale = utenteFinaleController.getAllUtenteFinale();
		 * 
		 */
		System.out.println("\n----- Seleziona l'utente finale da modificare  -----\n");
		// System.out.println();
		// utenteFinale.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		UtenteFinaleDTO utenteFinaleDTO = new UtenteFinaleDTO();

		System.out.println("Digita la Partita Iva dell'utente da modificare:");
		try {
			partitaIvaToUpdate = getInput();
			if (!partitaIvaToUpdate.equals("")) {
				utenteFinaleDTO.setPartitaIva(partitaIvaToUpdate);

				System.out.println("Digita la denominazione della società: ");
				denominazioneSocieta = getInput();
				if (!denominazioneSocieta.equals(""))
					utenteFinaleDTO.setDenominazioneSocieta(denominazioneSocieta);
				System.out.println("Digita la forma giuridica: ");
				formaGiuridica = getInput();
				if (!formaGiuridica.equals(""))
					utenteFinaleDTO.setFormaGiuridica(formaGiuridica);
				System.out.println("Digita la sede legale: ");
				sedeLegale = getInput();
				if (!sedeLegale.equals(""))
					utenteFinaleDTO.setSedeLegale(sedeLegale);
				System.out.println("Digita il numero di telefono: ");
				telefono = getInput();
				if (!telefono.equals(""))
					utenteFinaleDTO.setTelefono(telefono);
				System.out.println("Digita l'email: ");
				email = getInput();
				if (!email.equals(""))
					utenteFinaleDTO.setEmail(email);
				System.out.println("Digita l'indirizzo dell'unità locale: ");
				indirizzoUnitaLocale = getInput();
				if (!indirizzoUnitaLocale.equals(""))
					utenteFinaleDTO.setIndirizzoUnitaLocale(indirizzoUnitaLocale);
				System.out.println("Digita il tipo di attività dell'azienda: ");
				attivitaAzienda = getInput();
				if (!attivitaAzienda.equals(""))
					utenteFinaleDTO.setAttivitaAzienda(attivitaAzienda);
				System.out.println("Digita il nome del rappresentante legale: ");
				legaleRappresentante = getInput();
				if (!legaleRappresentante.equals(""))
					utenteFinaleDTO.setLegaleRappresentante(legaleRappresentante);
				System.out.println("Digita il luogo di nascita: ");
				natoA = getInput();
				if (!natoA.equals(""))
					utenteFinaleDTO.setNatoA(natoA);
				System.out.println("Digita la data di nascita: ");
				natoIl = getInput();
				if (!natoIl.equals(""))
					utenteFinaleDTO.setNatoIl(natoIl);
				System.out.println("Digita l'id utente: ");
				idUtente = Integer.parseInt(getInput());
				if (idUtente != 0)
					utenteFinaleDTO.setIdUtente(idUtente);

				utenteFinaleController.updateUtenteFinale(utenteFinaleDTO);

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
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


