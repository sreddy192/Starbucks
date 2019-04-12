package com.example;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayItem implements FrontControllerInterface{
	Menu aMenu=null;
	DBOperations dbo;
	String item="";
	public DisplayItem() {
		   aMenu=new Menu();
	       dbo=new DBOperations();
	}
	public String execute(HttpServletRequest request,
         HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
			 if((item=dbo.display())!=null) {
			    session.setAttribute("operation", "registered");
	               session.setAttribute("result", item);
	           	session.removeAttribute("item");
	        	session.removeAttribute("price");
		    	    
	                 return "AdminView.jsp";
	       	 }else 
			    return "error2.jsp";
			 }
	
    public void dispatch(HttpServletRequest request,
        HttpServletResponse response, String page) 
           throws  Exception {
	  response.sendRedirect(page);
	           
   }
}

