package it.contrader.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="costi_esterni")
public class CostiEsterni {
	
	@Id
	@Column(name = "id_fornitore")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFornitore;
	
	@NotNull
	@Column(name = "nominativo_fornitore")
	private String nominativoFornitore;
	
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
	
	@ManyToMany
	@JoinTable(name = "dossierCostiEsterni",
	joinColumns = {@JoinColumn(name = "idFornitore", nullable = false)},
	inverseJoinColumns = {@JoinColumn(name = "idDossier", nullable = false)})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CostiEsterni> costiEsternis;

}
