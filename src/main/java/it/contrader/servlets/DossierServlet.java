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
import it.contrader.service.DossierService;



public class DossierServlet extends HttpServlet {

	
	private final DossierService dossierService = new DossierService();
	private List<DossierDTO> allDossier = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String scelta = request.getParameter("richiesta");
		final int idUtenteFinale = Integer.parseInt(request.getParameter("id"));
		final HttpSession session = request.getSession(true);
		switch (scelta) {

		case "DossierManager":
			
			allDossier = this.dossierService.getAllDossier(idUtenteFinale);
			request.setAttribute("allDossier", allDossier);
			request.setAttribute("id", idUtenteFinale);
			getServletContext().getRequestDispatcher("/dossier/manageDossier.jsp").forward(request, response);
			break;

		case "insertRedirect":
			request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
			getServletContext().getRequestDispatcher("/dossier/insertDossier.jsp").forward(request, response);
			break;


		case "insert":
			
			final Integer idUtentefinale = Integer.parseInt(request.getParameter("id"));
			final int costoDipendenti = Integer.parseInt(request.getParameter("costoDipendenti"));
			final double fatturatoPeriodoDiImposta = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
			final int numeroDipendenti = Integer.parseInt(request.getParameter("numeroDipendenti"));
			final double costiAttivitaRd = Double.parseDouble(request.getParameter("costiAttivitaRd"));
			final double costiPersonaleRd = Double.parseDouble (request.getParameter("costiPersonaleRd"));
			final int idProgetto1 = Integer.parseInt(request.getParameter("idProgetto"));
			final int idDossier = Integer.parseInt(request.getParameter("idDossier"));
			final String periodoDiImposta = request.getParameter("periodoDiImposta");
			
			final DossierDTO dossier = new DossierDTO(costoDipendenti, fatturatoPeriodoDiImposta,
					numeroDipendenti, costiAttivitaRd, costiPersonaleRd, idUtentefinale,
					idProgetto1, idDossier, periodoDiImposta);
					
			dossierService.insertDossier(dossier);
			showAllDossier(request, response);
			break;

		case "updateRedirect":
			int utenteFinale2 = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id",utenteFinale2);
			int idDossier1 = Integer.parseInt(request.getParameter("updateId"));
			int idProgetto2 = Integer.parseInt(request.getParameter("idProgetto"));
			DossierDTO updateDossier = new DossierDTO(0, 0,
					0, 0, 0, utenteFinale2,
					idProgetto2, idDossier1, "");
			
			updateDossier = this.dossierService.readDossier(idDossier1);
			request.setAttribute("updateDossier", updateDossier);
			getServletContext().getRequestDispatcher("/dossier/updateDossier.jsp").forward(request, response);

			break;

		case "update":
			

			final Integer idUtentefinale2 = Integer.parseInt(request.getParameter("id"));
			final int costoDipendenti2 = Integer.parseInt(request.getParameter("costoDipendenti"));
			final double fatturatoPeriodoDiImposta2 = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
			final int numeroDipendenti2 = Integer.parseInt(request.getParameter("numeroDipendenti"));
			final double costiAttivitaRd2 = Double.parseDouble(request.getParameter("costiAttivitaRd"));
			final double costiPersonaleRd2 = Double.parseDouble (request.getParameter("costiPersonaleRd"));
			final int idProgetto3 = Integer.parseInt(request.getParameter("idProgetto"));
			final int idDossier2 = Integer.parseInt(request.getParameter("idDossier"));
			final String periodoDiImposta2 = request.getParameter("periodoDiImposta");
			final DossierDTO dossier2 = new DossierDTO(costoDipendenti2,
					fatturatoPeriodoDiImposta2, numeroDipendenti2, costiAttivitaRd2,
					costiPersonaleRd2, idUtentefinale2, idProgetto3, idDossier2, periodoDiImposta2);
			dossierService.updateDossier(dossier2);
			showAllDossier(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("deleteId"));
			dossierService.deleteDossier(deleteId);
			showAllDossier(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllDossier(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final int idUtenteFinale = Integer.parseInt(request.getParameter("id"));
		allDossier = this.dossierService.getAllDossier(idUtenteFinale);
		request.setAttribute("allDossier", allDossier);
		request.setAttribute("id", idUtenteFinale);
		getServletContext().getRequestDispatcher("/dossier/manageDossier.jsp").forward(request, response);
	}
}