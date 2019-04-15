package it.contrader.dto;

import it.contrader.model.Dossier;
import it.contrader.model.Impiegato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotaleOreReDDTO {
	
	private int idTotaleOreReD;
	
	private double oreLavorateRed;
	
	private Dossier dossier;
	
	private Impiegato impiegato;
	
	private double totaleCostiReD;

}
