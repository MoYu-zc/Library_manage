package my_Link;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stock_Link {
	private Boolean aBoolean= null;
    private  Connection userconn=null;
    private  Statement statement =null;
    private  ResultSet rs=null,rs1=null;
    private  int purchase=0,sell=0,stock=0,a,b;
    
    //创建关闭数据库资源的方法
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
    
    //创建将图书信息加入库存表的方法
    public void AddBook_Stock(String isbn,String name,String author,String translator,String press,String classification,double pricing,int number){
    	userconn=JDBCLink.getConn();
    	try {
			statement=userconn.createStatement();
			String sql="insert into t_stock values("+"'"+isbn+"',"+"'"+name+"',"+"'"+author+"',"+"'"+translator+"',"+"'"+press+"',"+"'"+classification+"',"+"'"+pricing+"',"+"'"+number+"')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
    
    
    
    //创建更新库存方法
    public void Update_Stock(String isbn){
    	 
    	userconn=JDBCLink.getConn();
    	try{
    		statement=userconn.createStatement();
    		String sql="select *from t_purchasebook where isbn="+isbn;
    		rs=statement.executeQuery(sql);
    		int m=0;
    		rs.last();
    		m=rs.getRow();
    		rs.beforeFirst();
    		if(m==0){
    			purchase=0;
    		}else{
    			while(rs.next()){
    			purchase=Integer.parseInt(rs.getString(9))+purchase;
    			}
    		}System.out.println("purchase="+purchase);
    		String sql1="select *from t_sellbook where isbn="+isbn;
    		rs1=statement.executeQuery(sql1);
    		int n=0;
    		rs1.last();
    		n=rs1.getRow();
    		rs1.beforeFirst();
    		if(n==0){
    			sell=0;
    		}else{
    			while(rs1.next()){
    			sell=Integer.parseInt(rs1.getString(9))+sell;
    			}
    		}
    		stock=purchase-sell;
    		String sql2="Update t_stock set number="+"'"+stock+"'where isbn="+isbn;
    		statement.executeUpdate(sql2);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		this.close();
    	}
    }
    
    //创建检查库存的方法
    public Boolean Check_Stock(String isbn,int number){
    	userconn=JDBCLink.getConn();
    	try {
			statement=userconn.createStatement();
			String sql="select *from t_stock where isbn="+isbn;
			int a=0;
			rs=statement.executeQuery(sql);
			while(rs.next()){
				a=Integer.parseInt(rs.getString(8));
			}
			if(a<number){
				aBoolean=false;
			}else{
				aBoolean=true;
			}
			System.out.println(a);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.close();
		}
    	return aBoolean;
    }


//报警数量判断
public Boolean baojing(String isbn,int number) {
	userconn=JDBCLink.getConn();
	try {
		statement=userconn.createStatement();
		String sql="select *from t_clarm where isbn="+isbn;
		rs=statement.executeQuery(sql);
		while (rs.next()) {
			 a=Integer.parseInt(rs.getString(3));
		}
		String sql1="select *from t_stock where isbn="+isbn;
		rs=statement.executeQuery(sql1);
		while(rs.next()){
			 b=Integer.parseInt(rs.getString(8));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		this.close();
	}
	if((b-number)<=a) {
		aBoolean=false;
	}else {
		aBoolean=true;
	}
	
	
	return aBoolean;
}

}





