package it.contrader.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

public class Fornitore {
	
	@Id
	@Column(name = "id_fornitore")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFornitore;
	
	@Column(name = "nome_fornitore")
	private String nomeFornitore;
	
	@Column(name = "comune_fornitore")
	private String comuneFornitore;
	
	@Column(name = "provincia_fornitore")
	private String provinciaFornitore;
	
	@Column(name = "partita_iva_fornitore")
	private String partitaIvaFornitore;
	
	@OneToMany(mappedBy = "fornitore")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Fattura> fattura;

}
