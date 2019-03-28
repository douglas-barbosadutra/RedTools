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
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "ProgettoManager":
			allProgetto = this.progettoService.getAllProgetto();
			request.setAttribute("allProgetto", allProgetto);
			getServletContext().getRequestDispatcher("/progetto/manageProgetto.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("progetto/insertProgetto.jsp");
			break;

		case "insert":

			final Integer idprogetto = Integer.parseInt(request.getParameter("progetto_idprogetto"));
			final String nomeprogetto = request.getParameter("progetto_nome");
			final Integer idutentefinale = Integer.parseInt(request.getParameter("progetto_idutentefinale"));
			final ProgettoDTO progetto = new ProgettoDTO(idprogetto, nomeprogetto, idutentefinale);
			progettoService.insertProgetto(progetto);
			showAllProgetto(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			ProgettoDTO progettoUpdate = new ProgettoDTO(0, "", 0);
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

			final Integer idprogettoUpdate = Integer.parseInt(request.getParameter("progetto_idprogetto"));
			final String nomeprogettoUpdate = request.getParameter("progetto_nome");
		    final Integer idutentefinaleUpdate = Integer.parseInt(request.getParameter("progetto_idutentefinale"));

			final ProgettoDTO progettoUp = new ProgettoDTO(idprogettoUpdate, nomeprogettoUpdate, idutentefinaleUpdate);
			progettoUp.setIdProgetto(idprogettoUpdate);

			progettoService.updateProgetto(progettoUp);
			showAllProgetto(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("progetto_idprogetto"));

			final ProgettoDTO progettodelete = new ProgettoDTO(0, "", 0);
			progettodelete.setIdProgetto(deleteId);
			progettoService.deleteProgetto(deleteId);
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

	private void showAllProgetto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allProgetto = this.progettoService.getAllProgetto();
		request.setAttribute("allProgetto", allProgetto);
		getServletContext().getRequestDispatcher("/progetto/manageProgetto.jsp").forward(request, response);
	}
}