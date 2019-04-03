package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Aziende")
public class AziendaCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAzienda")
	private int idAzienda;
	
	@Column(name = "denominazioneSocieta")
	private String denominazioneSocieta;
	
	@Column(name = "formaGiuridica")
	private String formaGiuridica;
	
	@Column(name = "sedeLegale")
	private String sedeLegale;
	
	@Column(name = "partitaIva")
	private String partitaIva;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "indirizzoUnitaLocale")
	private String indirizzoUnitaLocale;
	
	@Column(name = "attivitaAzienda")
	private String attivitaAzienda;
	
	@Column(name = "legaleRappresentante")
	private String legaleRappresentante;
	
	@Column(name = "natoA")
	private String natoA;
	
	@Column(name = "natoIl")
	private String natoIl;
	
	@ManyToOne
	@JoinColumn(name="idBusinessOwner")
	private int idBusinessOwner;
	
}
