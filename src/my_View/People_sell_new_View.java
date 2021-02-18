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
	//�����ǩ  ���⣬��˾���ƣ������ˣ��Ա𣬵绰����ַ
	private JLabel bt,name,people,sex,tel,address;
	//�����ı���  ��˾���ƣ������ˣ��Ա𣬵绰����ַ
	private JTextField Name,People,Tel,Address;
	//���尴ť
	private JButton submit,clear;
	//���嵥ѡ��ť
	private JComboBox SEX;
	//����������壬�ֱ��ű��⣬�ɹ�����Ϣ
	private JPanel p1,p2;
	
	public People_sell_new_View(){
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
		
		name=new JLabel("��˾����");
		name.setBounds(300, 100, 150, 28);
		name.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(name);
		
		Name=new JTextField();
		Name.setBounds(390, 100, 180, 28);
		Name.setFont(new Font("���ķ���",0,20));
		p2.add(Name);
		
		people=new JLabel("�� �� ��");
		people.setBounds(300, 150, 150, 28);
		people.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(people);
		
		People=new JTextField();
		People.setBounds(390, 150, 180, 28);
		People.setFont(new Font("���ķ���",0,20));
		p2.add(People);
		
		sex=new JLabel("��    ��");
		sex.setBounds(300, 200, 150, 28);
		sex.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(sex);
		
		SEX=new JComboBox<String>();
		SEX.setModel(new DefaultComboBoxModel(new String[] {"��", "Ů"}));
		SEX.setBounds(390, 200, 180, 28);
		sex.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(SEX);
		
		tel=new JLabel("��ϵ�绰");
		tel.setBounds(300, 250, 150, 28);
		tel.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(tel);
		
		Tel=new JTextField();
		Tel.setBounds(390, 250, 180, 28);
		Tel.setFont(new Font("���ķ���",0,20));
		p2.add(Tel);
		
		address=new JLabel("��˾��ַ");
		address.setBounds(300, 300, 150, 28);
		address.setFont(new Font("���ķ���",Font.BOLD,20));
		p2.add(address);
		
		Address=new JTextField();
		Address.setBounds(390, 300, 180, 28);
		Address.setFont(new Font("���ķ���",0,20));
		p2.add(Address);
		
		submit=new JButton("�ύ");
		submit.setFont(new Font("���ķ���",0,18));
		submit.setBounds(340, 435, 78, 40);
		submit.addActionListener(this);
		this.add(submit);
				
		clear=new JButton("���");
		clear.setFont(new Font("���ķ���",0,18));
		clear.setBounds(480, 435, 78, 40);
		clear.addActionListener(this);
		this.add(clear);
		
		this.add(p2);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==submit){
			People_Link A=new People_Link();
			Boolean b=A.Check_Sell(Name.getText());
			if(b){
				JOptionPane.showMessageDialog(this,"���������Ѵ��ڣ�");
				Name.setText("");
				People.setText("");
				Tel.setText("");
				Address.setText("");
			}else{
				A.AddSell(Name.getText(), People.getText(), (String)SEX.getSelectedItem(), Tel.getText(), Address.getText());
				JOptionPane.showMessageDialog(this,"��Ϣ��ӳɹ���");
			}
			
		}
		if(e.getSource()==clear){
			Name.setText("");
			People.setText("");
			Tel.setText("");
			Address.setText("");
			JOptionPane.showMessageDialog(this, "�������");
		}
	}

}
