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

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * private void visualUser(HttpServletRequest request) { //UserDTO userDTO =
	 * (UserDTO) session.getAttribute("utente"); List<UserDTO> allUser =
	 * this.userService.getListaUserDTO(); request.setAttribute("allUserDTO",
	 * allUser); }
	 */

	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public List<UserDTO> userManagement() {
		// UserDTO userDTOUserList = new UserDTO();
		// userDTOUserList.setUserId(userId);
		return this.userService.getListaUserDTO();
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public UserDTO read(@RequestParam(value = "userId") int id) {
		UserDTO readUser = new UserDTO();
		readUser = this.userService.getUserDTOById(id);
		return readUser;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "userId") int id) {
		this.userService.deleteUserById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody UserDTO user) {
		userService.insertUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO loginControl(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {

		// session = request.getSession();
		// final String username = request.getParameter("username");
		// final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String userType = userDTO.getRuolo();
		if (!StringUtils.isEmpty(userType)) {

			// session.setAttribute("utente", userDTO);

			/*
			 * if (userType.equals("admin")) { return "home"; } else if
			 * (userType.equals("bo")) { return "home"; }
			 */
			/*
			 * switch (userType.toLowerCase()) { case "admin": return
			 * "redirect:/Home/homeAdmin"; case "bo": return "redirect:/Home/homeBO";
			 * default: return "index"; }
			 */

			return userDTO;

		}

		return null;
		// return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logOut() {
		// request.getSession().invalidate();
		// return "index";
	}
}




















//package it.contrader.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.contrader.dto.UserDTO;
//import it.contrader.services.UserService;
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/User")
//public class UserController {
//
//	private final UserService userService;
////	private HttpSession session;
//	
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginControl(HttpServletRequest request) {
////		session = request.getSession();
////		final String username = request.getParameter("username");
////		final String password = request.getParameter("password");
//		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
//		final String ruolo = userDTO.getRuolo();
//		if (!StringUtils.isEmpty(ruolo)) {
////			session.setAttribute("utenteCollegato", userDTO);
////			//UserService.utenteCollegato = userDTO;
////			if (ruolo.equals("superuser")) {
////				return "homeAdmin";
////			} else if (ruolo.equals("user")) {
//				return userDTO;
//			}
//		
//		return null;
//	
//	}
//	
//	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
//	public list<UserDTO> userManagement() {
////		visualUser(request);
//		return this.userService.findAllUserDTO();		
//	}
//	@RequestMapping(value = "/read", method = RequestMethod.GET)
//	public UserDTO read(@RequestParam(value = "userId") int id) {
//		UserDTO readUser = new UserDTO();
//		readUser = this.userService.getUserDTOById(id);
//		return readUser;
//	}
//	
////	
////	@RequestMapping(value = "/crea", method = RequestMethod.GET)
////	public String insert(HttpServletRequest request) {
////		visualUser(request);
////		request.setAttribute("option", "insert");
////		return "/user/insertUser";
////		
////	}
////	
////	@RequestMapping(value = "/creaUser", method = RequestMethod.POST)
////	public String insertUser(HttpServletRequest request) {
////		String username = request.getParameter("username").toString();
////		String password = request.getParameter("password").toString();
////		String ruolo = request.getParameter("ruolo").toString();
////		String email = request.getParameter("email").toString();
////		UserDTO userObj = new UserDTO(0, username, password, ruolo,email);
////		userService.insertUser(userObj);
////		visualUser(request);
////		return "/user/manageUser";
////	}
////	
////	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
////	public String updateRedirect(HttpServletRequest request) {
////		int id = Integer.parseInt(request.getParameter("id"));
////		UserDTO userUpdate = new UserDTO();
////		// userUpdate.setUserId(id);
////
////		userUpdate = this.userService.getUserDTOById(id);
////		request.setAttribute("userUpdate", userUpdate);
////		return "/user/updateUser";
////	}
////
////	@RequestMapping(value = "/update", method = RequestMethod.POST)
////	public String update(HttpServletRequest request) {
////		Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
////		String usernameUpdate = request.getParameter("user_user");
////		String passwordUpdate = request.getParameter("user_pass");
////		String ruoloUpdate = request.getParameter("user_type");
////		String emailUpdate = request.getParameter("user_email");
////		UserDTO user = new UserDTO();
////		user.setIdUser(idUpdate);
////		user.setUsername(usernameUpdate);
////		user.setPassword(passwordUpdate);
////		user.setRuolo(ruoloUpdate);
////		user.setEmail(emailUpdate);
////		userService.updateUser(user);
////		visualUser(request);
////		return "/user/manageUser";
////	}
////	
////	@RequestMapping(value = "/delete", method = RequestMethod.GET)
////	public String delete(HttpServletRequest request) {
////		int id = Integer.parseInt(request.getParameter("id"));
////		request.setAttribute("id", id);
////		this.userService.deleteUserById(id);
////		visualUser(request);
////		return "/user/manageUser";
////		
////	}
////	
////	@RequestMapping(value = "/logout", method = RequestMethod.GET)
////	public String logout(HttpServletRequest request) {
////		session.setAttribute("utenteCollegato", null);
////		return "index";
////		
////	}
////	
////	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
////	public String cercaUser(HttpServletRequest request) {
////
////		final String content = request.getParameter("search");
////
////		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
////		request.setAttribute("allUserDTO", allUser);
////
////		return "/user/manageUser";
////
////	}
////	
////	private void visualUser(HttpServletRequest request){
////		List<UserDTO> allUser = this.userService.getListaUserDTO();
////		request.setAttribute("allUserDTO", allUser);
////	}
//}