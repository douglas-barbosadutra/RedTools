package it.contrader.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AziendaCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAziendaCliente")
	private Integer idAziendaCliente;
	
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
	@JoinColumn(name="idUser")
	private User user;
	
	@OneToMany(mappedBy="aziendaCliente")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Mom> mom;
	
	@OneToMany(mappedBy="aziendaCliente")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Progetto> progetto;
	
	@OneToMany(mappedBy="aziendaCliente")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Impiegato> impiegato;
}
