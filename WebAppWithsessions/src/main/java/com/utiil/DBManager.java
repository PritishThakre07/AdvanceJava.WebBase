package com.utiil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	public static Connection con ;
	
	public static void openConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root123");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}
	
	public void closeConnection()throws SQLException,ClassNotFoundException
	{
		if(con != null)
		{
			con.close();
		}
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		DBManager.con = con;
	}

}
