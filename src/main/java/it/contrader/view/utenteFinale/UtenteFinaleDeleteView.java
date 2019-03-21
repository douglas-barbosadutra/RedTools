package it.contrader.view.utenteFinale;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.UtenteFinaleController;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UtenteFinaleDeleteView implements View {
	
		private UtenteFinaleController utenteFinaleController;
		private Request request;

		public UtenteFinaleDeleteView() {
			this.utenteFinaleController = new UtenteFinaleController();
		}

		@Override
		public void showResults(Request request) {
		}

		@Override
		public void showOptions() {
			//List<UtenteFinale> utenteFinale;
			//String idutenteFinale;

			//utenteFinale = utenteFinaleController.getAllUtenteFinale();
			System.out.println("Seleziona l'utente finale da cancellare : ");
			//System.out.println();
			//utenteFinale.forEach(utenteFinale -> System.out.println(utenteFinale));
			//System.out.println();
			//System.out.println("Digita l'ID UtenteFinale:");
			String partitaIva = getInput();

			if (partitaIva != null && StringUtils.isStrictlyNumeric(partitaIva)) {
				utenteFinaleController.deleteUtenteFinale(partitaIva);
				
			} else {
				System.out.println("Valore inserito errato");
			}
		}

		@Override
		public String getInput() {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextLine();
		}

		@Override
		public void submit() {
			request = new Request();
			request.put("mode", "menu");
			request.put("choice", "");
			MainDispatcher.getInstance().callAction("UtenteFinale", "doControl", request);
		}

	}


