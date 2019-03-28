package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.dto.UtenteFinaleDTO;
import it.contrader.service.UserService;
import it.contrader.service.UtenteFinaleService;


public class UtenteFinaleServlet extends HttpServlet {

	private final UtenteFinaleService utenteFinaleServiceDTO = new UtenteFinaleService();
	private List<UtenteFinaleDTO> allUtenteFinale= new ArrayList<>();

	@Override
	public void service(HttpServletRequest request,   HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "UtenteFinaleManager":
			allUtenteFinale = this.utenteFinaleServiceDTO.getAllUtenteFinale();
			request.setAttribute("allUtenteFinale", allUtenteFinale);
			getServletContext().getRequestDispatcher("/utenteFinale/manageUtenteFinale.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("user/insertUser.jsp");
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("id"));
			final String denominazioneSocieta = request.getParameter("denominazione_societa");
			final String formaGiuridica = request.getParameter("forma_giuridica");
			final String sedeLegale = request.getParameter("sede_legale");
			final String partitaIva = request.getParameter("partita_iva");
			final String telefono = request.getParameter("telefono");
			final String email = request.getParameter("email");
			final String indirizzoUnitaLocale = request.getParameter("indirizzoUnitaLocale");
			final String attivitaAzienda = request.getParameter("attivita_azienda");
			final String legaleRappresentante = request.getParameter("legale_rappresentante");
			final String natoA = request.getParameter("nato_a");
			final String natoIl = request.getParameter("nato_il");
			final int idUtente =Integer.parseInt( request.getParameter("id_utente"));
			
			final UtenteFinaleDTO utenteFinale = new UtenteFinaleDTO(denominazioneSocieta, formaGiuridica, sedeLegale,
					partitaIva, telefono, email, indirizzoUnitaLocale, attivitaAzienda, legaleRappresentante, natoA, natoIl, idUtente);
			
			
			utenteFinaleServiceDTO.insertUtenteFinale(utenteFinale);
			showAllUtenteFinale(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			UtenteFinaleDTO utenteFinaleUpdate = new UtenteFinaleDTO("","","","","","","","","","","",0);
			utenteFinaleUpdate.setId(id);

			utenteFinaleUpdate = this.utenteFinaleServiceDTO.readUtenteFinale(id);
			request.setAttribute("utenteUpdate", utenteFinaleUpdate);
			getServletContext().getRequestDispatcher("/utenteFinale/updateUtenteFianle.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));
			//System.out.println("username: " + request.getParameter("user_user"));
			//System.out.println("password: " + request.getParameter("user_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("user_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
			final String denominazioneSocietaUpdate = request.getParameter("denominazione_societa");
			final String formaGiuridicaUpdate = request.getParameter("forma_giuridica");
			final String sedeLegaleUpdate = request.getParameter("sede_legale");
			final String partitaIvaUpdate = request.getParameter("partita_iva");
			final String telefonoUpdate = request.getParameter("telefono");
			final String emailUpdate = request.getParameter("email");
			final String indirizzoUnitaLocaleUpdate = request.getParameter("indirizzoUnitaLocale");
			final String attivitaAziendaUpdate = request.getParameter("attivita_azienda");
			final String legaleRappresentanteUpdate = request.getParameter("legale_rappresentante");
			final String natoAUpdate = request.getParameter("nato_a");
			final String natoIlUpdate = request.getParameter("nato_il");
			final int idUtenteUpdate =Integer.parseInt( request.getParameter("id_utente"));
			final UtenteFinaleDTO utenteFinale1 = new UtenteFinaleDTO(denominazioneSocietaUpdate,formaGiuridicaUpdate,sedeLegaleUpdate,partitaIvaUpdate,telefonoUpdate,
								  emailUpdate,indirizzoUnitaLocaleUpdate,attivitaAziendaUpdate,legaleRappresentanteUpdate,natoAUpdate,natoIlUpdate,idUtenteUpdate );
			
			
			utenteFinaleServiceDTO.updateUtenteFinale(utenteFinale1);
			showAllUtenteFinale(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final UtenteFinaleDTO utenteFinaledelete = new  UtenteFinaleDTO("", "", "", "", "", "", "", "", "", "", "", 0);
			utenteFinaledelete.setId(deleteId);
			utenteFinaleServiceDTO.deleteUtenteFinale(deleteId);
			showAllUtenteFinale(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllUtenteFinale(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allUtenteFinale = this.utenteFinaleServiceDTO.getAllUtenteFinale();
		request.setAttribute("allUser", allUtenteFinale);
		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
	}
}