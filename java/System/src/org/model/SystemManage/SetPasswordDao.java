package org.model.SystemManage;

import org.model.Query;

public class SetPasswordDao {
	public static void setpassword(String password,String username){
		String sql = "UPDATE system.users SET u_Password=\'"+password+"\' where police_id=\'"+username+"\'";
		System.out.println(sql);
		Query.addSql(sql);
	}
}
