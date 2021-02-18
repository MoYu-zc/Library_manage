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
	//�����ǩ  ���⣬isbn�����֣����ߣ������ߣ������磬����ʱ�䣬ͼ����𣬶���
	private JLabel bt,isbn,name,author,translator,press,publicationdate,classification,pricing;
	//�����ı���  ISBN�����������ߣ������ߣ������磬����ʱ�䣬����
	private JTextField ISBN,Name,Author,Translator,Press,Publicationdate,Pricing;
	//����������  ͼ�����
	private JComboBox Classification;
	//���尴ť  �ύ�����
	private JButton submit,clear,search;
	//�����ǩ  �ɹ�����ţ��ɹ��������ɹ����ɹ����ڣ������̣������ˣ���ţ�����
	private JLabel id,number,money,date,pname,people,storehousenumber,shelves;
	//�����ı���   �ɹ�����ţ��ɹ��������ɹ����ɹ����ڣ������̣������ˣ���ţ�����
	private JTextField ID,Number,Money,Date,Pname,People,Storehousenumber,Shelves;
	//���������������ͼƬ�����ͼ����Ϣ�Ͳɹ���Ϣ
	private JPanel p1,p2,p3;
	String sdate;
	
	public NewTest_Purchase_new_View(){
//		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setBounds(0, 0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);        //�������͸��
		
//		//ʵʱʱ����ʾ
//		TimerTask task = new TimerTask(){
//        	public void run(){
//	        	sdate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
////	        	tdate = (new SimpleDateFormat("HH : mm : ss     EEEE")).format(new Date());
//        	}
//        };
//		Timer t = new Timer();
//        t.scheduleAtFixedRate(task, new Date(), 1000);
        
		
		//������_����²ɹ�
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420, 0, 919, 30);
//		p1.setBackground(null);     
		p1.setOpaque(false);        //�������͸��
		
		bt=new JLabel("����²ɹ�");
		bt.setFont(new Font("���ķ���",Font.BOLD,22));
		bt.setBackground(Color.gray);
		bt.setBounds(0, 0, 150, 25);
		p1.add(bt);
		this.add(p1);
		
		//������_ͼ����Ϣ
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(5, 30, 919, 220);
		p2.setBorder(new TitledBorder(null, "ͼ����Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null));
		p2.setOpaque(false);        //�������͸��
		
		isbn=new JLabel(" I S B N");
		isbn.setBounds(100, 40, 100, 20);
		isbn.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(isbn);
		
		ISBN=new JTextField();
		ISBN.setBounds(190, 40, 180, 24);
		ISBN.setFont(new Font("���ķ���",0,16));
		p2.add(ISBN);
		
		name=new JLabel("ͼ������");
		name.setBounds(510, 40, 150, 20);
		name.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(name);
		
		Name=new JTextField();
		Name.setBounds(610, 40, 180, 24);
		Name.setFont(new Font("���ķ���",0,16));
		p2.add(Name);
		
		author=new JLabel("��     ��");
		author.setBounds(100, 80, 150, 28);
		author.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(author);
		
		Author=new JTextField();
		Author.setBounds(190, 80, 180, 28);
		Author.setFont(new Font("���ķ���",0,16));
		p2.add(Author);
		
		translator=new JLabel("�� �� ��");
		translator.setBounds(510, 80, 150, 28);
		translator.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(translator);
		
		Translator=new JTextField();
		Translator.setBounds(610, 80, 180, 28);
		Translator.setFont(new Font("���ķ���",0,16));
		p2.add(Translator);
		
		press=new JLabel("�� �� ��");
		press.setBounds(100, 120, 150, 28);
		press.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(press);
		
		Press=new JTextField();
		Press.setBounds(190, 120, 180, 28);
		Press.setFont(new Font("���ķ���",0,16));
		p2.add(Press);
		
		publicationdate=new JLabel("����ʱ��");
		publicationdate.setBounds(510, 120, 150, 28);
		publicationdate.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(publicationdate);
		
		Publicationdate=new JTextField();
		Publicationdate.setBounds(610, 120, 180, 28);
		Publicationdate.setFont(new Font("���ķ���",0,16));
		p2.add(Publicationdate);
		
		classification=new JLabel("ͼ�����");
		classification.setBounds(100, 160, 150, 28);
		classification.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(classification);
		
		Classification=new JComboBox<String>();
		Classification.setModel(new DefaultComboBoxModel(new String[] {"==��ѡ��==", "ͯ��", "�̸�", "С˵", "��ѧ", "�ഺ��ѧ", "����", "����", "��ʷ", "������ѧ", "��ѧ�ڽ�", "��������", "����","�����"}));
		Classification.setBounds(190, 160, 180, 28);
		Classification.setFont(new Font("���ķ���",0,16));
	    p2.add(Classification);
		
		pricing=new JLabel("��      ��");
		pricing.setBounds(510, 160, 150, 28);
		pricing.setFont(new Font("���ķ���",Font.BOLD,16));
		p2.add(pricing);
		
		Pricing=new JTextField();
		Pricing.setBounds(610, 160, 180, 28);
		Pricing.setFont(new Font("���ķ���",0,16));
		p2.add(Pricing);
		
		this.add(p2);
		
		//������_�ɹ�����Ϣ
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBounds(5, 260,919, 220);
		p3.setBorder(new TitledBorder(null, "�ɹ�����Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null));
		p3.setOpaque(false);        //�������͸��
		
		id=new JLabel("�ɹ������");
		id.setFont(new Font("���ķ���",Font.BOLD,16));
		id.setBounds(100, 40, 100, 20);
		p3.add(id);
		
		ID=new JTextField();
		ID.setFont(new Font("���ķ���",0,16));
		ID.setBounds(190, 40, 180, 24);
		p3.add(ID);
		
		number=new JLabel("�ɹ�����");
		number.setFont(new Font("���ķ���",Font.BOLD,16));
		number.setBounds(510, 40, 150, 20);
		p3.add(number);
		 
		Number=new JTextField();
		Number.setFont(new Font("���ķ���",0,16));
		Number.setBounds(610, 40, 180, 24);
		p3.add(Number);
		
		money=new JLabel("�ɹ����");
		money.setFont(new Font("���ķ���",Font.BOLD,16));
		money.setBounds(100, 80, 150, 28);
		p3.add(money);
		
		Money=new JTextField();
		Money.setFont(new Font("���ķ���",0,16));
		Money.setBounds(190, 80, 180, 28);
		p3.add(Money);
		Money.addMouseListener(this);
		
		date=new JLabel("�ɹ�ʱ��");
		date.setFont(new Font("���ķ���",Font.BOLD,16));
		date.setBounds(510, 80, 150, 28);
		p3.add(date);
		
		Date=new JTextField();
		Date.setFont(new Font("���ķ���",0,16));
		Date.setBounds(610, 80, 180, 28);
		Date.setText((new SimpleDateFormat("yyyyMMdd")).format(new   java.util.Date()));
		p3.add(Date);
		
		pname=new JLabel("����������");
		pname.setFont(new Font("���ķ���",Font.BOLD,16));
		pname.setBounds(100, 120, 150, 28);
		p3.add(pname);
		
		Pname=new JTextField();
		Pname.setFont(new Font("���ķ���",0,16));
		Pname.setBounds(190, 120, 180, 28);
		p3.add(Pname);
		
		storehousenumber=new JLabel("��        ��");
		storehousenumber.setFont(new Font("���ķ���",Font.BOLD,16));
		storehousenumber.setBounds(510, 120, 150, 28);
		p3.add(storehousenumber);
		
		Storehousenumber=new JTextField();
		Storehousenumber.setFont(new Font("���ķ���",0,16));
		Storehousenumber.setBounds(610, 120, 180, 28);
		p3.add(Storehousenumber);
		
		shelves=new JLabel("��        ��");
		shelves.setFont(new Font("���ķ���",Font.BOLD,16));
		shelves.setBounds(100, 160, 150, 28);
		p3.add(shelves);
		
		Shelves=new JTextField();
		Shelves.setFont(new Font("���ķ���",0,16));
		Shelves.setBounds(190, 160, 180, 28);
		p3.add(Shelves);
		
		people=new JLabel("��  ��  ��");
		people.setFont(new Font("���ķ���",Font.BOLD,16));
		people.setBounds(510, 160, 150, 28);
		p3.add(people);
		
		People=new JTextField();
		People.setFont(new Font("���ķ���",0,16));
		People.setBounds(610, 160, 180, 28);
		p3.add(People);
		
		this.add(p3);
	
		//��Ӱ�ť
		
		search=new JButton("��ѯ");
		search.setFont(new Font("���ķ���",0,16));
		search.setBounds(240, 490, 68, 40);
		search.addActionListener(this);
		this.add(search);
		
		submit=new JButton("�ύ");
		submit.setFont(new Font("���ķ���",0,16));
		submit.setBounds(445, 490, 68, 40);
		submit.addActionListener(this);
		this.add(submit);
		
		clear=new JButton("���");
		clear.setFont(new Font("���ķ���",0,16));
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
						String g=rs.getString(6);       //��ȡ���ݿ��еĳ���ʱ��
						String f=rs.getString(8);       //��ȡ���ݿ��еļ۸�
						String m=rs.getString(7);       //��ȡ���ݿ��е����
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
			Purchase_Link A=new Purchase_Link();        //������ӡ����ͼ����Ϣ�Լ���Ӳɹ���Ϣ
			Stock_Link S=new Stock_Link();
			Boolean tBoolean=A.CheckBook(ISBN.getText());
			Boolean p=A.Check_purchasebook(ID.getText());
			if(Integer.parseInt(Number.getText())==0){
				JOptionPane.showMessageDialog(this, "�ɹ���������Ϊ0��");
				Number.setText("");
			}else{
				if(tBoolean==false){
					if(p){
						JOptionPane.showMessageDialog(this,"�����۵����Ѵ���");
						ID.setText("");
						
					}else{
							System.out.println("11111111111");
							A.AddBookMessage(ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), Publicationdate.getText(), (String)Classification.getSelectedItem(), Double.parseDouble(Pricing.getText()));
							A.AddPurchaseMessage(ID.getText(),ISBN.getText(),Name.getText(),Author.getText(),Translator.getText(),Press.getText(),(String)Classification.getSelectedItem(),Double.parseDouble(Pricing.getText()),Integer.parseInt(Number.getText()),Double.parseDouble(Money.getText()),Date.getText(),Pname.getText(),Storehousenumber.getText(),Shelves.getText(),People.getText());
							S.AddBook_Stock(ISBN.getText(), Name.getText(), Author.getText(), Translator.getText(), Press.getText(), (String)Classification.getSelectedItem(), Double.parseDouble(Pricing.getText()), Integer.parseInt(Number.getText()));
							S.Update_Stock(ISBN.getText());
							JOptionPane.showMessageDialog(this, "��Ϣ��ӳɹ���");
							this.Clear();
						}
					}
				else{
					if(p){
						JOptionPane.showMessageDialog(this,"�����۵����Ѵ���");
						ID.setText("");
					}else{
						A.AddPurchaseMessage(ID.getText(),ISBN.getText(),Name.getText(),Author.getText(),Translator.getText(),Press.getText(),(String)Classification.getSelectedItem(),Double.parseDouble(Pricing.getText()),Integer.parseInt(Number.getText()),Double.parseDouble(Money.getText()),Date.getText(),Pname.getText(),Storehousenumber.getText(),Shelves.getText(),People.getText());
						S.Update_Stock(ISBN.getText());
						JOptionPane.showMessageDialog(this, "��Ϣ��ӳɹ���");
						this.Clear();
						}
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
