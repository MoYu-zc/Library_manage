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
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import my_Link.JDBCLink;
import my_Link.People_Link;
import my_Link.Purchase_Link;
import my_Link.Stock_Link;

public class NewTest_Purchase_new_View extends JPanel implements ActionListener,MouseListener{
	//定义标签  标题，isbn，名字，作者，翻译者，出版社，出版时间，图书类别，定价
	private JLabel bt,isbn,name,author,translator,press,publicationdate,classification,pricing;
	//定义文本框  ISBN，书名，作者，翻译者，出版社，出版时间，定价
	private JTextField ISBN,Name,Author,Translator,Press,Publicationdate,Pricing;
	//定义下拉框  图书类别
	private JComboBox Classification;
	//定义按钮  提交，清除
	private JButton submit,clear,search;
	//定义标签  采购单编号，采购数量，采购金额，采购日期，供货商，经办人，库号，货架
	private JLabel id,number,money,date,pname,people,storehousenumber,shelves;
	//定义文本框   采购单编号，采购数量，采购金额，采购日期，供货商，经办人，库号，货架
	private JTextField ID,Number,Money,Date,Pname,People,Storehousenumber,Shelves;
	//定义三个面板存标题图片，存放图书信息和采购信息
	private JPanel p1,p2,p3;
	String sdate;
	
	public NewTest_Purchase_new_View(){
//		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setBounds(0, 0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);        //设置面板透明
		
//		//实时时间显示
//		TimerTask task = new TimerTask(){
//        	public void run(){
//	        	sdate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
////	        	tdate = (new SimpleDateFormat("HH : mm : ss     EEEE")).format(new Date());
//        	}
//        };
//		Timer t = new Timer();
//        t.scheduleAtFixedRate(task, new Date(), 1000);
        
		
		//添加面板_添加新采购
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420, 0, 919, 30);
//		p1.setBackground(null);     
		p1.setOpaque(false);        //设置面板透明
		
		bt=new JLabel("添加新采购");
		bt.setFont(new Font("华文仿宋",Font.BOLD,22));
		bt.setBackground(Color.gray);
		bt.setBounds(0, 0, 150, 25);
		p1.add(bt);
		this.add(p1);
		
		//添加面板_图书信息
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(5, 30, 919, 220);
		p2.setBorder(new TitledBorder(null, "图书信息", TitledBorder.LEADING, TitledBorder.TOP, null));
		p2.setOpaque(false);        //设置面板透明
		
		isbn=new JLabel(" I S B N");
		isbn.setBounds(100, 40, 100, 20);
		isbn.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(isbn);
		
		ISBN=new JTextField();
		ISBN.setBounds(190, 40, 180, 24);
		ISBN.setFont(new Font("华文仿宋",0,16));
		p2.add(ISBN);
		
		name=new JLabel("图书名字");
		name.setBounds(510, 40, 150, 20);
		name.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(name);
		
		Name=new JTextField();
		Name.setBounds(610, 40, 180, 24);
		Name.setFont(new Font("华文仿宋",0,16));
		p2.add(Name);
		
		author=new JLabel("作     者");
		author.setBounds(100, 80, 150, 28);
		author.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(author);
		
		Author=new JTextField();
		Author.setBounds(190, 80, 180, 28);
		Author.setFont(new Font("华文仿宋",0,16));
		p2.add(Author);
		
		translator=new JLabel("翻 译 者");
		translator.setBounds(510, 80, 150, 28);
		translator.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(translator);
		
		Translator=new JTextField();
		Translator.setBounds(610, 80, 180, 28);
		Translator.setFont(new Font("华文仿宋",0,16));
		p2.add(Translator);
		
		press=new JLabel("出 版 社");
		press.setBounds(100, 120, 150, 28);
		press.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(press);
		
		Press=new JTextField();
		Press.setBounds(190, 120, 180, 28);
		Press.setFont(new Font("华文仿宋",0,16));
		p2.add(Press);
		
		publicationdate=new JLabel("出版时间");
		publicationdate.setBounds(510, 120, 150, 28);
		publicationdate.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(publicationdate);
		
		Publicationdate=new JTextField();
		Publicationdate.setBounds(610, 120, 180, 28);
		Publicationdate.setFont(new Font("华文仿宋",0,16));
		p2.add(Publicationdate);
		
		classification=new JLabel("图书类别");
		classification.setBounds(100, 160, 150, 28);
		classification.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(classification);
		
		Classification=new JComboBox<String>();
		Classification.setModel(new DefaultComboBoxModel(new String[] {"==请选择==", "童书", "教辅", "小说", "文学", "青春文学", "传记", "管理", "历史", "网络文学", "哲学宗教", "保健养生", "考试","计算机"}));
		Classification.setBounds(190, 160, 180, 28);
		Classification.setFont(new Font("华文仿宋",0,16));
	    p2.add(Classification);
		
		pricing=new JLabel("定      价");
		pricing.setBounds(510, 160, 150, 28);
		pricing.setFont(new Font("华文仿宋",Font.BOLD,16));
		p2.add(pricing);
		
		Pricing=new JTextField();
		Pricing.setBounds(610, 160, 180, 28);
		Pricing.setFont(new Font("华文仿宋",0,16));
		p2.add(Pricing);
		
		this.add(p2);
		
		//添加面板_采购单信息
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBounds(5, 260,919, 220);
		p3.setBorder(new TitledBorder(null, "采购单信息", TitledBorder.LEADING, TitledBorder.TOP, null));
		p3.setOpaque(false);        //设置面板透明
		
		id=new JLabel("采购单编号");
		id.setFont(new Font("华文仿宋",Font.BOLD,16));
		id.setBounds(100, 40, 100, 20);
		p3.add(id);
		
		ID=new JTextField();
		ID.setFont(new Font("华文仿宋",0,16));
		ID.setBounds(190, 40, 180, 24);
		p3.add(ID);
		
		number=new JLabel("采购数量");
		number.setFont(new Font("华文仿宋",Font.BOLD,16));
		number.setBounds(510, 40, 150, 20);
		p3.add(number);
		 
		Number=new JTextField();
		Number.setFont(new Font("华文仿宋",0,16));
		Number.setBounds(610, 40, 180, 24);
		p3.add(Number);
		
		money=new JLabel("采购金额");
		money.setFont(new Font("华文仿宋",Font.BOLD,16));
		money.setBounds(100, 80, 150, 28);
		p3.add(money);
		
		Money=new JTextField();
		Money.setFont(new Font("华文仿宋",0,16));
		Money.setBounds(190, 80, 180, 28);
		p3.add(Money);
		Money.addMouseListener(this);
		
		date=new JLabel("采购时间");
		date.setFont(new Font("华文仿宋",Font.BOLD,16));
		date.setBounds(510, 80, 150, 28);
		p3.add(date);
		
		Date=new JTextField();
		Date.setFont(new Font("华文仿宋",0,16));
		Date.setBounds(610, 80, 180, 28);
		Date.setText((new SimpleDateFormat("yyyyMMdd")).format(new   java.util.Date()));
		p3.add(Date);
		
		pname=new JLabel("供货商名称");
		pname.setFont(new Font("华文仿宋",Font.BOLD,16));
		pname.setBounds(100, 120, 150, 28);
		p3.add(pname);
		
		Pname=new JTextField();
		Pname.setFont(new Font("华文仿宋",0,16));
		Pname.setBounds(190, 120, 180, 28);
		p3.add(Pname);
		
		storehousenumber=new JLabel("库        号");
		storehousenumber.setFont(new Font("华文仿宋",Font.BOLD,16));
		storehousenumber.setBounds(510, 120, 150, 28);
		p3.add(storehousenumber);
		
		Storehousenumber=new JTextField();
		Storehousenumber.setFont(new Font("华文仿宋",0,16));
		Storehousenumber.setBounds(610, 120, 180, 28);
		p3.add(Storehousenumber);
		
		shelves=new JLabel("货        架");
		shelves.setFont(new Font("华文仿宋",Font.BOLD,16));
		shelves.setBounds(100, 160, 150, 28);
		p3.add(shelves);
		
		Shelves=new JTextField();
		Shelves.setFont(new Font("华文仿宋",0,16));
		Shelves.setBounds(190, 160, 180, 28);
		p3.add(Shelves);
		
		people=new JLabel("经  办  人");
		people.setFont(new Font("华文仿宋",Font.BOLD,16));
		people.setBounds(510, 160, 150, 28);
		p3.add(people);
		
		People=new JTextField();
		People.setFont(new Font("华文仿宋",0,16));
		People.setBounds(610, 160, 180, 28);
		p3.add(People);
		
		this.add(p3);
	
		//添加按钮
		
		search=new JButton("查询");
		search.setFont(new Font("华文仿宋",0,16));
		search.setBounds(240, 490, 68, 40);
		search.addActionListener(this);
		this.add(search);
		
		submit=new JButton("提交");
		submit.setFont(new Font("华文仿宋",0,16));
		submit.setBounds(445, 490, 68, 40);
		submit.addActionListener(this);
		this.add(submit);
		
		clear=new JButton("清除");
		clear.setFont(new Font("华文仿宋",0,16));
		clear.setBounds(650, 490, 68, 40);
		clear.addActionListener(this);
		this.add(clear);
		

		
	}
	public void Clear(){
		ISBN.setText("");
		Name.setText("");
		Author.setText("");
		Translator.setText("");
		Press.setText("");
		Publicationdate.setText("");
		Pricing.setText("");
		ID.setText("");
		Number.setText("");
		Money.setText("");
		Pname.setText("");
		People.setText("");
		Storehousenumber.setText("");
		Shelves.setText("");
		Date.setText((new SimpleDateFormat("yyyyMMdd")).format(new   java.util.Date()));
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
						String g=rs.getString(6);       //获取数据库中的出版时间
						String f=rs.getString(8);       //获取数据库中的价格
						String m=rs.getString(7);       //获取数据库中的类别
						Name.setText(a);
						Author.setText(b);
						Translator.setText(c);
						Press.setText(d);
						Publicationdate.setText(g);
						Pricing.setText(f);
						Classification.setSelectedItem(m);
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
			Purchase_Link A=new Purchase_Link();        //链接添加、检查图书信息以及添加采购信息
			Stock_Link S=new Stock_Link();
			Boolean tBoolean=A.CheckBook(ISBN.getText());
			Boolean p=A.Check_purchasebook(ID.getText());
			if(Integer.parseInt(Number.getText())==0){
				JOptionPane.showMessageDialog(this, "采购数量不能为0！");
				Number.setText("");
			}else{
				if(tBoolean==false){
					if(p){
						JOptionPane.showMessageDialog(this,"该销售单号已存在");
						ID.setText("");
						
					}else{
							System.out.println("11111111111");
							A.AddBookMessage(ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), Publicationdate.getText(), (String)Classification.getSelectedItem(), Double.parseDouble(Pricing.getText()));
							A.AddPurchaseMessage(ID.getText(),ISBN.getText(),Name.getText(),Author.getText(),Translator.getText(),Press.getText(),(String)Classification.getSelectedItem(),Double.parseDouble(Pricing.getText()),Integer.parseInt(Number.getText()),Double.parseDouble(Money.getText()),Date.getText(),Pname.getText(),Storehousenumber.getText(),Shelves.getText(),People.getText());
							S.AddBook_Stock(ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), (String)Classification.getSelectedItem(), Double.parseDouble(Pricing.getText()), Integer.parseInt(Number.getText()));
							S.Update_Stock(ISBN.getText());
							JOptionPane.showMessageDialog(this, "信息添加成功！");
							this.Clear();
						}
					}
				else{
					if(p){
						JOptionPane.showMessageDialog(this,"该销售单号已存在");
						ID.setText("");
					}else{
						A.AddPurchaseMessage(ID.getText(),ISBN.getText(),Name.getText(),Author.getText(),Translator.getText(),Press.getText(),(String)Classification.getSelectedItem(),Double.parseDouble(Pricing.getText()),Integer.parseInt(Number.getText()),Double.parseDouble(Money.getText()),Date.getText(),Pname.getText(),Storehousenumber.getText(),Shelves.getText(),People.getText());
						S.Update_Stock(ISBN.getText());
						JOptionPane.showMessageDialog(this, "信息添加成功！");
						this.Clear();
						}
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
