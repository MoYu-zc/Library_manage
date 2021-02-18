package my_View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import my_Link.User_Link;

public class Register extends JFrame implements ActionListener{
	

    public JPanel contentPane;
    public JTextField txtName;
    public JPasswordField pwd;
    public JPasswordField pwdRe;
    public JTextField txtEmail;
    public JTextField txtbirthday;
    public JComboBox comGender;
    public JTextArea txtSignat;//ǩ��
    public JComboBox comboBoxHeadImage;//ͷ��
    public JButton btnRegister,btnCancel;
    public  Boolean a;


    /**
     * Create the frame.
     */
    public Register()
    {


        setTitle("ע��");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(430, 400);
        setLocationRelativeTo(null);
      //���ô���ͼ��
      		Image img0 = new ImageIcon("icon_001.png").getImage();
      		this.setIconImage(img0);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l=new JLabel();
        Image icon=new ImageIcon("poto/registerBGimg3.jpg").getImage();
        l.setIcon(new ImageIcon(icon));
       l.setBounds(0, 0, 430, 400);


        JLabel lbUserName = new JLabel("\u7528\u6237\u540D");
        lbUserName.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        lbUserName.setBounds(38, 45, 54, 24);
        l.add(lbUserName);

        JLabel lbPwd = new JLabel("\u5BC6\u7801");
        lbPwd.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        lbPwd.setBounds(38, 96, 54, 30);
        l.add(lbPwd);

        JLabel lbPwdre = new JLabel("\u91CD\u590D\u5BC6\u7801");
        lbPwdre.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        lbPwdre.setBounds(22, 138, 79, 35);
        l.add(lbPwdre);


        txtName = new JTextField();
        txtName.setBounds(111, 40, 217, 35);
        l.add(txtName);
        txtName.setColumns(10);

        pwd = new JPasswordField();
        pwd.setBounds(111, 92, 217, 35);
        l.add(pwd);

        pwdRe = new JPasswordField();
        pwdRe.setBounds(113, 138, 215, 35);
        l.add(pwdRe);


        btnRegister = new JButton("\u514D\u8D39\u6CE8\u518C");
        btnRegister.setForeground(new Color(255, 255, 255));
        btnRegister.setBackground(new Color(0, 100, 0));
        btnRegister.setFont(new Font("΢���ź�", Font.BOLD, 28));
        btnRegister.setBounds(57, 230, 161, 60);
        btnRegister.addActionListener( this);
        l.add(btnRegister);

        btnCancel = new JButton("\u53D6\u6D88");
        btnCancel.setForeground(new Color(255, 250, 250));
        btnCancel.setBackground(new Color(106, 90, 205));
        btnCancel.setFont(new Font("΢���ź�", Font.BOLD, 28));
        btnCancel.setBounds(248, 230, 100, 60);
        btnCancel.addActionListener(this);
        l.add(btnCancel);
        
      //���ñ���ͼƬ
      		Image icon1=new ImageIcon("res/��ɫ����.gif").getImage();
      		l.setIcon(new ImageIcon(icon1));
      		l.setBounds(0, 0, 430, 400);
      		
      		

        contentPane.add(l);
        this.setVisible(true);

    }

    public static void main(String[] args)  {
        new Register();
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

        if (e.getSource()==btnCancel){
            this.setVisible(false);
        }
        if(e.getSource()==btnRegister){
            if(txtName.getText().equals(""))
                JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
            else if(new String(pwd.getPassword()).equals(""))
                JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
            else if(!new String(pwd.getPassword()).equals(new String(pwdRe.getPassword())))
                JOptionPane.showMessageDialog(null, "������������벻һ�£����������룡","����",JOptionPane.ERROR_MESSAGE);

            else {
              User_Link r = new  User_Link();
//                a=r.bo(txtName.getText());
//                System.out.println(a);
                User_Link B=new User_Link();
				if(B.check(txtName.getText())){
					JOptionPane.showMessageDialog(this, "���û���ע�ᣬ���¼��");
					  this.setVisible(false);
				}
                else {
                	try {
						r.add(txtName.getText(), String.valueOf(pwd.getPassword()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    JOptionPane.showMessageDialog(null, "�Ѿ��ɹ�ע��,����˺���:" + txtName.getText() + ",���������:" + String.valueOf(pwd.getPassword()));
					  this.setVisible(false);
                }
            }
        }

	}

}
