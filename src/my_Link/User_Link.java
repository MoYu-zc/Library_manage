package my_Link;

import java.sql.*;

import javax.swing.JOptionPane;

public class User_Link {
     private Boolean aBoolean= null;
     private  Connection userconn=null;
     private  Statement statement =null;
     private  Connection conn=null;
     private  Statement stat =null;
     private  ResultSet rs =null;
     private  Boolean a;
     
//     //���������鷽��
//     public Boolean CheckPassword()
     //������¼��鷽��
	public Boolean CheckUser(String us,String pa)
	{
		userconn=JDBCLink.getConn();
		try {
			 statement =userconn.createStatement();
			String sql ="select * from t_user";
			 rs=statement.executeQuery(sql);
			while(rs.next())
			{
			if(	us.equals(rs.getString(1))&& pa.equals(rs.getString(2))==false) 
				return false;	
			else if(us.equals(rs.getString(1))&& pa.equals(rs.getString(2))) 
				return true;	
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {
			this.close();
		}
	return false;
		
	}
	//����ע�᷽��
	public void ResgUser(String us,String pa)
	{
		userconn=JDBCLink.getConn();
		try {
			Statement statement =userconn.createStatement();
			String sql ="insert into t_user values("+"'"+us+"',"+"'"+pa+"')";

			statement.execute(sql);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {
			this.close();
		}
	}
	//����ע���鷽��
	public Boolean check(String us){
		userconn=JDBCLink.getConn();
		try{
			statement =userconn.createStatement();
			String sql ="select * from t_user";
			 rs=statement.executeQuery(sql);
			 while(rs.next())
				{
				if(us.equals(rs.getString(1))) 
					return true;	
				}
		}catch(SQLException e){
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {
			this.close();
		}
		return false;
	}
	private void close() {
		try{
			if(rs!=null){
				rs.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(userconn!=null){
				userconn.close();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}}
		
		 
		    public void add(String name,String password) throws SQLException {

		        conn=JDBCLink.getConn();
		        try {
		            stat=conn.createStatement();

		        String sql="insert into t_user values("+"'"+name+"',"+"'"+password+"')";
		        stat.executeUpdate(sql);

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
		            if(stat!=null){
		                stat.close();
		            }
		            if(conn!=null){
		                conn.close();
		            }
		        }
		    }

		    public boolean bo(String name){
		        conn=JDBCLink.getConn();
		        try {
		            stat = conn.createStatement();
		            String sql="select * from t_user";
		            rs=stat.executeQuery(sql);
		           while (rs.next()){
		               if(name.equals(rs.getString(1))){
		                   a=false;
		               }else {
		                   a=true;
		               }
		           }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return a;
		    }
	
	
//	public static void main(String[] agrs)
//	{
//		User_Link A=new User_Link();
////		System.out.println(A.CheckUser("1","0"));
////		A.check("1");
////		A.ResgUser("2","0");
//	}
//	
}
