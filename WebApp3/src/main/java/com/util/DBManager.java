package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	
	private static Connection con ;
	
	public static Connection openConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc,Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost;3306/user","root","root123");
		
		System.out.println("Connected To DB.....");
		 
		
		return con;
		
	}
	
	public static void closeConnection() throws SQLException
	{
		if(con != null)
		{
			con.close();
		}
	}
	

}
