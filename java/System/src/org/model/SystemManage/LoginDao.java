package org.model.SystemManage;

import java.util.ArrayList;

import org.model.Query;
import org.model.SystemManage.User;


public class LoginDao {
	public static void print()
	{
		ArrayList<String[]> ret = Query.runSql("\r\n" + 
				"SELECT table_rows FROM information_schema.tables WHERE TABLE_NAME = 'temp.ceshi'",
				"select count(*) from temp.ceshi");
		System.out.print(ret);
	}
	//处理登录信息
	public static boolean login(User user)
	{	
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(2,"select lala,haha from temp.ceshi where lala=\'"+user.getUname()+"\' ");
		return user.getPwd().equals(ret.get(0)[2]);
	}
	public static boolean register(String username,String password) {
		ArrayList<String[]> ret = Query.runSql(1,"select lala from temp.ceshi where lala=\'"+username+"\' ");
	   	String username_real = ret.get(0)[1]; 	   	
		return username_real.equals(username);
    }
}
