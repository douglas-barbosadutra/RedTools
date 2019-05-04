package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DossierDTO;
import it.contrader.services.DossierService;
import it.contrader.services.ProgettoService;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 

@CrossOrigin
@RestController
@RequestMapping("/DossierController")

public class DossierController {

    private final DossierService dossierService;
    private final ProgettoService progettoService;
	
	@Autowired
	public DossierController(DossierService dossierService, ProgettoService progettoService) {
		this.dossierService = dossierService;
		this.progettoService = progettoService;
	}

	@RequestMapping(value = "/dossierManagement", method = RequestMethod.GET)
	public List<DossierDTO> dossierManagement(@RequestParam(value = "progettoId") int progettoId) {
		List<DossierDTO> listaDossier = completamentoDTO(this.dossierService.findDossierDTOByProgetto(progettoService.findProgettoDTOById(progettoId)));
		return listaDossier;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody DossierDTO dossier) {
		dossierService.insertDossier(dossier);
		calculatePercentageAndSend(dossier);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public DossierDTO read(@RequestParam(value = "id") int id) {
		return this.dossierService.getDossierDTOById(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody DossierDTO dossier) {
		dossierService.updateDossier(dossier);
		calculatePercentageAndSend(dossier);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "id") int id) {
		this.dossierService.deleteDossierById(id);
	}
	
	private List<DossierDTO> completamentoDTO(List<DossierDTO> allDossier) {
		List<DossierDTO> retAllDossier = new ArrayList<DossierDTO>();
		
		
		for(DossierDTO dossier : allDossier) {
			int y=2;
			if((dossier.getPeriodoDiImposta() != null && dossier.getPeriodoDiImposta().equals("")));
				y++;
			if((dossier.getCostoDipendentiPeriodoDiImposta() !=0))
				y++;
			if(dossier.getFatturatoPeriodoDiImposta() !=0)
				y++;
			if(dossier.getNumeroTotaleDipendenti() !=0)
				y++;
			DossierDTO d = new DossierDTO();
			d = dossier;
			d.setFilledFields(y);
			retAllDossier.add(d);
			
			
		}
		return retAllDossier;
	
	}

	private void calculatePercentageAndSend(DossierDTO dossier) {
		float soglia = dossier.getProgettoDTO().getAziendaClienteDTO().getSoglia();
		float filledFieldsAziendaCliente = (float) dossier.getProgettoDTO().getAziendaClienteDTO().getFilledFields();
		float filledFieldsDossier = (float) dossier.getFilledFields();
		float totalCompleted = 18;
		float percentCompleted = (filledFieldsAziendaCliente + filledFieldsDossier) / totalCompleted * 100;
		if (percentCompleted >= soglia) {
			sendEmail();
		}
	}

	private void sendEmail() {
		String host = "authsmtp.securemail.pro";
		final String user = "l.lisanti@contrader.it";// change accordingly
		final String password = "xxxxxx";// change accordingly

		String to = "l.lisanti@contrader.it";// change accordingly

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Compilazione Progetto Completata");
			message.setText("La compilazione del progetto e' stata completata");

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}





