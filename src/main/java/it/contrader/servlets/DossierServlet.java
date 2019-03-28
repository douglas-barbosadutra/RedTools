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
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.service.DossierService;



public class DossierServlet extends HttpServlet {

	private final DossierService DossierServiceDTO = new DossierService();
	private List<DossierDTO> allDossier = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "DossierManager":
			allDossier = this.DossierServiceDTO.getAllDossier();
			request.setAttribute("allDossier", allDossier);
			getServletContext().getRequestDispatcher("/dossier/manageDossier.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("dossier/insertDossier.jsp");
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			
			final int costoDipendenti = Integer.parseInt(request.getParameter("costoDipendenti"));
			final double fatturatoPeriodoDiImposta = Double.parseDouble(request.getParameter("fatturatoPeriodoDiImposta"));
			final int numeroDipendenti = Integer.parseInt(request.getParameter("numeroDipendenti"));
			final double costiAttivitaRd = Double.parseDouble(request.getParameter("costiAttivitaRd"));
			final double costiPersonaleRd = Double.parseDouble (request.getParameter("costiPersonaleRd"));
			final int idUtentefinale = Integer.parseInt(request.getParameter("idUtentefinale"));
			final int idProgetto = Integer.parseInt(request.getParameter("idProgetto"));
			final int idDossier = Integer.parseInt(request.getParameter("idDossier"));
			final String periodoDiImposta = request.getParameter("periodoDiImposta");
			final DossierDTO dossier = new DossierDTO(0, 0, numeroDipendenti,
					costiAttivitaRd, costiPersonaleRd, 0, 0, 0, periodoDiImposta);
			DossierServiceDTO.insertDossier(dossier);
			showAllDossier(request, response);
			break;

		case "updateRedirect":
			int idDossier1 = Integer.parseInt(request.getParameter("idDossier"));
			DossierDTO updateDossier = new DossierDTO();
			updateDossier.setIdDossier(idDossier1);

			updateDossier = this.DossierServiceDTO.readDossier(idDossier1);
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
			final DossierDTO dossier1 = new DossierDTO(0, 0, numeroDipendentiUpdate,
					costiAttivitaRdUpdate, costiPersonaleRdUpdate, 0, 0, 0, periodoDiImpostaUpdate);
			DossierServiceDTO.insertDossier(dossier1);
			showAllDossier(request, response);

			DossierServiceDTO.updateDossier(dossier1);
			showAllDossier(request, response);
			break;

		case "delete":
			final Integer deleteidDossier = Integer.parseInt(request.getParameter("idDossier"));

			final DossierDTO Dossierdelete = new  DossierDTO(0,0,0,0,0,0,0,0,"");
			Dossierdelete.setIdDossier(deleteidDossier);
			DossierServiceDTO.deleteDossier(deleteidDossier);
			showAllDossier(request, response);
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