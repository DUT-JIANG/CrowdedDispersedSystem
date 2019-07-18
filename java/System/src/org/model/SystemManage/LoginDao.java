package org.model.SystemManage;

import java.util.ArrayList;
import org.model.Query;
import org.model.SystemManage.User;

public class LoginDao {
	public static boolean login(User user)
	{	
		ArrayList<String[]> ret = new ArrayList<String[]>();
		if(user.getUsername()!=null) {
			ret = Query.runSql(2,"select police_id,u_Password from system.users where police_id=\'"+user.getUsername()+"\' ");
			if(ret.size()==0)
			{
				return false;
			}
			else {
				System.out.println(ret.get(0)[2]);
				return user.getPassword().equals(ret.get(0)[2]);
			}
		}
		else
			return false;
	}
	public static ArrayList<String[]> getcookie(User user){
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(3,"select user_id,power,role_status from system.user_role,system.role "
				+ "where user_id=\'"+user.getUsername()+"\' and system.user_role.role_id = system.role.role_id ");
		return ret;
	}
}
