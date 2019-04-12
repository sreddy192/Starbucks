package com.example;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FrontControllerInterface {
   public String execute(
        HttpServletRequest request, HttpServletResponse response) 
            throws Exception;
   public void dispatch(HttpServletRequest request,
        HttpServletResponse response,String page) throws Exception;
}




