package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         System.out.println("Inside http Post");
		
         String name = request.getParameter("user");
		
		 String password = request.getParameter("pwd");
		
		 response.setContentType("text/html");
		
		 PrintWriter pw = response.getWriter();
		 
		 pw.write("<h1>Valid User : </h1>"+name);
		 
		 pw.write("<h1>Valid User : </h1>"+password);
	
	}
	
	
	

	@Override
	public void destroy() {
		
		System.out.println("Destroy");
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println("Init");
		
	}
      
	
	
	

}
