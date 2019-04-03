package it.contrader.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	private int idBusinessOwner;

}
