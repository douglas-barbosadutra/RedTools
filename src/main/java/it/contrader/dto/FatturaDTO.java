package it.contrader.dto;

import it.contrader.model.Dossier;
import it.contrader.model.Fornitore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FatturaDTO {
	
	private int idFattura;
	
	private String dataFattura;
	
	private String numeroFattura;
	
	private String descrizione;
	
	private double totaleImponibile;
	
	private double percentualeAmmissibile;
	
	private double totaleAmmissibile;
	
	private Dossier dossier;
	
	private Fornitore fornitore;
	
}
