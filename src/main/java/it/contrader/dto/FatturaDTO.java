package it.contrader.dto;

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
	
	private int percentualeAmmissibile;
	
}
