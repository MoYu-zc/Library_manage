package my_Link;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Purchase_Link {
	private Boolean aBoolean= null;
    private  Connection userconn=null;
    private  Statement statement =null;
    private  ResultSet rs =null;
    
    //�����ر����ݿ���Դ����
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
		}
	}
    //�������ͼ����Ϣ����
    public void AddBookMessage(String isbn, String name, String author, String translator, String press, String publicationdate, String classification, double pricing){
    	userconn=JDBCLink.getConn();
    	try{
    		Statement statement=userconn.createStatement();
    		String sql="insert into t_book values("+"'"+isbn+"',"+"'"+name+"',"+"'"+author+"',"+"'"+translator+"',"+"'"+press+"',"+"'"+publicationdate+"',"+"'"+classification+"',"+"'"+pricing+"')";
    		statement.executeUpdate(sql);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	finally{
    		this.close();
    	}
    }
    //��������Ƿ����ͼ����Ϣ�ķ���
    public Boolean CheckBook(String ISBN){
    	userconn=JDBCLink.getConn();
    	try {
    		statement =userconn.createStatement();
			String sql ="select * from t_book";
			 rs=statement.executeQuery(sql);
			 int m=0;
			 rs.last();
			 m=rs.getRow();
			 rs.beforeFirst();
			 if(m==0){
				 return false;
			 }else{
				  while(rs.next())
				{
					if(	ISBN.equals(rs.getString(1))==false) 
					{
						return false;	
					}
					else {
						return true;
					}
							
				}
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
    //������Ӳɹ�����Ϣ����
    public void AddPurchaseMessage(String no_p, String isbn,String name, String author, String translator, String press, String classification, double pricing, int number, double money, String purchasedate, String pname, String storehousenumber, String shelves, String people){
    	userconn=JDBCLink.getConn();
    	try {
			Statement statement=userconn.createStatement();
			String sql="insert into t_purchasebook values("+"'"+no_p+"',"+"'"+isbn+"',"+"'"+name+"',"+"'"+author+"',"+"'"+translator+"',"+"'"+press+"',"+"'"+classification+"',"+"'"+pricing+"',"+"'"+number+"',"+"'"+money+"',"+"'"+purchasedate+"',"+"'"+pname+"',"+"'"+storehousenumber+"',"+"'"+shelves+"',"+"'"+people+"')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    	finally{
    		this.close();
    	}
    }
    
    //����Ƿ��д˲ɹ�����
    public Boolean Check_purchasebook(String no){
    	userconn=JDBCLink.getConn();
    	try {
			statement=userconn.createStatement();
			String sql="select *from t_purchasebook where no_p="+"'"+no+"'";
			rs=statement.executeQuery(sql);
			int n=0;
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
			if(n==0){
				return false;
			}else{
				while(rs.next()){
				if(no.equals(rs.getString(1))){
					aBoolean=true;
				}
				else{
					aBoolean=false;
				}
			}
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

















