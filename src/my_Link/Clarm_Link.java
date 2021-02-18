package my_Link;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Clarm_Link {
	private Boolean aBoolean;
	private  Connection userconn=null;
	private  Statement statement=null;
	private  ResultSet rs =null,rs1=null;
	
	//�����ر����ݿ���Դ����
	private void close(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(userconn!=null){
				userconn.close();
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			}
	}
	
	//������Ӿ�����Ϣ����
	public void AddClarm(String isbn, String name, int number){
		userconn=JDBCLink.getConn();
		try {
			statement=userconn.createStatement();
			String sql="insert into t_clarm values("+"'"+isbn+"',"+"'"+name+"',"+"'"+number+"')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			this.close();
		}
	}
	
	//����ɾ��������Ϣ����
	public void DeleteClarm(String isbn){
		userconn=JDBCLink.getConn();
		try {
			statement=userconn.createStatement();
			String sql="delete from t_clarm where ISBN="+"'"+isbn+"'";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	//��Ӿ���
	public Boolean Add_Clarm(String isbn){
		userconn=JDBCLink.getConn();
		try {
			statement=userconn.createStatement();
			String sql="select *from t_clarm where isbn="+isbn;
			rs=statement.executeQuery(sql);
			rs.last();
			int m=0;int a=0;
			m=rs.getRow();
			rs.beforeFirst();
			if(m==0){}
			else{
				a=Integer.parseInt(rs.getString(3));
			}
			String sql1="select *from t_stock where isbn="+isbn;
			rs1=statement.executeQuery(sql1);
			rs1.last();
			int n=0;int b=0;
			n=rs.getRow();
			rs.beforeFirst();
			if(n==0){}
			else{
				b=Integer.parseInt(rs.getString(3));
			}
			if(b<a){
				aBoolean=false;
			}else{
				aBoolean=true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return aBoolean;
	}
}
