package my_Link;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sell_Link {
	private Boolean aBoolean= null;
    private  Connection userconn=null;
    private  Statement statement =null;
    private  ResultSet rs =null;
    
  //创建关闭数据库资源方法
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
    
    //创建添加新销售的方法
    public void AddSellBook(String no_sell, String isbn, String name, String author, String translator, String press, String classification, double pricing, int number, double money, String selldate, String people){
    	userconn=JDBCLink.getConn();
    	try {
			statement=userconn.createStatement();
			String sql="insert into t_sellbook values("+"'"+no_sell+"',"+"'"+isbn+"',"+"'"+name+"',"+"'"+author+"',"+"'"+translator+"',"+"'"+press+"',"+"'"+classification+"',"+"'"+pricing+"',"+"'"+number+"',"+"'"+money+"',"+"'"+selldate+"',"+"'"+people+"')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	finally{
    		this.close();
    	}
    }
    
    //创建检查销售单号的方法
    public Boolean Check_NO(String no){
    	userconn=JDBCLink.getConn();
    	try {
			statement=userconn.createStatement();
			String sql="select *from t_sellbook";
			rs=statement.executeQuery(sql);
			int m=0;
			rs.last();
			m=rs.getRow();
			rs.beforeFirst();
			if(m==0){
				aBoolean=true;
			}else{
				while(rs.next()){
				if(no.equals(rs.getString(1))){
					aBoolean=false;
				}else{
					aBoolean=true;
				}
			}
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.close();
		}
    	return aBoolean;
    }
}
