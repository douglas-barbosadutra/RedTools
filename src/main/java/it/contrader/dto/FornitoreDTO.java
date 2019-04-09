package it.contrader.dto;

import java.util.List;

import it.contrader.model.Fattura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornitoreDTO {
	
	private int idFornitore;
	
	private String nomeFornitore;
	
}
