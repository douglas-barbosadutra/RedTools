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
@Table(name="totale_ore_red")
public class TotaleOreReD {
	
	@Id
	@Column(name = "idTotaleOreReD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTotaleOreReD;
	
	@NotNull
	@Column(name = "ore_lavorate_red")
	private double oreLavorateRed;

	@ManyToOne
	@JoinColumn(name = "idDossier")
	private Dossier dossier;
	
	@ManyToOne
	@JoinColumn(name = "idNome")
	private Impiegato impiegato;

}
