package com.pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class Test1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("inside doget");
	}

	@Override
	public void destroy() {
		
		System.out.println("inside Destroy");
		
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println("inside init");
	}

	
	
	
	
	
	
	
	
	
	

}
