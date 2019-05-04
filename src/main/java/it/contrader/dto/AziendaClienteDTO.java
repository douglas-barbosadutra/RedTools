package it.contrader.dto;

import it.contrader.model.User;
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
	
	private float soglia;
	
	private int filledFields; 
	
	private UserDTO user;

	private UserDTO cliente;
}
