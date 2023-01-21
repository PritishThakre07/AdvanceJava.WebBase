package com.pages;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet(value="/test3",loadOnStartup=2)
public class Test3 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Doget TEST3");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy TEST3");
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println("init TEST3");
	}
	

}
