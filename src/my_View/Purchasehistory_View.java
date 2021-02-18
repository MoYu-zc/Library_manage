package my_View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import my_Link.JDBCLink;
import my_excel.Purchase_history_excel;

public class Purchasehistory_View extends JPanel implements ActionListener {
	private JTextField search;
	private JButton Search,output;
	private JLabel searchl,bt;   //标签：按月查询，标题
	private JPanel p1,p2,p3;
	
	private  Connection userconn=null,userconn1=null;
	private  Statement statement =null,statement1=null;
	private  ResultSet rs =null, rs1=null;
	    
//	private String[]s1={};
	private JTable purchase_history;
	
	public Purchasehistory_View(){
		this.setLayout(null);
		this.setBounds(0, 0, 924, 541);
		
		this.setVisible(true);
		this.setOpaque(false);     //设置面板透明
		
		//添加面板
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 919, 536);
		p1.setOpaque(false);
//		p1.setBorder(BorderFactory.createTitledBorder(""));
		
		bt=new JLabel("历史采购查询");
		bt.setFont(new Font("华文仿宋",Font.BOLD,22));
		bt.setBounds(405, 0, 150, 25);
		p1.add(bt);
		
		//添加查询提示
		searchl=new JLabel("请输入您要查询的月份：");
		searchl.setFont(new Font("华文仿宋",Font.BOLD,20));
		searchl.setBounds(140, 40, 370, 25);
		p1.add(searchl);
		
		search=new JTextField();
		search.setFont(new Font("华文仿宋",Font.BOLD,20));
		search.setBounds(380, 40, 180, 29);
		p1.add(search);
		
		Search=new JButton("查询");
		Search.setFont(new Font("华文仿宋",Font.BOLD,16));
		Search.setBounds(611, 38, 80, 30);
		Search.addActionListener(this);
		p1.add(Search);
		
		
		
		output=new JButton("导出");
		output.setFont(new Font("华文仿宋",Font.BOLD,16));
		output.setBounds(741, 38, 80, 30);
		output.addActionListener(this);
		p1.add(output);
		
		
		p3=new JPanel();
		p3.setLayout(null);
        p3.setBounds(0, 90, 916, 506);
        p3.setOpaque(false);        //设置面板透明
        p3.setVisible(true);
		
		
		
		p2=new JPanel();
		p2.setLayout(null);
        p2.setBounds(5, 90, 916, 506);
        p2.setOpaque(false);        //设置面板透明
        p2.setVisible(true);
		
		
		//添加全部表格
	
		
		
		this.add(p1);
		this.add(p2);
		
	}
	
	//创建方法，设置列宽
	public  void setColumnSize(JTable table, int i, int preferedWidth){
		//表格的列模型
		TableColumnModel cm = table.getColumnModel();
		//得到第i个列对象 
		TableColumn column = cm.getColumn(i);  
		column.setPreferredWidth(preferedWidth);
		}
	//创建关闭数据库
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==Search){
			Connection userconn=null;
			Statement statement=null;
			ResultSet rs =null;
			userconn=JDBCLink.getConn();
			try {
				statement=userconn.createStatement();
				String sql="select *from t_purchasebook where purchasedate like '____"+search.getText()+"%'";
				rs=statement.executeQuery(sql);
				while(rs.next()){
					rs.last();
					int n=rs.getRow();
					if(n==0){
						JOptionPane.showMessageDialog(this, "此月无采购信息！");
					}
					rs.beforeFirst();
					String s1[][]=new String[n][16];
					for(int i=0;i<n&&rs.next();i++){
						s1[i][0]=rs.getString(1);
						s1[i][1]=rs.getString(2);
						s1[i][2]=rs.getString(3);
						s1[i][3]=rs.getString(4);
						s1[i][4]=rs.getString(5);
						s1[i][5]=rs.getString(6);
						s1[i][6]=rs.getString(7);
						s1[i][7]=rs.getString(8);
						s1[i][8]=rs.getString(9);
						s1[i][9]=rs.getString(10);
						s1[i][10]=rs.getString(11);
						s1[i][11]=rs.getString(12);
						s1[i][12]=rs.getString(13);
						s1[i][13]=rs.getString(14);
						s1[i][14]=rs.getString(15);
					}
					String s[]={"采购单号","图书ISBN","图书名称","作者","翻译者","出版社","图书类型","定价","数量","总额","采购时间","供货商","货架","货号","经办人"};
					purchase_history=new JTable(s1,s);
					purchase_history.setSize(900, 400);
					purchase_history.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					purchase_history.setRowHeight(25);               //设置行高
					JScrollPane jspane=new JScrollPane(purchase_history);
					jspane.setBounds(0, 90, 916, 450);
					//设置列宽
					this.setColumnSize(purchase_history,0,90);
					this.setColumnSize(purchase_history,1,109);
					this.setColumnSize(purchase_history,2,125);
					this.setColumnSize(purchase_history,3,90);
					this.setColumnSize(purchase_history,4,65);
					this.setColumnSize(purchase_history,5,110);
					this.setColumnSize(purchase_history,7,70);
					this.setColumnSize(purchase_history,8,42);
					this.setColumnSize(purchase_history,10,80);
					this.setColumnSize(purchase_history,11,80);
					this.setColumnSize(purchase_history,12,50);
					this.setColumnSize(purchase_history,13,50);
					this.setColumnSize(purchase_history,14,50);

					this.add(jspane);
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
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
			} catch (SQLException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
				}	
		}
		if(e.getSource()==output){
			try {
				Purchase_history_excel.main_export();
				JOptionPane.showMessageDialog(this, "历史采购表已导出至D盘！");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}
}
