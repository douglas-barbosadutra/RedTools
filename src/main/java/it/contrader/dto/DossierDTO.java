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
	private int costoDipendentiPeriodoDiImposta;
	private double fatturatoPeriodoDiImposta;
	private int numeroTotaleDipendenti;
	private Progetto progetto ;
	private AziendaCliente azindaCliente;
	private int filledFields; 
	
	

}
