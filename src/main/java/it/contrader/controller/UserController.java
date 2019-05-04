package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.AziendaClienteService;
import it.contrader.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/UserController")
public class UserController {

	private final UserService userService;
	private final AziendaClienteService aziendaClienteService; 
	@Autowired
	public UserController(UserService userService, AziendaClienteService aziendaClienteService) {
		this.userService = userService;
		this.aziendaClienteService = aziendaClienteService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO loginControl(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getRuolo();
		if (!StringUtils.isEmpty(ruolo)) {
			return userDTO;
		}
		return null;
	}
	
	@RequestMapping(value = "/clientList", method = RequestMethod.POST)
	public List<UserDTO> clientList(@RequestBody UserDTO bo) {
		return this.userService.getByBo(bo);
	}
	
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public List<UserDTO> userManagement() {
		return this.userService.getListaUserDTO();		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody UserDTO user) {
		AziendaClienteDTO aziendaClienteDTO = new AziendaClienteDTO();
		aziendaClienteDTO.setCliente(userService.insertUserFlush(user));
		aziendaClienteDTO.setUser(user.getBo());
		aziendaClienteDTO.setSoglia(100);
		aziendaClienteService.insertAziendaCliente(aziendaClienteDTO);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public UserDTO read(@RequestParam(value = "userId") int id) {
		return this.userService.getUserDTOById(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "userId") int id) {
		this.userService.deleteUserById(id);
	}

}