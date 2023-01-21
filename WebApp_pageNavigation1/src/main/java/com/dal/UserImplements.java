package com.dal;

import com.pojo.*;
import com.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImplements implements Iuser {
	
	private Connection con;
	private PreparedStatement stmt;
	
	public UserImplements()
	{
		try {
		con = DBManager.openConnection();
		
		stmt = con.prepareStatement("select * from users"
				+ " where id=? and password=?");
		
		System.out.println("inside userImplements");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public User validate(int id, String password) throws SQLException {
		
		stmt.setInt(1,id);
		stmt.setString(2,password);
		
		ResultSet rset = stmt.executeQuery();
		
		User ur = null;
		
		while(rset.next())
		{
			int Id = rset.getInt("id");
			String pass = rset.getString("password");
			String name = rset.getString("name");
			String city = rset.getString("city");
			
			 ur = new User(Id, name, city, pass);
			
		}
		
		
		
		return ur;
	}
	
	public void cleanUp()throws SQLException
	{
		
		if(stmt != null)
		{
			stmt.close();
		}
	}
	
	

	
	
	
	
	
	
	
	

	
	
	
	
	

	
	


}
