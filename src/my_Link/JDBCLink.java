package my_Link;
/*
 * ���ݿ�����
 * ���ݿ��
 * ���ݿ������
 * ���ݿ���û���root

 * ���ݿ������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
}
