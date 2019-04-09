package it.contrader.dto;


import it.contrader.model.AziendaCliente;
import it.contrader.model.Progetto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class DossierDTO {
	
	private int idDossier;
	private String periodoDiImposta;
	private double costoDipendentiPeriodoDiImposta;
	private double fatturatoPeriodoDiImposta;
	private int numeroTotaleDipendenti;
	private AziendaCliente aziendaCliente;
	private Progetto progetto;
	private int filledFields; 
	
	

}
