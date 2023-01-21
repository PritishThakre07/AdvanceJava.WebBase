package com.pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test2",loadOnStartup=1)
public class Test2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Doget TEST2");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy TEST2");
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println("init TEST2");
	}
	
	

}
