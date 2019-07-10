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
}
