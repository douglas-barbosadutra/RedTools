package it.contrader.dto;

public class DossierDTO {
	private int costoDipendenti;
	private double fatturatoPeriodoDiImposta;
	private int numeroDipendenti;
	private double costiAttivitaRd;
	private double costiPersonaleRd;
	private int idUtentefinale;
	private int idProgetto;
	private int idDossier;
	private String periodoDiImposta;
	private int filledFields; 
	
	public DossierDTO() {
	}
	
	
	public DossierDTO(int costoDipendenti, double fatturatoPeriodoDiImposta, int numeroDipendenti,
			double costiAttivitaRd, double costiPersonaleRd, int idUtentefinale, int idProgetto, int idDossier,
			String periodoDiImposta) {
		super();
		this.costoDipendenti = costoDipendenti;
		this.fatturatoPeriodoDiImposta = fatturatoPeriodoDiImposta;
		this.numeroDipendenti = numeroDipendenti;
		this.costiAttivitaRd = costiAttivitaRd;
		this.costiPersonaleRd = costiPersonaleRd;
		this.idUtentefinale = idUtentefinale;
		this.idProgetto = idProgetto;
		this.idDossier = idDossier;
		this.periodoDiImposta = periodoDiImposta;
	}


	public int getCostoDipendenti() {
		return costoDipendenti;
	}
	public void setCostoDipendenti(int costoDipendenti) {
		this.costoDipendenti = costoDipendenti;
	}
	public double getFatturatoPeriodoDiImposta() {
		return fatturatoPeriodoDiImposta;
	}
	public void setFatturatoPeriodoDiImposta(double fatturatoPeriodoDiImposta) {
		this.fatturatoPeriodoDiImposta = fatturatoPeriodoDiImposta;
	}
	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}
	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}
	public double getCostiAttivitaRd() {
		return costiAttivitaRd;
	}
	public void setCostiAttivitaRd(double costiAttivitaRd) {
		this.costiAttivitaRd = costiAttivitaRd;
	}
	public double getCostiPersonaleRd() {
		return costiPersonaleRd;
	}
	public void setCostiPersonaleRd(double costiPersonaleRd) {
		this.costiPersonaleRd = costiPersonaleRd;
	}
	
	
	public int getIdUtentefinale() {
		return idUtentefinale;
	}


	public void setIdUtentefinale(int idUtentefinale) {
		this.idUtentefinale = idUtentefinale;
	}


	public int getIdProgetto() {
		return idProgetto;
	}
	public void setIdProgetto(int idProgetto) {
		this.idProgetto = idProgetto;
	}
	public int getIdDossier() {
		return idDossier;
	}
	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}
	public String getPeriodoDiImposta() {
		return periodoDiImposta;
	}
	public void setPeriodoDiImposta(String periodoDiImposta) {
		this.periodoDiImposta = periodoDiImposta;
	}


	public int getFilledFields() {
		return filledFields;
	}


	public void setFilledFields(int filledFields) {
		this.filledFields = filledFields;
		
	}
	
	
	
	
	
	

}
