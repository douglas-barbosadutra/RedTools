package it.contrader.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;


public class MomServlet {

	public class MomServlet extends HttpServlet {
		
		
		private final MomService momService = new MomService();
		
		
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			final String scelta = request.getParameter("richiesta");
			final HttpSession session = request.getSession(true);
			switch (scelta) {
			
			
			case "insert":
				final String username = request.getParameter("user_user");
				final String password = request.getParameter("user_pass");
				final String usertype = request.getParameter("user_type");
				final MomDTO mom = new MomDTO(username, password, usertype);
				userService.insertUser(mom);
				showAllUsers(request, response);
				break;
				
				
			case "delete":
				final Integer deleteId = Integer.parseInt(request.getParameter("id"));
				final MomDTO momdelete = new MomDTO("", "", "");
				momdelete.setUserId(deleteId);
				momService.deleteMom(deleteId);
				showAllUsers(request, response);
				break;
			}
		
		
		}
		
		
	}
	
	private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allUsers = this.momService.getAllUser();
		request.setAttribute("allUser", allUsers);
		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
	}
}














