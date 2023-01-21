package com.dal;

import java.sql.SQLException;

import com.pojo.User;

public interface Iuser {
	
	User validate(int id,String password)throws SQLException;

}
