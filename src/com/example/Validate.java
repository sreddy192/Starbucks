package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
	     PrintWriter out = response.getWriter();
	     try {
	         
	        String username = request.getParameter("user");
	        String password = request.getParameter("pass");

	        if(username.equals("John")&& password.equals("800") )
	        {
	           RequestDispatcher rd = request.getRequestDispatcher("mvcjsp2.jsp");
	           rd.forward(request, response);
	        }
	        else if(username.equals("vsh")&& password.equals("600"))
	        {
	        	RequestDispatcher rd = request.getRequestDispatcher("home.html");
		           rd.forward(request, response);
	        }
	        else 
	         {
	         out.println("<font color='red'><b>You have entered incorrect username/password</b></font>");
	                RequestDispatcher rd = request.getRequestDispatcher("home.html");
	                rd.include(request, response);
	            }
	        }finally {            
	            out.close();
	        }
	        
	    }
	
	}


