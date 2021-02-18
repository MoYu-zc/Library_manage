package my_View;

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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import my_Link.JDBCLink;
import my_excel.Purchase_history_excel;
import my_excel.Stock_excel;

public class Stock_View extends JPanel implements ActionListener {
	private JTextField search;
	private JButton Search,output;
	private JLabel searchl,bt;   //标签：按月查询，标题
	private JPanel p1,p2;
	
	private String[]s1={};
	private JTable stock;
	
	public Stock_View(){
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
		
		bt=new JLabel("库存查询");
		bt.setFont(new Font("华文仿宋",Font.BOLD,22));
		bt.setBounds(405, 0, 150, 25);
		p1.add(bt);
		
		//添加查询提示
		searchl=new JLabel("请输入您要查询的书籍的ISBN：");
		searchl.setFont(new Font("华文仿宋",Font.BOLD,20));
		searchl.setBounds(1, 40, 300, 25);
		p1.add(searchl);
		
		search=new JTextField();
		search.setFont(new Font("华文仿宋",Font.BOLD,20));
		search.setBounds(295, 40, 180, 29);
		p1.add(search);
		
		Search=new JButton("查询");
		Search.setFont(new Font("华文仿宋",Font.BOLD,16));
		Search.setBounds(511, 38, 80, 30);
		Search.addActionListener(this);
		p1.add(Search);
		
		output=new JButton("导出");
		output.setFont(new Font("华文仿宋",Font.BOLD,16));
		output.setBounds(621, 38, 80, 30);
		output.addActionListener(this);
		p1.add(output);

		this.add(p1);
		
	}
	
	//创建方法，设置列宽
	public  void setColumnSize(JTable table, int i, int preferedWidth){
		//表格的列模型
		TableColumnModel cm = table.getColumnModel();
		//得到第i个列对象 
		TableColumn column = cm.getColumn(i);  
		column.setPreferredWidth(preferedWidth);
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
				String sql="select *from t_stock where isbn="+"'"+search.getText()+"'";
				rs=statement.executeQuery(sql);
				while(rs.next()){
					rs.last();
					int n=rs.getRow();
					if(n==0){
						JOptionPane.showMessageDialog(this, "您查询的图书无库存信息！");
					}
					rs.beforeFirst();
					String s1[][]=new String[n][9];
					for(int i=0;i<n&&rs.next();i++){
						s1[i][0]=rs.getString(1);
						s1[i][1]=rs.getString(2);
						s1[i][2]=rs.getString(3);
						s1[i][3]=rs.getString(4);
						s1[i][4]=rs.getString(5);
						s1[i][5]=rs.getString(6);
						s1[i][6]=rs.getString(7);
						s1[i][7]=rs.getString(8);
					}
					String s[]={"图书ISBN","图书名称","作者","翻译者","出版社","图书类别","定价","数量"};
					stock=new JTable(s1,s);
					stock.setSize(900, 400);
					stock.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					stock.setRowHeight(25);               //设置行高
					JScrollPane jspane=new JScrollPane(stock);
					jspane.setBounds(0, 90, 916, 450);
					//设置列宽
					this.setColumnSize(stock,0,139);
					this.setColumnSize(stock,1,155);
					this.setColumnSize(stock,2,90);
					this.setColumnSize(stock,3,95);
					this.setColumnSize(stock,4,134);
					this.setColumnSize(stock,5,120);
					this.setColumnSize(stock,6,90);
					this.setColumnSize(stock,7,90);

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
				Stock_excel.main_export();
				JOptionPane.showMessageDialog(this, "库存表已导出至D盘！");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}
}
