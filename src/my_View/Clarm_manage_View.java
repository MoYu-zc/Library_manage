package my_View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import my_Link.Clarm_Link;
import my_Link.JDBCLink;

public class Clarm_manage_View extends JPanel implements ActionListener {
	//定义标签   标题，isbn，名字，数量
	private JLabel bt,isbn,namel,numberl;
	//定义文本框  ISBN，名字，数量
	private JTextField ISBN,Name,Number;
	//定义按钮
	private JButton search,clear,submit,delete;
	//定义面板，分别存放标题和报警信息设置
	private JPanel p1,p2;
	
	public Clarm_manage_View(){
		this.setBounds(0, 0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);      //设置面板透明
		
		//添加面板_标题
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420, 0, 919, 30);  
		p1.setOpaque(false);        //设置面板透明
		
		bt=new JLabel("添加新报警信息");
		bt.setFont(new Font("华文仿宋",Font.BOLD,22));
		bt.setBounds(0, 0, 180, 25);
		p1.add(bt);
		this.add(p1);
		
		//添加面板_销售信息
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(5, 30, 919, 511);
		p2.setBorder(BorderFactory.createTitledBorder(""));
		p2.setOpaque(false);  
		
		isbn=new JLabel(" I S B N");
		isbn.setBounds(50, 160, 100, 24);
		isbn.setFont(new Font("华文仿宋",Font.BOLD,18));
		p2.add(isbn);
		
		ISBN=new JTextField();
		ISBN.setBounds(130, 160, 180, 24);
		ISBN.setFont(new Font("华文仿宋",0,18));
		p2.add(ISBN);
		
		namel=new JLabel("图书名字");
		namel.setBounds(320, 160, 150, 24);
		namel.setFont(new Font("华文仿宋",Font.BOLD,18));
		p2.add(namel);
		
		Name=new JTextField();
		Name.setBounds(405, 160, 180, 24);
		Name.setFont(new Font("华文仿宋",0,18));
		p2.add(Name);
		
		numberl=new JLabel("数      量");
		numberl.setBounds(600, 160, 150, 24);
		numberl.setFont(new Font("华文仿宋",Font.BOLD,18));
		p2.add(numberl);
		
		Number=new JTextField();
		Number.setBounds(685, 160, 180, 24);
		Number.setFont(new Font("华文仿宋",0,18));
		p2.add(Number);
		
		search=new JButton("查询");
		search.setFont(new Font("华文仿宋",0,18));
		search.setBounds(210, 300, 78, 40);
		search.addActionListener(this);
		this.add(search);
		
		submit=new JButton("提交");
		submit.setFont(new Font("华文仿宋",0,18));
		submit.setBounds(350, 300, 78, 40);
		submit.addActionListener(this);
		this.add(submit);
				
		clear=new JButton("清除");
		clear.setFont(new Font("华文仿宋",0,18));
		clear.setBounds(490, 300, 78, 40);
		clear.addActionListener(this);
		this.add(clear);
		
		delete=new JButton("删除");
		delete.setFont(new Font("华文仿宋",0,18));
		delete.setBounds(630, 300, 78, 40);
		delete.addActionListener(this);
		this.add(delete);
		
		this.add(p2);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==submit){
			Clarm_Link A=new Clarm_Link();
			A.AddClarm(ISBN.getText(), Name.getText(), Integer.parseInt(Number.getText()));
			JOptionPane.showMessageDialog(this, "报警信息添加成功！");
		}
		if(e.getSource()==clear){
			ISBN.setText("");
			Name.setText("");
			Number.setText("");
			JOptionPane.showMessageDialog(this,"已清除！");
		}
		if(e.getSource()==delete){
			Clarm_Link B=new Clarm_Link();
			B.DeleteClarm(ISBN.getText());
			JOptionPane.showMessageDialog(this, "ISBN为"+ISBN.getText()+"的图书警报信息已删除！");
		}
		if(e.getSource()==search){
			Connection userconn=null;
			Statement statement=null;
			ResultSet rs =null;
			userconn=JDBCLink.getConn();
			try {
				statement=userconn.createStatement();
				String sql="select *from t_clarm where isbn="+"'"+ISBN.getText()+"'";
				rs=statement.executeQuery(sql);
				
				while(rs.next())
				{
					String a=rs.getString(2);
					String b=rs.getString(3);
					Name.setText(a);
					Number.setText(b);
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
	}
















	private char[] String(String string) {
		// TODO 自动生成的方法存根
		return null;
	}
}
