package it.contrader.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.DossierDTO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.service.DossierService;



public class DossierServlet extends HttpServlet {

	private final DossierService DossierService = new DossierService();
	private List<DossierDTO> allDossier = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		final int idUtenteFinale = Integer.parseInt(request.getParameter("id"));
		final int idProgetto = Integer.parseInt(request.getParameter("id"));
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "DossierManager":
			allDossier = this.DossierService.getAllDossier(idUtenteFinale);
			allDossier = this.DossierService.getAllDossier(idProgetto);
			request.setAttribute("allDossier", allDossier);
			request.setAttribute("id", idUtenteFinale);
			request.setAttribute("id", idProgetto);

			getServletContext().getRequestDispatcher("/dossier/manageDossier.jsp").forward(request, response);
			break;

		case "insertRedirect":
			request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
			getServletContext().getRequestDispatcher("/dossier/insertDossier.jsp").forward(request, response);
			break;


		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			
			final int costoDipendenti = Integer.parseInt(request.getParameter("costoDipendenti"));
			final double fatturatoPeriodoDiImposta = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
			final int numeroDipendenti = Integer.parseInt(request.getParameter("numeroDipendenti"));
			final double costiAttivitaRd = Double.parseDouble(request.getParameter("costiAttivitaRd"));
			final double costiPersonaleRd = Double.parseDouble (request.getParameter("costiPersonaleRd"));
			final int idUtentefinale = Integer.parseInt(request.getParameter("idUtentefinale"));
			final int idProgetto1 = Integer.parseInt(request.getParameter("id"));
			final String periodoDiImposta = request.getParameter("periodoDiImposta");
			
			final DossierDTO dossier = new DossierDTO(costoDipendenti,fatturatoPeriodoDiImposta,numeroDipendenti,
					costiAttivitaRd, costiPersonaleRd, idUtentefinale, idProgetto1, idProgetto1, periodoDiImposta);

			
			
			
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("user_id"));
			DossierDTO updateDossier = new DossierDTO();
			updateDossier.setIdDossier(id);

			updateDossier = this.DossierService.readDossier(id);
			request.setAttribute("updateDossier", updateDossier);
			getServletContext().getRequestDispatcher("/dossier/updateDossier.jsp").forward(request, response);

			break;

		case "update":
			

			final int costoDipendentiUpdate = Integer.parseInt(request.getParameter("costoDipendenti"));
			final double fatturatoPeriodoDiImpostaUpdate = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
			final int numeroDipendentiUpdate = Integer.parseInt(request.getParameter("numeroDipendenti"));
			final double costiAttivitaRdUpdate = Double.parseDouble(request.getParameter("costiAttivitaRd"));
			final double costiPersonaleRdUpdate = Double.parseDouble (request.getParameter("costiPersonaleRd"));
			final int idUtentefinaleUpdate = Integer.parseInt(request.getParameter("idUtentefinale"));
			final int idProgettoUpdate = Integer.parseInt(request.getParameter("idProgetto"));
			final int idDossierUpdate = Integer.parseInt(request.getParameter("idDossier"));
			final String periodoDiImpostaUpdate = request.getParameter("periodoDiImposta");
			final DossierDTO dossier1 = new DossierDTO(costoDipendenti,fatturatoPeriodoDiImposta,numeroDipendenti,
					costiAttivitaRd, costiPersonaleRd, idUtentefinale, idProgetto1, idProgetto1, periodoDiImposta);
			dossier1.setIdProgetto(idProgettoUpdate);;
			dossier1.setIdDossier(idDossierUpdate);
			dossier1.setIdUtentefinale(idUtentefinaleUpdate);
			break;

		case "delete":
			
			final int deleteidDossier = Integer.parseInt(request.getParameter("idDossier"));

			final DossierDTO dossierdelete = new  DossierDTO("", "", "", "", "", "");
			dossier1.deleteDossier(dossierId);
			showAllProgetto(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllDossier(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allDossier = this.DossierServiceDTO.getAllDossier();
		request.setAttribute("allDossier", allDossier);
		getServletContext().getRequestDispatcher("/dossier/manageDossier.jsp").forward(request, response);
	}
}