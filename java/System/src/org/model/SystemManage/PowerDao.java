package org.model.SystemManage;

import org.model.Query;

public class PowerDao {
	public static void power(User user)
	{
		String sql = "insert into system.user_role(user_id,power) "
				+ "values(\'"+user.getUsername()+"\','17')";
		System.out.println(sql);
		Query.addSql(sql);
	}
}
