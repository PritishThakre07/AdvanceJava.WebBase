package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		System.out.println("-----inside init WelcomeServlet----");	 
		}

		 
		public void destroy() {
			System.out.println("-----inside destroy WelcomeServlet----");	
		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter pw = response.getWriter())
		{
			
			response.setContentType("text/html");
			
			pw.write("<h1> WelCome Here All!!!! </h1>");
			pw.write("<hr>");
			pw.write("<h1> </h1>"+LocalDate.now());
			
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		
	}

	

}
