package it.contrader.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.MomDTO;
import it.contrader.dto.ProgettoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.MomService;
import it.contrader.service.UserService;



public class MomServlet extends HttpServlet {
		
		
		private final MomService momService = new MomService();
		private List<MomDTO> allMom = new ArrayList<>();
		
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			final String scelta = request.getParameter("richiesta");
			final int idUtenteFinale = Integer.parseInt(request.getParameter("id"));
			final int idBO = Integer.parseInt(request.getParameter("idBO"));
			final HttpSession session = request.getSession(true);
			switch (scelta) {
			
			case "MomManager":
				
				request.setAttribute("idBO", idBO);
				
				allMom = this.momService.getAllMom(idUtenteFinale);
				request.setAttribute("allMom", allMom);
				request.setAttribute("id", idUtenteFinale);
				getServletContext().getRequestDispatcher("/mom/manageMom.jsp").forward(request, response);
				break;
				
			case "insertRedirect":
				request.setAttribute("idBO", idBO);
				request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
				getServletContext().getRequestDispatcher("/mom/insertMom.jsp").forward(request, response);
				break;
				
			case "insert":
				request.setAttribute("idBO", idBO);
				final String nome_utente_finale_mom = request.getParameter("nome_utente_finale_mom");
				final String luogo_mom = request.getParameter("luogo_mom");
				final String data_del_giorno_mom = request.getParameter("data_del_giorno_mom");
				final String orario_mom = request.getParameter("orario_mom");
				final String oggetto_mom = request.getParameter("oggetto_mom");
				final String progetto_mom = request.getParameter("progetto_mom");
				final String partecipanti_mom = request.getParameter("partecipanti_mom");
				final String testo_agenda_mom = request.getParameter("testo_agenda_mom");
				final String testo_azione_mom = request.getParameter("testo_azione_mom");
				final String testo_note_mom = request.getParameter("testo_note_mom");
				final int chiave_est_ut_fin = Integer.parseInt(request.getParameter("id"));
				
				final MomDTO mom = new MomDTO(nome_utente_finale_mom, luogo_mom, data_del_giorno_mom, orario_mom, oggetto_mom, progetto_mom, partecipanti_mom, testo_agenda_mom, testo_azione_mom, testo_note_mom, chiave_est_ut_fin);
				momService.insertMom(mom);
				showAllMom(request, response);
				break;
				
			case "updateRedirect":
				request.setAttribute("idBO", idBO);
				int utenteFinale2 = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("id",utenteFinale2);
				int id = Integer.parseInt(request.getParameter("updateId"));
				MomDTO momUpdate = new MomDTO("", "", "","", "", "","", "", "","",utenteFinale2);
				momUpdate.setId_mom(id);

				momUpdate = this.momService.readMom(id);
				request.setAttribute("momUpdate", momUpdate);
				getServletContext().getRequestDispatcher("/mom/updateMom.jsp").forward(request, response);

				break;
				
			case "update":
				request.setAttribute("idBO", idBO);
				// System.out.println("ID: " +
				// Integer.parseInt(request.getParameter("user_id")));
				// System.out.println("username: " + request.getParameter("user_user"));
				// System.out.println("password: " + request.getParameter("user_pass"));
				// System.out.println("Tipo utente: " + request.getParameter("user_type"));
			    
			    final String nome_utente_finale_mom1 = request.getParameter("nome_utente_finale_mom");
				final String luogo_mom1 = request.getParameter("luogo_mom");
				final String data_del_giorno_mom1 = request.getParameter("data_del_giorno_mom");
				final String orario_mom1 = request.getParameter("orario_mom");
				final String oggetto_mom1 = request.getParameter("oggetto_mom");
				final String progetto_mom1 = request.getParameter("progetto_mom");
				final String partecipanti_mom1 = request.getParameter("partecipanti_mom");
				final String testo_agenda_mom1 = request.getParameter("testo_agenda_mom");
				final String testo_azione_mom1 = request.getParameter("testo_azione_mom");
				final String testo_note_mom1 = request.getParameter("testo_note_mom");
				final int chiave_est_ut_fin1 = Integer.parseInt(request.getParameter("id"));
				final int idMom1 = Integer.parseInt(request.getParameter("idMom"));

				final MomDTO momUp = new MomDTO(nome_utente_finale_mom1, luogo_mom1, data_del_giorno_mom1, orario_mom1, oggetto_mom1, progetto_mom1, partecipanti_mom1, testo_agenda_mom1, testo_azione_mom1, testo_note_mom1, chiave_est_ut_fin1);
				momUp.setId_mom(idMom1);
				momUp.setChiave_est_ut_fin(chiave_est_ut_fin1);
				momService.updateMom(momUp);
				showAllMom(request, response);
				break;
				
			case "delete":
				request.setAttribute("idBO", idBO);
				final Integer deleteId = Integer.parseInt(request.getParameter("deleteId"));
				momService.deleteMom(deleteId);
				showAllMom(request, response);
				break;
				
			case "indietro":
				request.setAttribute("idBO", idBO);
				getServletContext().getRequestDispatcher("homeBO.jsp").forward(request, response);
				break;

			case "logsMenu":
				response.sendRedirect("index.jsp");
				break;
			}
		
		
		}
		
		
	
	private void showAllMom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final int idBO = Integer.parseInt(request.getParameter("idBO"));
		final int idUtenteFinale = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("idBO", idBO);
		allMom = this.momService.getAllMom(idUtenteFinale);
		request.setAttribute("allMom", allMom);
		request.setAttribute("id", idUtenteFinale);
		getServletContext().getRequestDispatcher("/mom/manageMom.jsp").forward(request, response);
	}
}














