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
@Table(name="fattura")
public class Fattura {
	
	@Id
	@Column(name = "id_fattura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFattura;
	
	@NotNull
	@Column(name = "data_fattura")
	private String dataFattura;
	
	@NotNull
	@Column(name = "numero_fattura")
	private String numeroFattura;
	
	@NotNull
	@Column(name = "descrizione")
	private String descrizione;
	
	@NotNull
	@Column(name = "totale_imponibile")
	private double totaleImponibile;
	
	@NotNull
	@Column(name = "percentuale_ammissibile")
	private int percentualeAmmissibile;
	
	@ManyToOne
	@JoinColumn(name = "idDossier")
	private Dossier dossier;
	
	@ManyToOne
	@JoinColumn(name = "idFornitore")
	private Fornitore fornitore;

}
