package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utiil.*;

import com.pojo.User;

public class UserImplement implements Iuser {
	
	User userDao;
	
	private Connection con;
	
	private PreparedStatement stmt;

	public UserImplement() throws SQLException,ClassNotFoundException{
		
		con = DBManager.getCon();
		stmt = con.prepareStatement("select * from users where id=? and password=?");
		
	}

	@Override
	public User validate(int id, String password)throws SQLException{
		User ur =null;
		
		stmt.setInt(1,id);
		stmt.setString(2, password);
		
		ResultSet rset = stmt.executeQuery();
		
		while(rset.next())
		{
			ur = new User(rset.getInt("id"),rset.getString("name"), rset.getNString("city"),rset.getNString("password"));
			
		}
		
		return ur;
	}
	
	public void cleanUp() throws SQLException
	{
		if(stmt != null)
		{
			stmt.close();
		}
	}
	
	
	
	
	
	
	
	
	

}
