package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
public class AdminController extends HttpServlet  {
   private static final long serialVersionUID = 1L;
   // Initializes the servlet.
   FrontControllerInterface mycommand;
   Session mysession=null;
   public void init(ServletConfig config) throws 
	    ServletException {
	    super.init(config);
  }
  // Destroys the servlet.
   public void destroy() {
   }
   protected void doGet(HttpServletRequest request,  
 		    HttpServletResponse response)throws ServletException, 
                             java.io.IOException {
      processRequest(request, response);
   }
   protected void doPost(HttpServletRequest request,  
		    HttpServletResponse response)throws ServletException, 
                             java.io.IOException {
       processRequest(request, response);
   }
   protected void processRequest(HttpServletRequest 
			    request, HttpServletResponse response)
			    throws ServletException, java.io.IOException {
      String page = null;
	 try { 
    	   if(request.getParameter("action").equals("insert")){
	      mycommand= (FrontControllerInterface) new InsertItem();
        }else if(request.getParameter("action").equals("update")) {
        	 mycommand= (FrontControllerInterface) new UpdateItem();
       	   }else if(request.getParameter("action").equals("find")) {
	     mycommand= (FrontControllerInterface) new FindItem();
	   }else if(request.getParameter("action").equals("delete")) {
    		 mycommand= (FrontControllerInterface) new DeleteItem();
	   }else if(request.getParameter("action").equals("display")) {
		 mycommand= (FrontControllerInterface) new DisplayItem();
   	   }
		 page = mycommand.execute(request, response);
	      mycommand.dispatch(request, response, page);
     }catch (Exception e) {
         System.out.println("Error "+e.getMessage());
	}
  }
}

