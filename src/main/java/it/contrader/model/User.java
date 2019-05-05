package it.contrader.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;

	@Column(name = "username")
	@NotNull
	private String username;

	@Column(name = "password")
	@NotNull
	private String password;

	@NotNull
	@Column(name = "ruolo")
	private String ruolo;

	@Nullable
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "user")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<AziendaCliente> aziendaCliente;
	
	@OneToMany(mappedBy = "user")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<AziendaCliente> anagrafica;
	
	@ManyToOne
	private User bo;
	
	@OneToMany(mappedBy = "bo")
	private List<User> clients;


}