package it.contrader.dto;


import it.contrader.model.AziendaCliente;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer idUser;

	private String username;
	
	private String password;

	private String ruolo;
	
	private String email;

	private UserDTO bo;
}