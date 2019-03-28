package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.ProgettoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ProgettoService;

/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come
 * struttura e va modificata in modo opportuno
 *
 */
public class ProgettoServlet extends HttpServlet {

	private final ProgettoService progettoService = new ProgettoService();
	private List<ProgettoDTO> allProgetto = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final int idUtenteFinale = Integer.parseInt(request.getParameter("id"));
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "ProgettoManager":
			allProgetto = this.progettoService.getAllProgetto(idUtenteFinale);
			request.setAttribute("allProgetto", allProgetto);
			request.setAttribute("id", idUtenteFinale);
			getServletContext().getRequestDispatcher("/progetto/manageProgetto.jsp").forward(request, response);
			break;

		case "insertRedirect":
			request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
			getServletContext().getRequestDispatcher("/progetto/insertProgetto.jsp").forward(request, response);
			break;

		case "insert":

			final String nomeProgetto = request.getParameter("nomeProgetto");
			final Integer idUtenteFinale1 = Integer.parseInt(request.getParameter("id"));
			final ProgettoDTO progetto = new ProgettoDTO(nomeProgetto,idUtenteFinale1 );
			progettoService.insertProgetto(progetto);
			showAllProgetto(request, response);
			break;

		case "updateRedirect":
			int utenteFinale2 = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id",utenteFinale2);
			int id = Integer.parseInt(request.getParameter("updateId"));
			ProgettoDTO progettoUpdate = new ProgettoDTO("",utenteFinale2);
			progettoUpdate.setIdProgetto(id);

			progettoUpdate = this.progettoService.readProgetto(id);
			request.setAttribute("progettoUpdate", progettoUpdate);
			getServletContext().getRequestDispatcher("/progetto/updateProgetto.jsp").forward(request, response);

			break;

		case "update":
			// System.out.println("ID: " +
			// Integer.parseInt(request.getParameter("user_id")));
			// System.out.println("username: " + request.getParameter("user_user"));
			// System.out.println("password: " + request.getParameter("user_pass"));
			// System.out.println("Tipo utente: " + request.getParameter("user_type"));

			final Integer idprogettoUpdate = Integer.parseInt(request.getParameter("idProgetto"));
			final String nomeprogettoUpdate = request.getParameter("nomeProgetto");
		    final Integer idutentefinaleUpdate = Integer.parseInt(request.getParameter("id"));

			final ProgettoDTO progettoUp = new ProgettoDTO(nomeprogettoUpdate, idutentefinaleUpdate);
			progettoUp.setIdProgetto(idprogettoUpdate);
			progettoService.updateProgetto(progettoUp);
			showAllProgetto(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("deleteId"));
			progettoService.deleteProgetto(deleteId);
			showAllProgetto(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllProgetto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final int idUtenteFinale = Integer.parseInt(request.getParameter("id"));
		allProgetto = this.progettoService.getAllProgetto(idUtenteFinale);
		request.setAttribute("allProgetto", allProgetto);
		request.setAttribute("id", idUtenteFinale);
		getServletContext().getRequestDispatcher("/progetto/manageProgetto.jsp").forward(request, response);
	}
}