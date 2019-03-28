package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterUser;

import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;

import it.contrader.model.User;


public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<UserDTO> getAllUser() {

		List<User> list = userDAO.getAllUser();
		List<UserDTO> listDTO = new ArrayList<>();

		for (User user : list) {
			listDTO.add(ConverterUser.toDTO(user));
		}

		return listDTO;
	}
	

	public UserDTO getUserByUsernameAndPasword(String username, String password) {
		return ConverterUser.toDTO(userDAO.login(username, password));
	}


	public boolean insertUser(UserDTO userDTO) {
				return this.userDAO.insertUser(ConverterUser.toEntity(userDTO));
	}
	
	public UserDTO readUser(int userId) {
		return ConverterUser.toDTO(this.userDAO.readUser(userId));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.userDAO.updateUser(ConverterUser.toEntity(userDTO));
	}
	
	public boolean deleteUser(int userId) {
		return this.userDAO.deleteUser(userId);
	}
	
	
}
