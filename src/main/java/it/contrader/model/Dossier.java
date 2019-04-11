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
@Table(name="dossier")
public class Dossier {
	

	@Id
	@Column(name = "id_dossier")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDossier;

	@Column(name = "periodo_di_imposta")

	private String periodoDiImposta;

	@Column(name = "costo_dipendenti_periodo_di_imposta")
	private double costoDipendentiPeriodoDiImposta;


	@Column(name = "fatturato_periodo_di_imposta")
	private double fatturatoPeriodoDiImposta;

	@Column(name = "numero_totale_dipendenti")
	private int numeroTotaleDipendenti;
	
	@Column(name = "totale_ammissibile")
	private double totaleAmmissibile;
	
	@Column(name = "numero_fornitori")
	private int numeroFornitori;
	
	@ManyToOne
	@JoinColumn(name="id_azienda_cliente")
	private AziendaCliente aziendaCliente;
	
	@ManyToOne
	@JoinColumn(name="idProgetto")
	private Progetto progetto;
	
	@OneToMany(mappedBy="dossier")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Fattura> fattura;
	
	
	@OneToMany(mappedBy="dossier")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<TotaleOreReD> totaleOreReD;
	
	
	

}
