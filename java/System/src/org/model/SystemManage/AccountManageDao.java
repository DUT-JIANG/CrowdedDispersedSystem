package org.model.SystemManage;

import java.util.ArrayList;

import org.model.Query;

public class AccountManageDao {
	public static ArrayList<String[]> accountselect()
	{
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(6,"select police_id,u_name,u_Password,id,tel,email from system.users ");
		for(int i=0;i<ret.size();i++)
        {
			if(ret.get(i)[3].equals("null")||ret.get(i)[3].equals(null)) {
				ret.remove(i);
				i--;
    		}
			else {
				for(int j=1;j<7;j++)
				{
					System.out.print(ret.get(i)[j]+"    "); 
				}
				System.out.println();
			}
        }
		return ret;
	}
	public static int accountinsert(User user)
	{
		String sql = "select police_id,u_Password from system.users where police_id=\'"+user.getUsername()+"\'";
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret = Query.runSql(2,sql);
		if(ret.size()==0){
			return -1;
		}
		else if(!ret.get(0)[2].equals("null")) {
			return 0;
		}
		else {
			String sql1 ="update system.users set u_Password=\'"+user.getPassword()+"\',id=\'"+user.getId()+"\',"
					+ "tel=\'"+user.getTel()+"\',email=\'"+user.getEmail()+"\' where police_id=\'"+user.getUsername()+"\'";
			System.out.println(sql1);
			Query.addSql(sql1);
			return 1;
		}
	}
	public static int accountdeleteverify(String username)
	{
		ArrayList<String[]> ret = new ArrayList<String[]>();
		String temp="select police_id,u_Password " + 
				"from system.users " + 
				"WHERE system.users.police_id=\'"+username+"\'";
		System.out.println(temp);

		ret = Query.runSql(2,temp);
		System.out.println(ret.get(0)[1]);
		if(ret.size()==0)
		{
			return -1;
		}
		else if(ret.get(0)[2].equals("null")) {
			return 0;
		}
		else {
			String sql="update system.users set u_Password=null,id=null,tel=null,email=null where police_id=\'"+username+"\'";
			System.out.println(sql);
			Query.addSql(sql);
			return 1;
		}
	}
	public static int accountmodify(User user)
	{
		String temp="select police_id,password from system.users where police_id=\'"+user.getUsername()+"\'";
		ArrayList<String[]> ret = new ArrayList<String[]>();
		System.out.println(temp);
		ret = Query.runSql(2,temp);
		System.out.println(ret.get(0)[1]);
		if(ret.size()==0)
		{
			return -1;
		}
		else if(ret.get(0)[2].equals("null")) {
			return 0;
		}
		else {
			String sql="update system.users "
					+ "set u_Password=\'"+user.getPassword()+"\',id=\'"+user.getId()+"\',tel=\'"+user.getTel()+"\',"
							+ "email=\'"+user.getEmail()+"\'where police_id=\'"+user.getUsername()+"\'";
			System.out.println(sql);
			Query.addSql(sql);
			return 1;
		}
	}
	public static boolean accountenable(String username,String status)
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
}
