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
@Table(name="percentuale_ore_red")
public class PercentualeOreReD {
	
	@Id
	@Column(name = "idPercentualeOreReD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPercentualeOreReD;
	
	@NotNull
	@Column(name = "percentuale_ore_lavorate_red")
	private double percentualeOreLavorateReD;

	@ManyToOne
	@JoinColumn(name = "idDossier")
	private Dossier dossier;
	
	@ManyToOne
	@JoinColumn(name = "idNome")
	private Impiegato impiegato;

}
