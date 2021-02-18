package my_View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import my_Link.JDBCLink;
import my_Link.Sell_Link;
import my_Link.Stock_Link;


public class Sell_new_View extends JPanel implements ActionListener,MouseListener{
	//定义标签  标题，销售单号，isbn，名字，作者，翻译者，出版社，图书类型，卖价，数量，销售时间，总金额，经办人
	private JLabel bt,no,isbn,name,author,translator,press,classification,pricing,number,time,money,people;
	//定义文本框 销售单号，ISBN，书名，作者，翻译者，出版社，图书类型，卖价，数量，销售时间，总金额，经办人
	private JTextField NO,ISBN,Name,Author,Translator,Press,Classification,Pricing,Number,Time,Money,People;
	//定义按钮
	private JButton search,submit,clear;
	//定义两个面板，分别存放标题，销售信息
	private JPanel p1,p2;
	
	public Sell_new_View(){
		this.setBounds(0, 0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);      //设置面板透明
		
		//添加面板_标题
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420, 0, 919, 30);  
		p1.setOpaque(false);        //设置面板透明
		
		bt=new JLabel("添加新销售");
		bt.setFont(new Font("华文仿宋",Font.BOLD,22));
		bt.setBounds(0, 0, 150, 25);
		p1.add(bt);
		this.add(p1);
		
		//添加面板_销售信息
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(5, 30, 919, 511);
		p2.setBorder(BorderFactory.createTitledBorder(""));
		p2.setOpaque(false);  
		
		no=new JLabel("销售单号");
		no.setBounds(100, 40, 100, 28);
		no.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(no);
		
		NO=new JTextField();
		NO.setBounds(190, 40, 180, 28);
		NO.setFont(new Font("华文仿宋",0,20));
		p2.add(NO);
		
		isbn=new JLabel(" I S B N");
		isbn.setBounds(510, 40, 100, 28);
		isbn.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(isbn);
		
		ISBN=new JTextField();
		ISBN.setBounds(610, 40, 180, 28);
		ISBN.setFont(new Font("华文仿宋",0,20));
		p2.add(ISBN);
		
		name=new JLabel("图书名字");
		name.setBounds(100, 100, 150, 28);
		name.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(name);
		
		Name=new JTextField();
		Name.setBounds(190, 100, 180, 28);
		Name.setFont(new Font("华文仿宋",0,20));
		p2.add(Name);
		
		author=new JLabel("作     者");
		author.setBounds(510, 100, 150, 28);
		author.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(author);
		
		Author=new JTextField();
		Author.setBounds(610, 100, 180, 28);
		Author.setFont(new Font("华文仿宋",0,20));
		p2.add(Author);
		
		translator=new JLabel("翻 译 者");
		translator.setBounds(100, 160, 150, 28);
		translator.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(translator);
		
		Translator=new JTextField();
		Translator.setBounds(190, 160, 180, 28);
		Translator.setFont(new Font("华文仿宋",0,20));
		p2.add(Translator);
		
		press=new JLabel("出 版 社");
		press.setBounds(510, 160, 150, 28);
		press.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(press);
		
		Press=new JTextField();
		Press.setBounds(610, 160, 180, 28);
		Press.setFont(new Font("华文仿宋",0,20));
		p2.add(Press);
		
		classification=new JLabel("图书类别");
		classification.setBounds(100, 220, 150, 28);
		classification.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(classification);
		
		Classification=new JTextField();
		Classification.setBounds(190, 220, 180, 28);
		Classification.setFont(new Font("华文仿宋",0,20));
	    p2.add(Classification);
		
	    pricing=new JLabel("定      价");
		pricing.setBounds(510, 220, 150, 28);
		pricing.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(pricing);
		
		Pricing=new JTextField();
		Pricing.setBounds(610,220, 180, 28);
		Pricing.setFont(new Font("华文仿宋",0,20));
		p2.add(Pricing);
		
		number=new JLabel("数      量");
		number.setBounds(100, 280, 150, 28);
		number.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(number);
		
		Number=new JTextField();
		Number.setBounds(190, 280, 180, 28);
		Number.setFont(new Font("华文仿宋",0,20));
		p2.add(Number);
		
		money=new JLabel("销售总额");
		money.setBounds(510, 280, 150, 28);
		money.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(money);
		
		Money=new JTextField();
		Money.setBounds(610,280, 180, 28);
		Money.setFont(new Font("华文仿宋",0,20));
		Money.addMouseListener(this);
		p2.add(Money);
		
		time=new JLabel("销售时间");
		time.setBounds(100, 340, 150, 28);
		time.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(time);
		
		Time=new JTextField();
		Time.setBounds(190, 340, 180, 28);
		Time.setFont(new Font("华文仿宋",0,20));
		Time.setText((new SimpleDateFormat("yyyyMMdd")).format(new java.util.Date()));
		p2.add(Time);
		
		people=new JLabel("经 办 人");
		people.setBounds(510, 340, 150, 28);
		people.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(people);
		
		People=new JTextField();
		People.setBounds(610, 340, 180, 28);
		People.setFont(new Font("华文仿宋",0,20));
		p2.add(People);
		//添加按钮
		search=new JButton("查询");
		search.setFont(new Font("华文仿宋",0,18));
		search.setBounds(260, 460, 78, 40);
		search.addActionListener(this);
		this.add(search);
		
		submit=new JButton("提交");
		submit.setFont(new Font("华文仿宋",0,18));
		submit.setBounds(400, 460, 78, 40);
		submit.addActionListener(this);
		this.add(submit);
				
		clear=new JButton("清除");
		clear.setFont(new Font("华文仿宋",0,18));
		clear.setBounds(540, 460, 78, 40);
		clear.addActionListener(this);
		this.add(clear);
		
		this.add(p2);
		
		
	}
	
	public void Clear(){
		NO.setText("");
		ISBN.setText("");
		Name.setText("");
		Author.setText("");
		Translator.setText("");
		Press.setText("");
		Classification.setText("");
		Pricing.setText("");
		Number.setText("");
		Money.setText("");
		Time.setText((new SimpleDateFormat("yyyyMMdd")).format(new java.util.Date()));
		People.setText("");
	}
	
	
	
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==search){
			Connection userconn=null;
			Statement statement=null;
			ResultSet rs =null;
			userconn=JDBCLink.getConn();
			try {
				statement=userconn.createStatement();
				String sql="select *from t_book where isbn="+"'"+ISBN.getText()+"'";
				rs=statement.executeQuery(sql);
				rs.last();
				int n=0;
				n=rs.getRow();
				rs.beforeFirst();
				if(n==0){
					JOptionPane.showMessageDialog(this, "无此图书信息，请添加！");
				}else{
					while(rs.next())
					{
						String a=rs.getString(2);       //获取数据库中的书名
						String b=rs.getString(3);       //获取数据库中的作者
						String c=rs.getString(4);       //获取数据库中的翻译者
						String d=rs.getString(5);       //获取数据库中的出版社
						String f=rs.getString(8);       //获取数据库中的价格
						String m=rs.getString(7);       //获取数据库中的类别
						Name.setText(a);
						Author.setText(b);
						Translator.setText(c);
						Press.setText(d);
						
						Pricing.setText(f);
						Classification.setText(m);
					}
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
		
		if(e.getSource()==submit){
			Sell_Link A=new Sell_Link();
			Stock_Link S=new Stock_Link();
			Boolean a=null,b=null,c=null;
			a=S.Check_Stock(ISBN.getText(), Integer.parseInt(Number.getText()));
			b=A.Check_NO(NO.getText());
			c=S.baojing(ISBN.getText(), Integer.parseInt(Number.getText()));
		
			if(Integer.parseInt(Number.getText())==0){
				JOptionPane.showMessageDialog(this, "销售数量不能为0！");
				Number.setText("");
			}else{
				if(b==false){
					JOptionPane.showMessageDialog(this, "该销售单号已存在，请重新输入！");
					NO.setText("");
				}else{
					if(a==false){
						JOptionPane.showMessageDialog(this, "该书库存数量不够！");
						Number.setText("");
					}else{
						
						if(c==false) {
							JOptionPane.showMessageDialog(this, "警告警告");
							A.AddSellBook(NO.getText(), ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), Classification.getText(), Double.parseDouble(Pricing.getText()), Integer.parseInt(Number.getText()), Double.parseDouble(Money.getText()), Time.getText(), People.getText());
							S.Update_Stock(ISBN.getText());
							this.Clear();
							JOptionPane.showMessageDialog(this, "销售信息已添加！");
						}
						
						else {	
						A.AddSellBook(NO.getText(), ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), Classification.getText(), Double.parseDouble(Pricing.getText()), Integer.parseInt(Number.getText()), Double.parseDouble(Money.getText()), Time.getText(), People.getText());
						S.Update_Stock(ISBN.getText());
						this.Clear();
						JOptionPane.showMessageDialog(this, "销售信息已添加！");
					}}
				}
			}
		}
		if(e.getSource()==clear){
			this.Clear();
			JOptionPane.showMessageDialog(this, "已清除！");
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==Money){
			int q=Integer.parseInt(Number.getText());
			double p=Double.parseDouble(Pricing.getText());
			double m=q*p;
			String M=String.valueOf(m);
			Money.setText(M);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	
}
