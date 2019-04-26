package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PercentualeOreReDDTO {
	
	private int idPercentualeOreReD;
	
	private double percentualeOreLavorateReD;
	
	private DossierDTO dossier;
	
	private ImpiegatoDTO impiegato;

}
