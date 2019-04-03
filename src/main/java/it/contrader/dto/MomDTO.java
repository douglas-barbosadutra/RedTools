package it.contrader.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MomDTO {

	private int idMom;
	
	private String luogoMom;
	
	private String dataDelGiornoMom;
	
	private String orarioMom;
	
	private String oggettoMom;
	
	private String partecipantiMom;
	
	private String testoAgendaMom;
	
	private String testoAzioneMom;
	
	private String testoNoteMom;
}
