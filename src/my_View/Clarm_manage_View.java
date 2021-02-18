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
	//�����ǩ   ���⣬isbn�����֣�����
	private JLabel bt,isbn,namel,numberl;
	//�����ı���  ISBN�����֣�����
	private JTextField ISBN,Name,Number;
	//���尴ť
	private JButton search,clear,submit,delete;
	//������壬�ֱ��ű���ͱ�����Ϣ����
	private JPanel p1,p2;
	
	public Clarm_manage_View(){
		this.setBounds(0, 0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);      //�������͸��
		
		//������_����
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420, 0, 919, 30);  
		p1.setOpaque(false);        //�������͸��
		
		bt=new JLabel("����±�����Ϣ");
		bt.setFont(new Font("���ķ���",Font.BOLD,22));
		bt.setBounds(0, 0, 180, 25);
		p1.add(bt);
		this.add(p1);
		
		//������_������Ϣ
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(5, 30, 919, 511);
		p2.setBorder(BorderFactory.createTitledBorder(""));
		p2.setOpaque(false);  
		
		isbn=new JLabel(" I S B N");
		isbn.setBounds(50, 160, 100, 24);
		isbn.setFont(new Font("���ķ���",Font.BOLD,18));
		p2.add(isbn);
		
		ISBN=new JTextField();
		ISBN.setBounds(130, 160, 180, 24);
		ISBN.setFont(new Font("���ķ���",0,18));
		p2.add(ISBN);
		
		namel=new JLabel("ͼ������");
		namel.setBounds(320, 160, 150, 24);
		namel.setFont(new Font("���ķ���",Font.BOLD,18));
		p2.add(namel);
		
		Name=new JTextField();
		Name.setBounds(405, 160, 180, 24);
		Name.setFont(new Font("���ķ���",0,18));
		p2.add(Name);
		
		numberl=new JLabel("��      ��");
		numberl.setBounds(600, 160, 150, 24);
		numberl.setFont(new Font("���ķ���",Font.BOLD,18));
		p2.add(numberl);
		
		Number=new JTextField();
		Number.setBounds(685, 160, 180, 24);
		Number.setFont(new Font("���ķ���",0,18));
		p2.add(Number);
		
		search=new JButton("��ѯ");
		search.setFont(new Font("���ķ���",0,18));
		search.setBounds(210, 300, 78, 40);
		search.addActionListener(this);
		this.add(search);
		
		submit=new JButton("�ύ");
		submit.setFont(new Font("���ķ���",0,18));
		submit.setBounds(350, 300, 78, 40);
		submit.addActionListener(this);
		this.add(submit);
				
		clear=new JButton("���");
		clear.setFont(new Font("���ķ���",0,18));
		clear.setBounds(490, 300, 78, 40);
		clear.addActionListener(this);
		this.add(clear);
		
		delete=new JButton("ɾ��");
		delete.setFont(new Font("���ķ���",0,18));
		delete.setBounds(630, 300, 78, 40);
		delete.addActionListener(this);
		this.add(delete);
		
		this.add(p2);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==submit){
			Clarm_Link A=new Clarm_Link();
			A.AddClarm(ISBN.getText(), Name.getText(), Integer.parseInt(Number.getText()));
			JOptionPane.showMessageDialog(this, "������Ϣ��ӳɹ���");
		}
		if(e.getSource()==clear){
			ISBN.setText("");
			Name.setText("");
			Number.setText("");
			JOptionPane.showMessageDialog(this,"�������");
		}
		if(e.getSource()==delete){
			Clarm_Link B=new Clarm_Link();
			B.DeleteClarm(ISBN.getText());
			JOptionPane.showMessageDialog(this, "ISBNΪ"+ISBN.getText()+"��ͼ�龯����Ϣ��ɾ����");
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
	}
















	private char[] String(String string) {
		// TODO �Զ����ɵķ������
		return null;
	}
}
