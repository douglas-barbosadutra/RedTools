package it.contrader.dto;

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
public class ImpiegatoDTO {
	
	private int idNome;
	
	private String nominativo;
	
	private int livello;
	
	private String qualifica;
	
	private String mansione;
	
	private String titoloDiStudio;
	
	private int totaleOreLavorate;
	
	private int costoLordoAnnuo;
	
}
