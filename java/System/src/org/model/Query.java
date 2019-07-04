package org.model;
import com.mysql.*;
import java.sql.*;
import java.util.ArrayList;
public class Query {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://www.codingjiang.com.cn:3306/?serverTimezone=UTC";
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
  
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "660321";
    public static ArrayList<String[]> runSql(int sql1,String sql)  {
		// TODO Auto-generated method stub
		int columnCount = sql1;
		// TODO Auto-generated method stub
		
		try{
			ArrayList<String[]> ret = new ArrayList<String[]>();
			Connection conn = null;
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //调用Class.forName()方法加载驱动程序 
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");
            
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            /*****************************************************/
            /*****************************************************/
                while (rs.next()){
                	String[] line = new String [columnCount+1];
	                for(int i=1;i<line.length;i++){
	                    line[i]=new String(rs.getString(i));
	                 }
	                ret.add(line);
 
                }
                rs.close();
                stmt.close();
                conn.close();
                return ret;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return null;
	}
    
	public static ArrayList<String[]> runSql(String sql1,String sql)  {
		// TODO Auto-generated method stub
		int columnCount = 0;
		// TODO Auto-generated method stub
		try{
			Connection conn = null;
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //调用Class.forName()方法加载驱动程序 
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");            
            ResultSet rs = stmt.executeQuery(sql1);//创建数据对象
            /*****************************************************/
                while (rs.next()){
                	columnCount+=rs.getInt(1);
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		try{
			ArrayList<String[]> ret = new ArrayList<String[]>();
			Connection conn = null;
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //调用Class.forName()方法加载驱动程序 
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");
            
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            /*****************************************************/
            /*****************************************************/
            System.out.print("1");
                while (rs.next()){
                	String[] line = new String [columnCount+1];
	                for(int i=1;i<line.length;i++){
	                    line[i]=new String(rs.getString(i));
	                 }
	                ret.add(line);
 
                }
                rs.close();
                stmt.close();
                conn.close();
                return ret;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return null;
	}
}
