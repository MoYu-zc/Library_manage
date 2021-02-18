package my_View;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import my_Link.People_Link;

public class People_sell_new_View extends JPanel implements ActionListener {
	//定义标签  标题，公司名称，负责人，性别，电话，地址
	private JLabel bt,name,people,sex,tel,address;
	//定义文本框  公司名称，负责人，性别，电话，地址
	private JTextField Name,People,Tel,Address;
	//定义按钮
	private JButton submit,clear;
	//定义单选按钮
	private JComboBox SEX;
	//定义两个面板，分别存放标题，采购商信息
	private JPanel p1,p2;
	
	public People_sell_new_View(){
		this.setBounds(0, 0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);      //设置面板透明
		
		//添加面板_标题
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420, 0, 919, 30);  
		p1.setOpaque(false);        //设置面板透明
		
		bt=new JLabel("添加销售商");
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
		
		name=new JLabel("公司名称");
		name.setBounds(300, 100, 150, 28);
		name.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(name);
		
		Name=new JTextField();
		Name.setBounds(390, 100, 180, 28);
		Name.setFont(new Font("华文仿宋",0,20));
		p2.add(Name);
		
		people=new JLabel("负 责 人");
		people.setBounds(300, 150, 150, 28);
		people.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(people);
		
		People=new JTextField();
		People.setBounds(390, 150, 180, 28);
		People.setFont(new Font("华文仿宋",0,20));
		p2.add(People);
		
		sex=new JLabel("性    别");
		sex.setBounds(300, 200, 150, 28);
		sex.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(sex);
		
		SEX=new JComboBox<String>();
		SEX.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		SEX.setBounds(390, 200, 180, 28);
		sex.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(SEX);
		
		tel=new JLabel("联系电话");
		tel.setBounds(300, 250, 150, 28);
		tel.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(tel);
		
		Tel=new JTextField();
		Tel.setBounds(390, 250, 180, 28);
		Tel.setFont(new Font("华文仿宋",0,20));
		p2.add(Tel);
		
		address=new JLabel("公司地址");
		address.setBounds(300, 300, 150, 28);
		address.setFont(new Font("华文仿宋",Font.BOLD,20));
		p2.add(address);
		
		Address=new JTextField();
		Address.setBounds(390, 300, 180, 28);
		Address.setFont(new Font("华文仿宋",0,20));
		p2.add(Address);
		
		submit=new JButton("提交");
		submit.setFont(new Font("华文仿宋",0,18));
		submit.setBounds(340, 435, 78, 40);
		submit.addActionListener(this);
		this.add(submit);
				
		clear=new JButton("清除");
		clear.setFont(new Font("华文仿宋",0,18));
		clear.setBounds(480, 435, 78, 40);
		clear.addActionListener(this);
		this.add(clear);
		
		this.add(p2);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==submit){
			People_Link A=new People_Link();
			Boolean b=A.Check_Sell(Name.getText());
			if(b){
				JOptionPane.showMessageDialog(this,"该销售商已存在！");
				Name.setText("");
				People.setText("");
				Tel.setText("");
				Address.setText("");
			}else{
				A.AddSell(Name.getText(), People.getText(), (String)SEX.getSelectedItem(), Tel.getText(), Address.getText());
				JOptionPane.showMessageDialog(this,"信息添加成功！");
			}
			
		}
		if(e.getSource()==clear){
			Name.setText("");
			People.setText("");
			Tel.setText("");
			Address.setText("");
			JOptionPane.showMessageDialog(this, "已清除！");
		}
	}

}
