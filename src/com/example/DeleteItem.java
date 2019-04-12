package com.example;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteItem implements FrontControllerInterface{
	Menu aMenu=null;
	DBOperations dbo;
	
	public DeleteItem() {
		   aMenu=new Menu();
	       dbo=new DBOperations();
	}
	public String execute(HttpServletRequest request,
         HttpServletResponse response) throws Exception {
	    String item=null;
	   String price =null;
	   item=request.getParameter("item");
	   price=request.getParameter("price");
	   aMenu.setItem(item);
	   aMenu.setPrice(price);
		
	   if(dbo.delete(aMenu)) {
		 HttpSession session = request.getSession();
            session.setAttribute("operation", "deleted");
            session.setAttribute
                 ("item", request.getParameter("item"));
            session.setAttribute
                 ("price", request.getParameter("price"));
        	session.removeAttribute("result");
		
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
