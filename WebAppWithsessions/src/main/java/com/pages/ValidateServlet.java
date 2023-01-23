package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dal.UserImplement;
import com.pojo.User;
import com.utiil.DBManager;


@WebServlet(value= "/validate",loadOnStartup = 1)
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserImplement userDao ;
       
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
			DBManager.openConnection();
			
			userDao = new UserImplement();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
    
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		try (PrintWriter pw = res.getWriter()){
			
			
			User ur =userDao.validate(Integer.parseInt(req.getParameter("id")), req.getParameter("password"));
			
			if(ur != null)
			{
				
				
				pw.write("<h1>Valid User:</h1>"+ur.getName());
				
				pw.write("<h1>Valid User:</h1>"+ur.toString());
				
				pw.write("<hr>");
				
				
				//Client Pool
				
				// Url Change , req Change 
				// Method Must Be Get In welcome Page OtherWise Error
				
				//res.sendRedirect("welcome");
				
				
				
				//Server Pool
				// Url NotChange , req NotChange
				//RequestDispatcher ds = req.getRequestDispatcher("welcome");
				
				//ds.include(req, res);////Must be Postmethod in welcome Page Otherwise Erro , Url is not channge but req IsForward So we get all param of req
				
				 //ds.forward(req, res);//Must be Postmethod in welcome Page Otherwise Erro , Url is not channge but req Is Forward So we get all param of req
				
				
				
				Cookie ck1 = new Cookie("custName",ur.getName());
				Cookie ck2 = new Cookie("custCity",ur.getCity());
				Cookie ck3 = new Cookie("custReq",req.getParameter("password"));
				
				res.addCookie(ck1);
				res.addCookie(ck2);
				res.addCookie(ck3);
				
				
				//Server Side Session Cockie
				HttpSession hs = req.getSession();
				
				hs.setAttribute("custInfo",ur);
				
				
				
				pw.write("<a href='welcome'>Click</a>");
				
				
			}
			else 
			{
				pw.write("<h1>Invalid User</h1>");
				pw.write("<a href='login.html'>Try Again</a>");
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	


	

	
	public void destroy() {
		
	}
}
