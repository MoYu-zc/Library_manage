package my_Link;
/*
 * 数据库连接
 * 数据库的
 * 数据库的名称
 * 数据库的用户名root

 * 数据库的密码
 * password
 */
import java.sql.*;
public class JDBCLink {
	private static Connection conn=null;
	public static Connection getConn() 
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanage?useUnicode=true&characterEncoding=GBK","root","148729");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
	}
}
