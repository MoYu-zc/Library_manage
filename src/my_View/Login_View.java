package my_View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import Tchat.Chat;
import Tchat.Chatserver;
import my_Link.User_Link;


public class Login_View extends JFrame implements ActionListener,KeyListener{
	
	JTextField user;    //�����û����ı���
	private JPasswordField password;     //�������������
	private JButton login,register,clear;

	public String getUserName(){
		return user.getText();
	}
	
	public Login_View(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���õ������Ĺرհ�ť�ر�
		this.setTitle("���������ϵͳ");
		this.setSize(450, 325);
		this.setResizable(false);
		//���ô���ͼ��
		Image img0 = new ImageIcon("icon_001.png").getImage();
		this.setIconImage(img0);
		init();
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	public void init(){
			//����һ������
		Container container=this.getContentPane();
	
		
		//����һ���ܱ�ǩ
		JLabel Big=new JLabel();
		
		//���ñ���ͼƬ
		Image icon=new ImageIcon("res/��ɫ����.gif").getImage();
		Big.setIcon(new ImageIcon(icon));
		Big.setBounds(0, 0, 450, 325);
		
		//���ñ���ͼƬ
		JLabel btlb=new JLabel();
		Image bt=new ImageIcon("res/����.png").getImage();
		btlb.setIcon(new ImageIcon(bt));
		btlb.setBounds(37, 0, 433, 75);
		Big.add(btlb);
		
		
		
		//�����û�����ǩ���ı���
		JLabel userlb=new JLabel("�û���");
		userlb.setFont(new Font("����", Font.BOLD ,20));
		userlb.setBounds(55,90,100,50);
		Big.add(userlb);
		
		user=new JTextField("");
		user.setFont(new Font("����",Font.BOLD,20));
		user.setBounds(145, 100, 210, 30);
		user.setToolTipText("��������û���");
		Big.add(user);
		
		//���������ǩ�����������
		JLabel passwordlb=new JLabel("��  ��");
		passwordlb.setFont(new Font("����", Font.BOLD, 20));
		passwordlb.setBounds(55, 142, 100, 50);
		Big.add(passwordlb);
		
		password=new JPasswordField("");
		password.setFont(new Font("����", Font.BOLD, 15));
		password.setBounds(145, 150, 210, 30);
		password.setToolTipText("�����������");
		password.addKeyListener(this);
		Big.add(password);
		
		//���õ�¼��ť
		login=new JButton("��¼");
		login.setFont(new Font("����",Font.BOLD,20));
		login.setBounds(80, 200 , 90, 60);
		Big.add(login);
		login.setContentAreaFilled(false);   //���ð�ť͸��
		login.setBorderPainted(false);   //���ð�ť�ޱ߿�
		
		login.setToolTipText("��˵�¼");
		login.addActionListener(this);   //Ϊ��¼��ťע�������
		

		
		//����ע�ᰴť
		register=new JButton("ע��");
		register.setFont(new Font("����",Font.BOLD,20));
		register.setBounds(180, 200, 90, 60);
		Big.add(register);
		register.setContentAreaFilled(false);   //���ð�ť͸��
		register.setBorderPainted(false);   //���ð�ť�ޱ߿�
		register.setToolTipText("���ע��");
		register.addActionListener(this);   //Ϊע�ᰴťע�������
		
		//���������ť
		clear=new JButton("���");
		clear.setFont(new Font("����",Font.BOLD,20));
		clear.setBounds(280, 200, 90, 60);
		Big.add(clear);
		clear.setContentAreaFilled(false);    //���ð�ť͸��
		clear.setBorderPainted(false);   //���ð�ť�ޱ߿�
		clear.setToolTipText("�������ı�������");
		clear.addActionListener(this);   //Ϊ�����ťע�������
		
		
		
		//��Big��ǩ�ӵ�������
		container.add(Big);
		}
		
	
	public static void main(String args[]) throws IOException {
		new Login_View();
		 
	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		
		                                                   
		if(e.getSource()==login){
			User_Link A=new User_Link();
			Boolean tBoolean=A.CheckUser(user.getText(),String.valueOf(password.getPassword()));
			if(tBoolean){
				JOptionPane.showMessageDialog(this, "��ӭ������������ϵͳ��");
				new NewTest_InterFace_View();
				
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "�û���������������������룡");
			}	
		}
		
		if(e.getSource()==register){
			
		
			new Register();
		}
		if(e.getSource()==clear) {
		
				user.setText("");
				password.setText("");
				
			}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			User_Link A=new User_Link();
			Boolean tBoolean=A.CheckUser(user.getText(),String.valueOf(password.getPassword()));
			if(tBoolean){
				JOptionPane.showMessageDialog(this, "��ӭ������������ϵͳ��");
				new NewTest_InterFace_View();
				
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "�û���������������������룡");
			}	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
	}

}