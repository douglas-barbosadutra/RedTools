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
			request.setAttribute("allUtenteFinale", prepareDTO(allUtenteFinale));
			getServletContext().getRequestDispatcher("/utenteFinale/manageUtenteFinale.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("utenteFinale/insertUtenteFinale.jsp");
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
					partitaIva, telefono, email, indirizzoUnitaLocale, attivitaAzienda, legaleRappresentante, natoA, natoIl);
			utenteFinale.setIdUtente(idUtente);
			
			utenteFinaleServiceDTO.insertUtenteFinale(utenteFinale);
			showAllUtenteFinale(request, response);
			break;

		case "updateRedirect":
			
			int id = Integer.parseInt(request.getParameter("id"));
			UtenteFinaleDTO utenteFinaleUpdate = new UtenteFinaleDTO("","","","","","","","","","","");
			utenteFinaleUpdate.setIdUtente(id);

			utenteFinaleUpdate = this.utenteFinaleServiceDTO.readUtenteFinale(id);
			request.setAttribute("utenteFinaleUpdate", utenteFinaleUpdate);
			getServletContext().getRequestDispatcher("/utenteFinale/updateUtenteFinale.jsp").forward(request, response);

			break;
			
			
		case "progetto":
			int id1 = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("idUtenteFinale", id1);
			getServletContext().getRequestDispatcher("/progetto/manageProgetto.jsp").forward(request, response);

			break;
			
		case "dossier":
			int id2 = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("idUtenteFinale", id2);
			getServletContext().getRequestDispatcher("/progetto/manageProgetto.jsp").forward(request, response);

			break;
			
		case "mom":
			int id3 = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("idUtenteFinale", id3);
			getServletContext().getRequestDispatcher("/progetto/manageProgetto.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));
			//System.out.println("username: " + request.getParameter("user_user"));
			//System.out.println("password: " + request.getParameter("user_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("user_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
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
								  emailUpdate,indirizzoUnitaLocaleUpdate,attivitaAziendaUpdate,legaleRappresentanteUpdate,natoAUpdate,natoIlUpdate );
			utenteFinale1.setIdUtente(idUtenteUpdate);
			utenteFinale1.setId(idUpdate);
			
			
			utenteFinaleServiceDTO.updateUtenteFinale(utenteFinale1);
			showAllUtenteFinale(request, response);
			break;

		case "delete":
			final int deleteId =Integer.parseInt( request.getParameter("id"));
			final UtenteFinaleDTO utenteFinaledelete = new  UtenteFinaleDTO("", "", "", "", "", "", "", "", "", "", "");
			utenteFinaledelete.setId(deleteId);
			utenteFinaleServiceDTO.deleteUtenteFinale(deleteId);
			showAllUtenteFinale(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllUtenteFinale(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allUtenteFinale = this.utenteFinaleServiceDTO.getAllUtenteFinale();
		request.setAttribute("allUtenteFinale", prepareDTO(allUtenteFinale));
		getServletContext().getRequestDispatcher("/utenteFinale/manageUtenteFinale.jsp").forward(request, response);
	}
	
	
	private List<UtenteFinaleDTO> prepareDTO(List<UtenteFinaleDTO> allUtenteFInale) {
		List<UtenteFinaleDTO> retAllUtenteFinale = new ArrayList<UtenteFinaleDTO>();
		
		for(UtenteFinaleDTO utenteFinale : allUtenteFInale) {
			int i = 1;
			
			if(utenteFinale.getFormaGiuridica() != null && !utenteFinale.getFormaGiuridica().equals(""))
				i++;
			if(utenteFinale.getSedeLegale() != null && !utenteFinale.getSedeLegale().equals(""))
				i++;
			if(utenteFinale.getPartitaIva() != null && !utenteFinale.getPartitaIva().equals(""))
				i++;
			if(utenteFinale.getTelefono() != null && !utenteFinale.getTelefono().equals(""))
				i++;
			if(utenteFinale.getEmail() != null && !utenteFinale.getEmail().equals(""))
				i++;
			if(utenteFinale.getIndirizzoUnitaLocale() != null && !utenteFinale.getIndirizzoUnitaLocale().equals(""))
				i++;
			if(utenteFinale.getAttivitaAzienda() != null && !utenteFinale.getAttivitaAzienda().equals(""))
				i++;
			if(utenteFinale.getLegaleRappresentante() != null && !utenteFinale.getLegaleRappresentante().equals(""))
				i++;
			if(utenteFinale.getNatoA() != null && !utenteFinale.getNatoA().equals(""))
				i++;
			if(utenteFinale.getNatoIl() != null && !utenteFinale.getNatoIl().equals(""))
				i++;
			UtenteFinaleDTO uf = new UtenteFinaleDTO();
			uf = utenteFinale;
			uf.setFilledFields(i);
			retAllUtenteFinale.add(uf);
			
		}
		
		return retAllUtenteFinale;
		
	}
	
	
}