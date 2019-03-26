package it.contrader.model;

public class Progetto {

	private int idProgetto;
	private String nomeProgetto;
	private int idUtenteFinale;

	public Progetto() {
	}

	

	public Progetto(int idProgetto, String nomeProgetto, int idUtenteFinale) {
		super();
		this.idProgetto = idProgetto;
		this.nomeProgetto = nomeProgetto;
		this.idUtenteFinale = idUtenteFinale;
	}



	public int getIdUtenteFinale() {
		return idUtenteFinale;
	}



	public void setIdUtenteFinale(int idUtenteFinale) {
		this.idUtenteFinale = idUtenteFinale;
	}



	public int getIdProgetto() {
		return idProgetto;
	}

	public void setIdProgetto(int idProgetto) {
		this.idProgetto = idProgetto;
	}

	public String getNomeProgetto() {
		return nomeProgetto;
	}

	public void setNomeProgetto(String nomeProgetto) {
		this.nomeProgetto = nomeProgetto;
	}

	@Override
	public String toString() {
		return this.getIdProgetto() + "\t" + this.getNomeProgetto() + "\t" + this.getIdUtenteFinale();
	}

	public boolean equals(Progetto progettoCompare) {
		if (!(this.getIdProgetto() == progettoCompare.getIdProgetto())) {
			return false;
		}
		if (!this.getNomeProgetto().equals(progettoCompare.getNomeProgetto())) {
				return false;
		}
		if (!(this.getIdUtenteFinale() == progettoCompare.getIdUtenteFinale())) {
			return false;
		}
		return true;
	}
}
