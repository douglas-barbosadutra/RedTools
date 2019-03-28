package it.contrader.dto;

public class ProgettoDTO {

	private int idprogetto;
	private String nomeprogetto;
	private int idUtenteFinale;
	

	
	public ProgettoDTO(String nomeprogetto, int idUtenteFinale) {
		super();
		this.nomeprogetto = nomeprogetto;
		this.idUtenteFinale = idUtenteFinale;
	}

	
	
	public ProgettoDTO() {} 
	
	
	
	public int getIdUtenteFinale() {
		return idUtenteFinale;
	}



	public void setIdUtenteFinale(int idUtenteFinale) {
		this.idUtenteFinale = idUtenteFinale;
	}



	public int getIdProgetto() {
		return idprogetto;
	}

	public void setIdProgetto(int idprogetto) {
		this.idprogetto = idprogetto;
	}

	public String getNomeProgetto() {
		return nomeprogetto;
	}

	public void setNomeProgetto(String nomeprogetto) {
		this.nomeprogetto = nomeprogetto;
	}

}


