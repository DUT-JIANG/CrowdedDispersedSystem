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
		ret = Query.runSql(2,"select police_id,u_Password from system.users where police_id=\'"+user.getUsername()+"\' ");
		System.out.println(ret.get(0)[1]);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return user.getPassword().equals(ret.get(0)[1]);
	}
	public static boolean register(String username,String password) {
		ArrayList<String[]> ret = Query.runSql(1,"select lala from temp.ceshi where lala=\'"+username+"\' ");
	   	String username_real = ret.get(0)[1]; 	   	
		return username_real.equals(username);
    }
}
