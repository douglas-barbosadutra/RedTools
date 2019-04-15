package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Fattura {
	
	@Id
	@Column(name = "id_fattura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFattura;
	
	
	@Column(name = "data_fattura")
	private String dataFattura;
	
	
	@Column(name = "numero_fattura")
	private String numeroFattura;
	
	
	@Column(name = "descrizione")
	private String descrizione;
	
	
	@Column(name = "totale_imponibile")
	private double totaleImponibile;
	
	
	@Column(name = "percentuale_ammissibile")
	private double percentualeAmmissibile;
	
	@ManyToOne
	@JoinColumn(name = "idDossier")
	private Dossier dossier;
	
	@ManyToOne
	@JoinColumn(name = "idFornitore")
	private Fornitore fornitore;

}
