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
import it.contrader.dto.UserDTO;
import it.contrader.service.MomService;
import it.contrader.service.UserService;



public class MomServlet extends HttpServlet {
		
		
		private final MomService momService = new MomService();
		private List<MomDTO> allMom = new ArrayList<>();
		
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			final String scelta = request.getParameter("richiesta");
			final HttpSession session = request.getSession(true);
			switch (scelta) {
			
			case "MomManager":
				
				allMom = this.momService.getAllMom();
				request.setAttribute("allMom", allMom);
				getServletContext().getRequestDispatcher("/mom/manageMom.jsp").forward(request, response);
				break;
				
			case "insertRedirect":
				response.sendRedirect("mom/insertMom.jsp");
				break;
				
			case "insert":
				
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
				final String chiave_est_ut_fin = request.getParameter("chiave_est_ut_fin");
				
				final MomDTO mom = new MomDTO(nome_utente_finale_mom, luogo_mom, data_del_giorno_mom, orario_mom, oggetto_mom, progetto_mom, partecipanti_mom, testo_agenda_mom, testo_azione_mom, testo_note_mom, chiave_est_ut_fin);
				momService.insertMom(mom);
				showAllMom(request, response);
				break;
				
			case "updateRedirect":
				int id = Integer.parseInt(request.getParameter("id_mom"));
				MomDTO momUpdate = new MomDTO("", "", "","", "", "","", "", "","", "");
				momUpdate.setId_mom(id);

				momUpdate = this.momService.readMom(id);
				request.setAttribute("momUpdate", momUpdate);
				getServletContext().getRequestDispatcher("/mom/updateMom.jsp").forward(request, response);

				break;
				
				
			case "delete":
				final Integer deleteId = Integer.parseInt(request.getParameter("id"));
				final MomDTO momdelete = new MomDTO("", "", "", "", "", "", "", "", "", "", "");
				momdelete.setId_mom(deleteId);
				momService.deleteMom(deleteId);
				showAllMom(request, response);
				break;
				
			case "indietro":
				response.sendRedirect("homeBO.jsp");
				break;

			case "logsMenu":
				response.sendRedirect("index.jsp");
				break;
			}
		
		
		}
		
		
	
	private void showAllMom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allMom = this.momService.getAllMom();
		request.setAttribute("allMom", allMom);
		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
	}
}














