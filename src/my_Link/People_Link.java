package my_Link;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class People_Link {
	private Boolean aboolean;
	private  Connection userconn=null;
	private  Statement statement=null;
	private  ResultSet rs =null;
	
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
	
	//�����½��ɹ��̵ķ���
	public void AddPuechase(String name, String people, String sex, String tel, String address){
		userconn=JDBCLink.getConn();
		try {
			statement=userconn.createStatement();
			String sql="insert into t_purchase values("+"'"+name+"',"+"'"+people+"',"+"'"+sex+"',"+"'"+tel+"',"+"'"+address+"')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			this.close();
		}
	}
	
	//�����½������̵ķ���
	public void AddSell(String name, String people, String sex, String tel, String address){
		userconn=JDBCLink.getConn();
		try {
			statement=userconn.createStatement();
			String sql="insert into t_sell values("+"'"+name+"',"+"'"+people+"',"+"'"+sex+"',"+"'"+tel+"',"+"'"+address+"')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			this.close();
		}
	}
	//����Ƿ��Ѿ��д˲ɹ���
	public Boolean Check_Purchase(String name){
		userconn=JDBCLink.getConn();
		try {
			statement=userconn.createStatement();
			String sql="select *from t_purchase where companyname="+"'"+name+"'";
			rs=statement.executeQuery(sql);
			int m=0;
			rs.last();
			m=rs.getRow();
			rs.beforeFirst();
			if(m==0){
				return false;
			}else{
				while(rs.next()){
				if(name.equals(rs.getString(1))){
					aboolean=true;
				}else 
					aboolean=false;
				}
			}
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return aboolean;
	}
	//����Ƿ��Ѿ��д�������
		public Boolean Check_Sell(String name){
			userconn=JDBCLink.getConn();
			try {
				statement=userconn.createStatement();
				String sql="select *from t_sell where companyname="+"'"+name+"'";
				rs=statement.executeQuery(sql);
				int n=0;
				rs.last();
				n=rs.getRow();
				rs.beforeFirst();
				if(n==0){
					return false;
				}else{
					while(rs.next()){
					if(name.equals(rs.getString(1))){
						aboolean=true;
					}else 
						aboolean=false;
					}
				}
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			finally{
				this.close();
			}
			return aboolean;
			
		}
}
