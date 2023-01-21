package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.UserImplements;
import com.pojo.User;
import com.util.DBManager;

@WebServlet(value="/loginServlet" ,loadOnStartup=1)
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserImplements userDao;
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("Init");
		
		try {
			DBManager.openConnection();
			
			userDao = new UserImplements();
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
       res.setContentType("text/html");
       
       try {
       
              User ur = userDao.validate(Integer.parseInt(req.getParameter("id")), req.getParameter("pass"));
              
              try(PrintWriter pw = res.getWriter()){
              
	              if(ur != null)
	              {
	            	 pw.write("<h1> Hello WelCome To MyPage</h1>");
	            	 pw.write("<h3>user</h3>"+ ur.getName());
	            	 
	            	 pw.write("<i>"+ ur +"</i>");
	            	 
	            	 pw.write("<h1><a href='welcome' > Click Me </a></h1>");
	            	 
	            	 
	              }
	              else {
	            	  
	            	  pw.write("Invalid User "+req.getParameter("name"));
	              }
              }catch(Exception e)
              {
            	  e.printStackTrace();
              }
        
       
       }
       catch(Exception e)
       {
    	   
    	   e.printStackTrace();
       }
		 
		 
	}
	
	
	

	@Override
	public void destroy() {
		
		System.out.println("Destroy");
		
		try {
			userDao.cleanUp();
			DBManager.closeConnection();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
      
	
	
	

}
