package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_FW_Board.user.UserDAO;
import com.company.MVC_FW_Board.user.UserDO;
import com.company.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		if(user !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("IdKey", id);
			return "getBoardList.do";
		}else {
			return "login";
		}
		
	}

}
