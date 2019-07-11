package org.model.SystemManage;

import java.util.ArrayList;

import org.model.Query;

public class RoleDao {
	public static void Role(User user)
	{
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(2,"select user_id,role_id from system.userrole where user_id=\'"+user.getUsername()+"\' ");
		String sql = "insert into system.role(role_id,role_status) "
				+ "values(\'"+ret.get(0)[2]+"\','1')";
		System.out.println(sql);
		Query.addSql(sql);
	}
}
