package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="mom")
public class Mom {
	
	@Id
	@Column(name = "id_mom")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMom;
	
	@Column(name = "luogo_mom")
	private String luogoMom;
	
	@Column(name = "data_del_giorno_mom")
	private String dataDelGiornoMom;
	
	@Column(name = "orario_mom")
	private String orarioMom;
	
	@NotNull
	@Column(name = "oggetto_mom")
	private String oggettoMom;
	
	@NotNull
	@Column(name = "progetto_mom")
	private String progettoMom;
	
	@Column(name = "partecipanti_mom")
	private String partecipantiMom;
	
	@Column(name = "testo_agenda_mom")
	private String testoAgendaMom;
	
	@Column(name = "testo_azione_mom")
	private String testoAzioneMom;
	
	@Column(name = "testo_note_mom")
	private String testoNoteMom;

	@ManyToOne
	@JoinColumn(name = "idAziendaCliente")
	private AziendaCliente aziendaCliente;
	
}
