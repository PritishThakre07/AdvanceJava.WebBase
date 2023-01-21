package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	public static Connection con;
	
	public  static Connection openConnection()throws SQLException ,ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Open Connection");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root123");
		
		return con;
	}
	
	public static Connection getCon() {
		return con;
	}

	public static void closeConnection()throws SQLException
	{
		if(con != null )
		{
			con.close();
		}
	}

}
