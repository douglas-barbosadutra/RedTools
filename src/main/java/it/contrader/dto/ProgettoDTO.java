package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgettoDTO {

    private Integer idProgetto;

	private String titoloProgetto;
	
	private AziendaClienteDTO aziendaClienteDTO;
	
	private String dettagliProgetto;
	
	private String coordinateDIIN;
}