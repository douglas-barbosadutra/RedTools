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
@Table(name="impiegato")
public class Impiegato {
	
	@Id
	@Column(name = "idNome")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNome;
	
	@NotNull
	@Column(name = "nominativo")
	private String nominativo;
	
	@NotNull
	@Column(name = "livello")
	private int livello;
	
	@NotNull
	@Column(name = "qualifica")
	private String qualifica;
	
	@NotNull
	@Column(name = "mansione")
	private String mansione;
	
	@NotNull
	@Column(name = "titolodiStudio")
	private String titoloDiStudio;
	
	@NotNull
	@Column(name = "totale_ore_lavorate")
	private int totaleOreLavorate;
	
	@NotNull
	@Column(name = "costo_lordo_annuo")
	private int costoLordoAnnuo;
	
	@OneToMany(mappedBy = "impiegato")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<TotaleOreReD> totaleOreReD;
	
	@ManyToOne
	@JoinColumn(name = "idAziendaCliente")
	private AziendaCliente aziendaCliente;
	
}
