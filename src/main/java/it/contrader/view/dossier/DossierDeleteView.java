package it.contrader.view.dossier;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.DossierController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DossierDeleteView implements View {
	
	
	
	private DossierController dossierController;
	private Request request;

	public DossierDeleteView() {
		this.dossierController = new DossierController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<Dossier> dossier;
		//String iddossier;

		//dossier = dossierController.getAllDossier();
		System.out.println("Seleziona l'ID del dossier da cancellare : ");
		//System.out.println();
		//dossier.forEach(dossier -> System.out.println(dossier));
		//System.out.println();
		//System.out.println("Digita l'ID Dossier:");
		String iddossier = getInput();

		if (iddossier != null && StringUtils.isStrictlyNumeric(iddossier)) {
			dossierController.deleteDossier(Integer.parseInt(iddossier));
			
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
		MainDispatcher.getInstance().callAction("Dossier", "doControl", request);
	}
	

}
