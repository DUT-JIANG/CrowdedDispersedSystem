package org.model.SystemManage;

import java.util.ArrayList;

import org.model.Query;

public class RegisterDao {
	
	public static boolean verify(User user)
	{	
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(4,"select police_id,id,tel,email from system.users"
				+ " where police_id=\'"+user.getUsername()+"\' or id=\'"+user.getId()+"\' or tel=\'"+user.getTel()+"\' or email=\'"+user.getEmail()+"\' ");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if(ret.get(0)[1]==null)
		{
			return true;
		}
		return false;
	}
	public static boolean register(User user)
	{	
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(4,"select police_id,id,tel,email from system.users"
				+ " where police_id=\'"+user.getUsername()+"\' or id=\'"+user.getId()+"\' or tel=\'"+user.getTel()+"\' or email=\'"+user.getEmail()+"\' ");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if(ret.get(0)[1]==null)
		{
			return true;
		}
		return false;
	}
}
