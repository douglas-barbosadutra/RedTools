package it.contrader.dto;

import it.contrader.model.AziendaCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImpiegatoDTO {
	
	private int idNome;
	
	private String nominativo;
	
	private int livello;
	
	private String qualifica;
	
	private String mansione;
	
	private String titoloDiStudio;
	
	private int totaleOreLavorate;
	
	private double costoLordoAnnuo;
	
	private double percTotRed;
	
	private double costoOrario;
	
//	private double totaleOreRed;
//	
	private double totaleCostiRed;
	
	private AziendaCliente aziendaCliente;
	
}
