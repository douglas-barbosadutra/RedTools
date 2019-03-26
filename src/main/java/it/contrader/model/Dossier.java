package it.contrader.model;

public class Dossier {
	private String periodoDiImposta;
	private int costoDipendenti;
	private double fatturatoPeriodoDiImposta;
	private int numeroDipendenti;
	private double costiAttivitaRd;
	private double costiPersonaleRd;
	private String partitaIva;
	private int idProgetto;
	private int idDossier;
	
	public Dossier() {
	}

	public Dossier(String periodoDiImposta, int costoDipendenti, double fatturatoPeriodoDiImposta, int numeroDipendenti,
			double costiAttivitaRd, double costiPersonaleRd, String partitaIva, int idProgetto, int idDossier) {
		this.periodoDiImposta = periodoDiImposta;
		this.costoDipendenti = costoDipendenti;
		this.fatturatoPeriodoDiImposta = fatturatoPeriodoDiImposta;
		this.numeroDipendenti = numeroDipendenti;
		this.costiAttivitaRd = costiAttivitaRd;
		this.costiPersonaleRd = costiPersonaleRd;
		this.partitaIva = partitaIva;
		this.idProgetto = idProgetto;
		this.idDossier = idDossier;
	}

	public String getPeriodoDiImposta() {
		return periodoDiImposta;
	}

	public void setPeriodoDiImposta(String periodoDiImposta) {
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

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
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
	
	@Override
	public String toString() {
		return this.getIdDossier() + "\t" + this.getPeriodoDiImposta()
		+ "\t" + this.getCostoDipendenti()+ "\t" + this.getFatturatoPeriodoDiImposta()
		+ "\t" + this.getNumeroDipendenti()+ "\t" + this.getCostiAttivitaRd()
		+ "\t" + this.getCostiPersonaleRd()+ "\t" + this.getPartitaIva()
		+ "\t" + this.getIdProgetto();
	}

	public boolean equals(Dossier dossierCompare) {
		if (!(this.getPeriodoDiImposta() == dossierCompare.getPeriodoDiImposta())) {
			return false;
		}
		
		if (!(this.getCostoDipendenti() == dossierCompare.getCostoDipendenti())) {
			return false;
		}
		
		if (!(this.getFatturatoPeriodoDiImposta() == dossierCompare.getFatturatoPeriodoDiImposta())) {
			return false;
		}
		
		if (!(this.getNumeroDipendenti() == dossierCompare.getNumeroDipendenti())) {
			return false;
		}
		
		if (!(this.getCostiAttivitaRd() == dossierCompare.getCostiAttivitaRd())) {
			return false;
		}
		
		if (!(this.getCostiPersonaleRd() == dossierCompare.getCostiPersonaleRd())) {
			return false;
		}
		
		if (!(this.getPartitaIva() == dossierCompare.getPartitaIva())) {
			return false;
		}
		
		if (!(this.getIdProgetto() == dossierCompare.getIdProgetto())) {
			return false;
		}

		if (!(this.getIdDossier() == dossierCompare.getIdDossier())) {
			return false;
		}
		
		return true;
	}
	

}
