package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;


@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
			res.setContentType("text/html");
			
			PrintWriter pw = res.getWriter();
			
			pw.write("<h1>Hi This Is WelCome Page To Valid User</h1>");
			
			pw.write("<h3></h3>"+req.getParameter("password"));
			
			//retrive cookie
			
//			Cookie[] cks = req.getCookies();
//			String Name = null;
//			String city = null;
//			String Requ = null;
//			
//			
//			for(Cookie c : cks)
//			{
//				if(c.getName().equals("custName"))
//				{
//					Name = c.getValue();
//				}
//				if(c.getName().equals("custCity"))
//				{
//					city = c.getValue();
//				}
//				if(c.getName().equals("custReq"))
//				{
//					Requ = c.getValue();
//				}
//			}
//			
//			pw.write("<h1>Name<h1>"+Name);
//			
//			pw.write("<h1> LOcation is  From  City<h1>"+city);
//			
//			pw.write("<h1>Your Requested Password <h1>"+Requ);
//			
//			pw.write("<hr>");
			
			//Retrive session 
			
			pw.write("<h1>Http SerVer Side Cookie Called Session </h1>");
			
			HttpSession hs = req.getSession();
			
			User obj = (User) hs.getAttribute("custInfo");
			
			pw.write("<h1>Your Details <h1>"+ obj);
			
		
		
	}

}
