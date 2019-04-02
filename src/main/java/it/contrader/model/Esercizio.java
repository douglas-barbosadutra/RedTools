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
@Table(name="esrecizio")
public class Esercizio {
	
	@Id
	@Column(name = "id_nome")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNome;
	
	@NotNull
	@Column(name = "nominativo")
	private String nominativo;
	
	@NotNull
	@Column(name = "livello")
	private String livello;
	
	@NotNull
	@Column(name = "qualifica")
	private String qualifica;
	
	@NotNull
	@Column(name = "mansione")
	private String mansione;
	
	@NotNull
	@Column(name = "titolodiStudio")
	private String titoloDiStudio;
	
	@ManyToMany
	@JoinTable(name = "dossierEsercizio",
	joinColumns = {@JoinColumn(name = "idNome", nullable = false)},
	inverseJoinColumns = {@JoinColumn(name = "idDossier", nullable = false)})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Esercizio> esercizios;
	
}
