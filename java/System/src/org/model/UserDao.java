package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.*;
import java.sql.*;

public class UserDao  {
	public static boolean match(String username, String password)
	{	
		ArrayList<String[]> ret = Query.runSql(2,"select haha,nana from temp.ceshi where haha=\'"+username+"\' ");
		String password_real = ret.get(0)[2];
		return password_real.equals(password);
	}

}
