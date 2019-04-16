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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="impiegato")
public class Impiegato {
	
	@Id
	@Column(name = "idNome")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNome;
	
	@Column(name = "nominativo")
	private String nominativo;
	
	@Column(name = "livello")
	private int livello;
	
	@Column(name = "qualifica")
	private String qualifica;
	
	@Column(name = "mansione")
	private String mansione;
	
	@Column(name = "titolo_di_studio")
	private String titoloDiStudio;
	
	@Column(name = "totale_ore_lavorate")
	private int totaleOreLavorate;
	
	@Column(name = "costo_lordo_annuo")
	private double costoLordoAnnuo;
	
	@Column(name = "perc_tot_red")
	private double percTotRed;
	
	@Column(name = "costo_orario")
	private double costoOrario;
	
	@Column(name = "totale_ore_red")
	private double totaleOreRed;
	
	@Column(name = "totale_costi_red")
	private double totaleCostiRed;
	
	
	@OneToMany(mappedBy = "impiegato")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<TotaleOreReD> totaleOreReD;
	
	@ManyToOne
	@JoinColumn(name = "idAziendaCliente")
	private AziendaCliente aziendaCliente;
	
}
