package org.model.SystemManage;

import java.util.ArrayList;

import org.model.Query;

public class RoleManageDao {
	public static ArrayList<String[]> roleselect()
	{
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(9,"select police_id,u_name,unit,position,birthdate,jointime,role_name,role_status,power \r\n" + 
				"from users,user_role,role\r\n" + 
				"WHERE users.police_id=user_role.user_id and user_role.role_id = role.role_id");
		return ret;
	}
	public static void roleinsert(User user,String role_name,String status)
	{
		String sql ="insert into system.users(police_id,u_name,unit,position,birthdate,jointime)"
				+ "values(\'"+user.getUsername()+"\',\'"+user.getRealname()+"\',\'"+user.getUnit()+"\',\'"
				+user.getPosition()+"\',\'"+user.getTel()+"\',\'"+user.getEmail()+"\')";
		Query.addSql(sql);
		System.out.println(sql);

		String sql1="insert into system.user_role(user_id,power)"
				+ "values(\'"+user.getUsername()+"\','17')";
		Query.addSql(sql1);
		System.out.println(sql1);

		String tmp ="select role_id,user_id from system.user_role where user_id=\'"+user.getUsername()+"\'";
		System.out.println(tmp);
		ArrayList<String[]> temp=Query.runSql(2,"select role_id,user_id from system.user_role where user_id=\'"+user.getUsername()+"\'");
		System.out.println(temp.get(0)[1]+"      "+temp.get(0)[2]+"\n"+role_name+status);
		String sql2="insert into system.role(role_id,role_name,role_status)"
				+ "values(\'"+temp.get(0)[1]+"\',\'"+role_name+"\',\'"+status+"\')";
		System.out.println(temp.get(0)[1]+"      "+temp.get(0)[2]+"\n"+sql2);
		Query.addSql(sql2);
	}
	public static boolean roledeleteverify(String username)
	{
		ArrayList<String[]> ret = new ArrayList<String[]>();
		String temp="select police_id,system.user_role.role_id " + 
				"from system.users,system.user_role,system.role " + 
				"WHERE system.users.police_id=\'"+username+"\' and system.users.police_id=system.user_role.user_id and system.user_role.role_id = system.role.role_id";
		System.out.println(temp);

		ret = Query.runSql(2,temp);
		System.out.println(ret.get(0)[1]+"     "+ret.get(0)[2]);
		if(ret.size()==0)
		{
			return false;
		}
		else {
			String sql1="delete from system.role where system.role.role_id= \'"+ret.get(0)[2]+"\'";
			System.out.println(sql1);
			Query.addSql(sql1);
			String sql2="delete from system.user_role where system.user_role.role_id= \'"+ret.get(0)[2]+"\'";
			System.out.println(sql2);
			Query.addSql(sql2);
			String sql3="delete from system.users where system.users.police_id= \'"+username+"\'";
			System.out.println(sql3);
			Query.addSql(sql3);
			return true;
		}
	}
	public static void rolemodify(User user,String role_name)
	{
		String sql ="update system.users set u_name=\'"+user.getRealname()+"\',unit=\'"+user.getUnit()+"\',position=\'"+user.getPosition()+"\',"
				+ "birthdate=\'"+user.getTel()+"\',jointime=\'"+user.getEmail()+"\' where police_id=\'"+user.getUsername()+"\'";
		Query.addSql(sql);
		System.out.println(sql);

		String tmp ="select role_id,user_id from system.user_role where user_id=\'"+user.getUsername()+"\'";
		System.out.println(tmp);
		ArrayList<String[]> temp=Query.runSql(2,"select role_id,user_id from system.user_role where user_id=\'"+user.getUsername()+"\'");
		System.out.println(temp.get(0)[1]+"      "+temp.get(0)[2]+"\n"+role_name);
		String sql1="update system.role set role_name=\'"+role_name+"\' where role_id=\'"+temp.get(0)[1]+"\'";
		System.out.println(temp.get(0)[1]+"      "+temp.get(0)[2]+"\n"+sql1);
		Query.addSql(sql1);
	}
	public static boolean roleenable(String username,String status)
	{
		String temp="select police_id " + 
				"from system.users " + 
				"WHERE police_id=\'"+username+"\'";
		System.out.println(temp);

		ArrayList<String[]> ret = Query.runSql(1,temp);
		System.out.println(ret.get(0)[1]);
		if(ret.size()==0)
		{
			return false;
		}
		else {
			String sql1="select role_id,user_id from system.user_role where user_id=\'"+username+"\'";
			System.out.println(sql1);
			ArrayList<String[]> ret1=Query.runSql(2,sql1);
			String sql2="update system.role set role_status=\'"+status+"\' where role_id= \'"+ret1.get(0)[1]+"\'";
			System.out.println(sql2);
			Query.addSql(sql2);
			return true;
		}
	}
	public static int rolepower(String username,int power) {
		String temp="select police_id " + 
				"from system.users " + 
				"WHERE police_id=\'"+username+"\'";
		System.out.println(temp);

		ArrayList<String[]> ret = Query.runSql(1,temp);
		System.out.println(ret.get(0)[1]);
		if(ret.size()==0)
		{
			return 0;
		}
		else {
			String sql="update system.role,system.user_role set power=\'"+power+"\'" 
					+ "WHERE system.user_role.role_id=system.role.role_id and system.user_role.user_id=\'"+username+"\'";
			System.out.println(sql);
			Query.addSql(sql);
			return 1;
		}
		
	}
}
