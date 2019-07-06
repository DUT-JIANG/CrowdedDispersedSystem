package org.model.SystemManage;

import java.util.ArrayList;

import org.model.Query;

public class ModifyDao {
	public static boolean modify(User user)
	{	
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(2,"select police_id,u_Password from system.users where police_id=\'"+user.getUsername()+"\' ");
		System.out.println(ret.get(0)[1]);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return user.getPassword().equals(ret.get(0)[1]);
	}

}
