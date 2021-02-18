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
	//�����ǩ  ���⣬���۵��ţ�isbn�����֣����ߣ������ߣ������磬ͼ�����ͣ����ۣ�����������ʱ�䣬�ܽ�������
	private JLabel bt,no,isbn,name,author,translator,press,classification,pricing,number,time,money,people;
	//�����ı��� ���۵��ţ�ISBN�����������ߣ������ߣ������磬ͼ�����ͣ����ۣ�����������ʱ�䣬�ܽ�������
	private JTextField NO,ISBN,Name,Author,Translator,Press,Classification,Pricing,Number,Time,Money,People;
	//���尴ť
	private JButton search,submit,clear;
	//����������壬�ֱ��ű��⣬������Ϣ
	private JPanel p1,p2;
	
	public Sell_new_View(){
		this.setBounds(0, 0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);      //�������͸��
		
		//������_����
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420, 0, 919, 30);  
		p1.setOpaque(false);        //�������͸��
		
		bt=new JLabel("���������");
		bt.setFont(new Font("���ķ���",Font.BOLD,22));
		bt.setBounds(0, 0, 150, 25);
		p1.add(bt);
		this.add(p1);
		
		//������_������Ϣ
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(5, 30, 919, 511);
		p2.setBorder(BorderFactory.createTitledBorder(""));
		p2.setOpaque(false);  
		
		no=new JLabel("���۵���");
		no.setBounds(100, 40, 100, 28);
		no.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(no);
		
		NO=new JTextField();
		NO.setBounds(190, 40, 180, 28);
		NO.setFont(new Font("���ķ���",0,20));
		p2.add(NO);
		
		isbn=new JLabel(" I S B N");
		isbn.setBounds(510, 40, 100, 28);
		isbn.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(isbn);
		
		ISBN=new JTextField();
		ISBN.setBounds(610, 40, 180, 28);
		ISBN.setFont(new Font("���ķ���",0,20));
		p2.add(ISBN);
		
		name=new JLabel("ͼ������");
		name.setBounds(100, 100, 150, 28);
		name.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(name);
		
		Name=new JTextField();
		Name.setBounds(190, 100, 180, 28);
		Name.setFont(new Font("���ķ���",0,20));
		p2.add(Name);
		
		author=new JLabel("��     ��");
		author.setBounds(510, 100, 150, 28);
		author.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(author);
		
		Author=new JTextField();
		Author.setBounds(610, 100, 180, 28);
		Author.setFont(new Font("���ķ���",0,20));
		p2.add(Author);
		
		translator=new JLabel("�� �� ��");
		translator.setBounds(100, 160, 150, 28);
		translator.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(translator);
		
		Translator=new JTextField();
		Translator.setBounds(190, 160, 180, 28);
		Translator.setFont(new Font("���ķ���",0,20));
		p2.add(Translator);
		
		press=new JLabel("�� �� ��");
		press.setBounds(510, 160, 150, 28);
		press.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(press);
		
		Press=new JTextField();
		Press.setBounds(610, 160, 180, 28);
		Press.setFont(new Font("���ķ���",0,20));
		p2.add(Press);
		
		classification=new JLabel("ͼ�����");
		classification.setBounds(100, 220, 150, 28);
		classification.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(classification);
		
		Classification=new JTextField();
		Classification.setBounds(190, 220, 180, 28);
		Classification.setFont(new Font("���ķ���",0,20));
	    p2.add(Classification);
		
	    pricing=new JLabel("��      ��");
		pricing.setBounds(510, 220, 150, 28);
		pricing.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(pricing);
		
		Pricing=new JTextField();
		Pricing.setBounds(610,220, 180, 28);
		Pricing.setFont(new Font("���ķ���",0,20));
		p2.add(Pricing);
		
		number=new JLabel("��      ��");
		number.setBounds(100, 280, 150, 28);
		number.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(number);
		
		Number=new JTextField();
		Number.setBounds(190, 280, 180, 28);
		Number.setFont(new Font("���ķ���",0,20));
		p2.add(Number);
		
		money=new JLabel("�����ܶ�");
		money.setBounds(510, 280, 150, 28);
		money.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(money);
		
		Money=new JTextField();
		Money.setBounds(610,280, 180, 28);
		Money.setFont(new Font("���ķ���",0,20));
		Money.addMouseListener(this);
		p2.add(Money);
		
		time=new JLabel("����ʱ��");
		time.setBounds(100, 340, 150, 28);
		time.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(time);
		
		Time=new JTextField();
		Time.setBounds(190, 340, 180, 28);
		Time.setFont(new Font("���ķ���",0,20));
		Time.setText((new SimpleDateFormat("yyyyMMdd")).format(new java.util.Date()));
		p2.add(Time);
		
		people=new JLabel("�� �� ��");
		people.setBounds(510, 340, 150, 28);
		people.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(people);
		
		People=new JTextField();
		People.setBounds(610, 340, 180, 28);
		People.setFont(new Font("���ķ���",0,20));
		p2.add(People);
		//��Ӱ�ť
		search=new JButton("��ѯ");
		search.setFont(new Font("���ķ���",0,18));
		search.setBounds(260, 460, 78, 40);
		search.addActionListener(this);
		this.add(search);
		
		submit=new JButton("�ύ");
		submit.setFont(new Font("���ķ���",0,18));
		submit.setBounds(400, 460, 78, 40);
		submit.addActionListener(this);
		this.add(submit);
				
		clear=new JButton("���");
		clear.setFont(new Font("���ķ���",0,18));
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
		// TODO �Զ����ɵķ������
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
					JOptionPane.showMessageDialog(this, "�޴�ͼ����Ϣ������ӣ�");
				}else{
					while(rs.next())
					{
						String a=rs.getString(2);       //��ȡ���ݿ��е�����
						String b=rs.getString(3);       //��ȡ���ݿ��е�����
						String c=rs.getString(4);       //��ȡ���ݿ��еķ�����
						String d=rs.getString(5);       //��ȡ���ݿ��еĳ�����
						String f=rs.getString(8);       //��ȡ���ݿ��еļ۸�
						String m=rs.getString(7);       //��ȡ���ݿ��е����
						Name.setText(a);
						Author.setText(b);
						Translator.setText(c);
						Press.setText(d);
						
						Pricing.setText(f);
						Classification.setText(m);
					}
				}
				
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
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
				JOptionPane.showMessageDialog(this, "������������Ϊ0��");
				Number.setText("");
			}else{
				if(b==false){
					JOptionPane.showMessageDialog(this, "�����۵����Ѵ��ڣ����������룡");
					NO.setText("");
				}else{
					if(a==false){
						JOptionPane.showMessageDialog(this, "����������������");
						Number.setText("");
					}else{
						
						if(c==false) {
							JOptionPane.showMessageDialog(this, "���澯��");
							A.AddSellBook(NO.getText(), ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), Classification.getText(), Double.parseDouble(Pricing.getText()), Integer.parseInt(Number.getText()), Double.parseDouble(Money.getText()), Time.getText(), People.getText());
							S.Update_Stock(ISBN.getText());
							this.Clear();
							JOptionPane.showMessageDialog(this, "������Ϣ����ӣ�");
						}
						
						else {	
						A.AddSellBook(NO.getText(), ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), Classification.getText(), Double.parseDouble(Pricing.getText()), Integer.parseInt(Number.getText()), Double.parseDouble(Money.getText()), Time.getText(), People.getText());
						S.Update_Stock(ISBN.getText());
						this.Clear();
						JOptionPane.showMessageDialog(this, "������Ϣ����ӣ�");
					}}
				}
			}
		}
		if(e.getSource()==clear){
			this.Clear();
			JOptionPane.showMessageDialog(this, "�������");
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	
	
}
