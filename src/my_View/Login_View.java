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
	
	JTextField user;    //定义用户名文本框
	private JPasswordField password;     //定义密码输入框
	private JButton login,register,clear;

	public String getUserName(){
		return user.getText();
	}
	
	public Login_View(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置点击窗体的关闭按钮关闭
		this.setTitle("进销存管理系统");
		this.setSize(450, 325);
		this.setResizable(false);
		//设置窗体图标
		Image img0 = new ImageIcon("icon_001.png").getImage();
		this.setIconImage(img0);
		init();
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	public void init(){
			//设置一个容器
		Container container=this.getContentPane();
	
		
		//设置一个总标签
		JLabel Big=new JLabel();
		
		//设置背景图片
		Image icon=new ImageIcon("res/纯色背景.gif").getImage();
		Big.setIcon(new ImageIcon(icon));
		Big.setBounds(0, 0, 450, 325);
		
		//设置标题图片
		JLabel btlb=new JLabel();
		Image bt=new ImageIcon("res/标题.png").getImage();
		btlb.setIcon(new ImageIcon(bt));
		btlb.setBounds(37, 0, 433, 75);
		Big.add(btlb);
		
		
		
		//设置用户名标签和文本框
		JLabel userlb=new JLabel("用户名");
		userlb.setFont(new Font("楷体", Font.BOLD ,20));
		userlb.setBounds(55,90,100,50);
		Big.add(userlb);
		
		user=new JTextField("");
		user.setFont(new Font("楷体",Font.BOLD,20));
		user.setBounds(145, 100, 210, 30);
		user.setToolTipText("点此输入用户名");
		Big.add(user);
		
		//设置密码标签和密码输入框
		JLabel passwordlb=new JLabel("密  码");
		passwordlb.setFont(new Font("楷体", Font.BOLD, 20));
		passwordlb.setBounds(55, 142, 100, 50);
		Big.add(passwordlb);
		
		password=new JPasswordField("");
		password.setFont(new Font("宋体", Font.BOLD, 15));
		password.setBounds(145, 150, 210, 30);
		password.setToolTipText("点此输入密码");
		password.addKeyListener(this);
		Big.add(password);
		
		//设置登录按钮
		login=new JButton("登录");
		login.setFont(new Font("楷体",Font.BOLD,20));
		login.setBounds(80, 200 , 90, 60);
		Big.add(login);
		login.setContentAreaFilled(false);   //设置按钮透明
		login.setBorderPainted(false);   //设置按钮无边框
		
		login.setToolTipText("点此登录");
		login.addActionListener(this);   //为登录按钮注册监听器
		

		
		//设置注册按钮
		register=new JButton("注册");
		register.setFont(new Font("楷体",Font.BOLD,20));
		register.setBounds(180, 200, 90, 60);
		Big.add(register);
		register.setContentAreaFilled(false);   //设置按钮透明
		register.setBorderPainted(false);   //设置按钮无边框
		register.setToolTipText("点此注册");
		register.addActionListener(this);   //为注册按钮注册监听器
		
		//设置清除按钮
		clear=new JButton("清除");
		clear.setFont(new Font("楷体",Font.BOLD,20));
		clear.setBounds(280, 200, 90, 60);
		Big.add(clear);
		clear.setContentAreaFilled(false);    //设置按钮透明
		clear.setBorderPainted(false);   //设置按钮无边框
		clear.setToolTipText("点此清除文本框内容");
		clear.addActionListener(this);   //为清除按钮注册监听器
		
		
		
		//将Big标签加到容器内
		container.add(Big);
		}
		
	
	public static void main(String args[]) throws IOException {
		new Login_View();
		 
	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		                                                   
		if(e.getSource()==login){
			User_Link A=new User_Link();
			Boolean tBoolean=A.CheckUser(user.getText(),String.valueOf(password.getPassword()));
			if(tBoolean){
				JOptionPane.showMessageDialog(this, "欢迎进入进销存管理系统！");
				new NewTest_InterFace_View();
				
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "用户名或密码错误，请重新输入！");
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
		// TODO 自动生成的方法存根
		}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			User_Link A=new User_Link();
			Boolean tBoolean=A.CheckUser(user.getText(),String.valueOf(password.getPassword()));
			if(tBoolean){
				JOptionPane.showMessageDialog(this, "欢迎进入进销存管理系统！");
				new NewTest_InterFace_View();
				
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "用户名或密码错误，请重新输入！");
			}	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
	}

}