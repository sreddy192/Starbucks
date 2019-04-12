package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindItem implements FrontControllerInterface {
	Menu aMenu = null;
	DBOperations dbo;

	public FindItem() {
		aMenu = new Menu();
		dbo = new DBOperations();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String item = null;
		String price = null;
		item = request.getParameter("item");
		HttpSession session = request.getSession();
		if ((aMenu = dbo.find(item)) != null) {
			session.setAttribute("item", aMenu.getItem());
			session.setAttribute("price", aMenu.getPrice());
			session.removeAttribute("result");
			return "AdminView.jsp";
		} else
			return "error2.jsp";
	}
	

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws Exception {
		response.sendRedirect(page);

	}
}
