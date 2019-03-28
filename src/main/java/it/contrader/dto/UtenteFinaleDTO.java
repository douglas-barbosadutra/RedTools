package it.contrader.dto;

public class UtenteFinaleDTO {
	String denominazioneSocieta;
	String formaGiuridica;
	String sedeLegale;
	String partitaIva;
	String telefono;
	String email;
	String indirizzoUnitaLocale;
	String attivitaAzienda;
	String legaleRappresentante;
	String natoA;
	String natoIl;
	int idUtente;
	int id;
	int  filledFields;
	
	
	public UtenteFinaleDTO(String denominazioneSocieta, String formaGiuridica, String sedeLegale, String partitaIva,
			String telefono, String email, String indirizzoUnitaLocale, String attivitaAzienda,
			String legaleRappresentante, String natoA, String natoIl, int idUtente) {
		
		this.denominazioneSocieta = denominazioneSocieta;
		this.formaGiuridica = formaGiuridica;
		this.sedeLegale = sedeLegale;
		this.partitaIva = partitaIva;
		this.telefono = telefono;
		this.email = email;
		this.indirizzoUnitaLocale = indirizzoUnitaLocale;
		this.attivitaAzienda = attivitaAzienda;
		this.legaleRappresentante = legaleRappresentante;
		this.natoA = natoA;
		this.natoIl = natoIl;
		this.idUtente = idUtente;
		
	}

	public UtenteFinaleDTO() {
		
	}
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominazioneSocieta() {
		return denominazioneSocieta;
	}
	public void setDenominazioneSocieta(String denominazioneSocieta) {
		this.denominazioneSocieta = denominazioneSocieta;
	}
	public String getFormaGiuridica() {
		return formaGiuridica;
	}
	public void setFormaGiuridica(String formaGiuridica) {
		this.formaGiuridica = formaGiuridica;
	}
	public String getSedeLegale() {
		return sedeLegale;
	}
	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzoUnitaLocale() {
		return indirizzoUnitaLocale;
	}
	public void setIndirizzoUnitaLocale(String indirizzoUnitaLocale) {
		this.indirizzoUnitaLocale = indirizzoUnitaLocale;
	}
	public String getAttivitaAzienda() {
		return attivitaAzienda;
	}
	public void setAttivitaAzienda(String attivitaAzienda) {
		this.attivitaAzienda = attivitaAzienda;
	}
	public String getLegaleRappresentante() {
		return legaleRappresentante;
	}
	public void setLegaleRappresentante(String legaleRappresentante) {
		this.legaleRappresentante = legaleRappresentante;
	}
	public String getNatoA() {
		return natoA;
	}
	public void setNatoA(String natoA) {
		this.natoA = natoA;
	}
	public String getNatoIl() {
		return natoIl;
	}
	public void setNatoIl(String natoIl) {
		this.natoIl = natoIl;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getFilledFields() {
		return filledFields;
	}

	public void setFilledFields(int filledfields) {
		this.filledFields = filledfields;
	}
	
	

}
