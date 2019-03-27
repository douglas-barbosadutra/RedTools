package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

public class LoginServlet extends HttpServlet {

	private final UserService usersServiceDTO = new UserService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			final String nomeUtente = request.getParameter("username").toString().trim();
			final String password = request.getParameter("password").toString().trim();
			// recuperiamo l'utente
			final UserDTO userDTO = usersServiceDTO.getUserByUsernameAndPasword(nomeUtente, password);

			if (userDTO != null)
				session.setAttribute("utente", userDTO);

			// verifichiamo che tipo di ruolo ha all'interno dell'applicazione
			// e lo reindirizziamo nella jsp opportuna
			switch (userDTO.getUsertype().toLowerCase()) {
			case "superuser":
				getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
				break;
			case "user":
				getServletContext().getRequestDispatcher("/homeBO.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}

}
