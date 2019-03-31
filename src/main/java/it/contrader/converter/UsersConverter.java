package it.contrader.converter;

import it.contrader.dto.UsersDTO;
import it.contrader.model.Users;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class UsersConverter {


	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Users toEntity(UsersDTO usersDTO) {

		Users users = null;
		if (usersDTO != null) {
			users = new Users(usersDTO.getId(), usersDTO.getUsername(), usersDTO.getPassword(), usersDTO.getRuolo());
		}

		return users;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static UsersDTO toDTO(Users users) {

		UsersDTO usersDTO = null;
		if (users != null) {
			usersDTO = new UsersDTO(users.getId(), users.getUsername(), users.getPassword(), users.getRuolo());
		}

		return usersDTO;
	}
	

}
