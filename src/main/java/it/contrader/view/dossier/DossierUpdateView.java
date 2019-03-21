package it.contrader.view.dossier;

import java.util.Scanner;

import it.contrader.controller.DossierController;
import it.contrader.controller.Request;
import it.contrader.dto.DossierDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DossierUpdateView implements View {
	

	
	private DossierController dossierController;
	private Request request;

	public DossierUpdateView() {
		this.dossierController = new DossierController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int costoDipendenti;
		double fatturatoPeriodoDiImposta;
		int numeroDipendenti;
		double costiAttivitaRd;
		double costiPersonaleRd;
		String partitaIva;
		int idProgetto;
		int idDossierToUpdate;
		String periodoDiImposta;

		/*
		 * List<Dossier> dossier; Integer iddossier; dossier = dossierController.getAllDossier();
		 * 
		 */
		System.out.println("\n----- Seleziona il dossier da modificare  -----\n");
		// System.out.println();
		// dossier.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		DossierDTO dossierDTO = new DossierDTO();

		System.out.println("Digita costo dipendenti");
		try {
			idDossierToUpdate = Integer.parseInt(getInput());
			if (idDossierToUpdate != 0) {
				dossierDTO.setIdDossier(idDossierToUpdate);

				System.out.println("costo dipendenti:");
				costoDipendenti = Integer.parseInt(getInput());
				if (costoDipendenti != 0)
					dossierDTO.setCostoDipendenti(costoDipendenti);
				
				System.out.println("fatturato :");
				fatturatoPeriodoDiImposta = Integer.parseInt(getInput());
				if (costoDipendenti != 0)
					dossierDTO.setFatturatoPeriodoDiImposta(fatturatoPeriodoDiImposta);
				
				System.out.println("numero dipendenti :");
				numeroDipendenti = Integer.parseInt(getInput());
				if (costoDipendenti != 0)
					dossierDTO.setNumeroDipendenti(numeroDipendenti);
				
				System.out.println("costi attivita :");
				costiAttivitaRd = Integer.parseInt(getInput());
				if (costoDipendenti != 0)
					dossierDTO.setCostiAttivitaRd(costiAttivitaRd);
				
				System.out.println("costi personale :");
				costiPersonaleRd = Integer.parseInt(getInput());
				if (costoDipendenti != 0)
					dossierDTO.setCostiPersonaleRd(costiPersonaleRd);
				
				System.out.println("partita iva:");
				partitaIva = getInput();
				if (!partitaIva.equals(""))
					dossierDTO.setPartitaIva(partitaIva);
				
				System.out.println("id progetto:");
				idProgetto = Integer.parseInt(getInput());
				if (idProgetto != 0)
					dossierDTO.setIdProgetto(idProgetto);
				
				
				System.out.println("periodo di imposta:");
				periodoDiImposta = getInput();
				if (!periodoDiImposta.equals(""))
					dossierDTO.setPeriodoDiImposta(periodoDiImposta);

				dossierController.updateDossier(dossierDTO);
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
		MainDispatcher.getInstance().callAction("Dossier", "doControl", request);
	}

}


