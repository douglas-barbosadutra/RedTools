package it.contrader.dto;



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
	private double totaleCostiReD;
	private double costiPersonaleReD;
	private double totaleAmmissibile;
	private int numeroFornitori;
	private ProgettoDTO progettoDTO;
	private int filledFields; 
	
	

}
