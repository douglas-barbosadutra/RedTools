package it.contrader.dto;

public class MomDTO {

	private int id_mom;
	private String nome_utente_finale_mom;
	private String luogo_mom;
	private String data_del_giorno_mom;
	private String orario_mom;
	private String oggetto_mom;
	private String progetto_mom;
	private String partecipanti_mom;
	private String testo_agenda_mom;
	private String testo_azione_mom;
	private String testo_note_mom;
	private int chiave_est_ut_fin;
	
	public MomDTO() {}
	
	public MomDTO(String nome_utente_finale_mom, String luogo_mom, String data_del_giorno_mom,
			String orario_mom, String oggetto_mom, String progetto_mom, String partecipanti_mom,
			String testo_agenda_mom, String testo_azione_mom, String testo_note_mom, int chiave_est_ut_fin) {
		super();
		
		this.nome_utente_finale_mom = nome_utente_finale_mom;
		this.luogo_mom = luogo_mom;
		this.data_del_giorno_mom = data_del_giorno_mom;
		this.orario_mom = orario_mom;
		this.oggetto_mom = oggetto_mom;
		this.progetto_mom = progetto_mom;
		this.partecipanti_mom = partecipanti_mom;
		this.testo_agenda_mom = testo_agenda_mom;
		this.testo_azione_mom = testo_azione_mom;
		this.testo_note_mom = testo_note_mom;
		this.chiave_est_ut_fin = chiave_est_ut_fin;
	}

	public int getId_mom() {
		return id_mom;
	}

	public void setId_mom(int id_mom) {
		this.id_mom = id_mom;
	}

	public String getNome_utente_finale_mom() {
		return nome_utente_finale_mom;
	}

	public void setNome_utente_finale_mom(String nome_utente_finale_mom) {
		this.nome_utente_finale_mom = nome_utente_finale_mom;
	}

	public String getLuogo_mom() {
		return luogo_mom;
	}

	public void setLuogo_mom(String luogo_mom) {
		this.luogo_mom = luogo_mom;
	}

	public String getData_del_giorno_mom() {
		return data_del_giorno_mom;
	}

	public void setData_del_giorno_mom(String data_del_giorno_mom) {
		this.data_del_giorno_mom = data_del_giorno_mom;
	}

	public String getOrario_mom() {
		return orario_mom;
	}

	public void setOrario_mom(String orario_mom) {
		this.orario_mom = orario_mom;
	}

	public String getOggetto_mom() {
		return oggetto_mom;
	}

	public void setOggetto_mom(String oggetto_mom) {
		this.oggetto_mom = oggetto_mom;
	}

	public String getProgetto_mom() {
		return progetto_mom;
	}

	public void setProgetto_mom(String progetto_mom) {
		this.progetto_mom = progetto_mom;
	}

	public String getPartecipanti_mom() {
		return partecipanti_mom;
	}

	public void setPartecipanti_mom(String partecipanti_mom) {
		this.partecipanti_mom = partecipanti_mom;
	}

	public String getTesto_agenda_mom() {
		return testo_agenda_mom;
	}

	public void setTesto_agenda_mom(String testo_agenda_mom) {
		this.testo_agenda_mom = testo_agenda_mom;
	}

	public String getTesto_azione_mom() {
		return testo_azione_mom;
	}

	public void setTesto_azione_mom(String testo_azione_mom) {
		this.testo_azione_mom = testo_azione_mom;
	}

	public String getTesto_note_mom() {
		return testo_note_mom;
	}

	public void setTesto_note_mom(String testo_note_mom) {
		this.testo_note_mom = testo_note_mom;
	}

	public int getChiave_est_ut_fin() {
		return chiave_est_ut_fin;
	}

	public void setChiave_est_ut_fin(int chiave_est_ut_fin) {
		this.chiave_est_ut_fin = chiave_est_ut_fin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
