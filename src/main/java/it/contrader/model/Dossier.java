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

public class Dossier {
	

	@Id
	@Column(name = "idDossier")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDossier;

	@Column(name = "periodoDiImposta")
	@NotNull
	private String periodoDiImposta;

	@Column(name = "costoDipendentiPeriodoDiImposta")
	private double costoDipendentiPeriodoDiImposta;


	@Column(name = "fatturatoPeriodoDiImposta")
	private double fatturatoPeriodoDiImposta;

	@Column(name = "numeroTotaleDipendenti")
	private int numeroTotaleDipendenti;
	
	@ManyToOne
	@JoinColumn(name="idProgetto")
	private Progetto progetto ;
	
	@ManyToOne
	@JoinColumn(name="idAziendaCliente")
	private AziendaCliente aziendaCliente;
	
	@OneToMany(mappedBy="dossier")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Fattura> fatturas;
	
	
	@OneToMany(mappedBy="dossier")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<TotaleOreReD> totaleOreReDs;
	
	
	

}
