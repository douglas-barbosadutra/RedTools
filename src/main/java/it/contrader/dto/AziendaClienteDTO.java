package it.contrader.dto;

import java.util.List;


import it.contrader.model.Dossier;
import it.contrader.model.Mom;
import it.contrader.model.Progetto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AziendaClienteDTO {
	
	private int idAziendaCliente;
	
	private String denominazioneSocieta;
	
	private String formaGiuridica;
	
	private String sedeLegale;
	
	private String partitaIva;
	
	private String telefono;
	
	private String email;
	
	private String indirizzoUnitaLocale;
	
	private String attivitaAzienda;
	
	private String legaleRappresentante;
	
	private String natoA;
	
	private String natoIl;
	
	private int filledFields;
	
	private UserDTO userDTO;
	
	private List<Dossier> dossier;
	
	private List<Mom> mom;
	
	private List<Progetto> progetto;

}
