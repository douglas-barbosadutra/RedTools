package it.contrader.dto;

import it.contrader.model.AziendaCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgettoDTO {

    private Integer idProgetto;

	private String titoloProgetto;
	
	private AziendaCliente aziendaCliente;
	
	private String dettagliProgetto;
	
	private String coordinateDIIN;


}