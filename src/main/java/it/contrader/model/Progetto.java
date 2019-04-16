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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Progetto {

	@Id
	@Column(name = "id_progetto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProgetto;

	@Column(name = "titolo_progetto")
	private String titoloProgetto;
	
	@Column(name = "dettagli_progetto")
	private String dettagliProgetto;
	
	@Column(name = "coordinate_diin")
	private String coordinateDIIN;

	@OneToMany(mappedBy="progetto")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Dossier> dossier;
	
	@ManyToOne
	@JoinColumn(name="idAziendaCliente")
	private AziendaCliente aziendaCliente;
	
}