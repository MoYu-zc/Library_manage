package my_View;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Index_View extends JPanel {
	private JPanel p1,p2;
	public Index_View(){
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setBounds(0,0, 924, 541);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);        //�������͸��
		
		p1=new JPanel();
		p1.setBounds(5, 10, 899, 160);
		JLabel introduce1=new JLabel("<html> <h1>ͼ�������ϵͳ���<h1> </html>");
		introduce1.setBounds(-20, -15, 100, 30);
		JLabel introduce=new JLabel("<html>&nbsp;&nbsp;&nbsp;ͼ����������ϵͳ��The Books Invoicing System����дΪBIS����Ҫ�Ƿ�Ӧ����ھ�Ӫ����<br/>&nbsp;�вɹ������ۡ���桢�����Լ������˿��������������ϵͳ��Ҫ��ͼ��Ľ������������<br/>&nbsp;������������ʽ��������ʵ�ʲɹ������۶�����ʵ���Ѵ��ڵ���ʵ����ϵͳ��Ҫ�ǵǼ��Ѳɹ�<br/>&nbsp;��������ͼ�����Ϣ������Ա�����Ϣֻ��ʾ�������Դ���</html>");
		introduce.setFont(new Font("����",0,20));
		introduce.setBounds(0, 0, 160, 100);
		p1.add(introduce1);
		p1.add(introduce);
		p1.setOpaque(false);
		this.add(p1);
		
		p2=new JPanel();
		p2.setBounds(5, 200, 800, 280);
		JLabel shouze1=new JLabel("<html><h1>����Ա����<h1></html>");
		shouze1.setFont(new Font("����",0,20));
//		shouze1.setBounds(5, 185, 100,30);
		JLabel shouze=new JLabel("<html>1������Ա�ϸ�����������ع����ƶȣ�<br/>2������Ա����������͸¶ϵͳ�ĵ�¼�û��������룻<br/>3������ԱҪ�����Ͻ���ϸ��̬������������ݣ�<br/>4������Ա���漰������Ա��ϢҪ�ϸ��ܣ�<br/>5������ԱҪ�ϸ����ͼ��ɹ���ⵥ�����۵�������¼������ݣ�<br/>6������Ա�������ԸĶ�ͼ��������Ϣ�Լ�ͼ��ɹ������ۡ�������Ϣ��<br/>7������Ա����������ӿ��޵Ķ��������۵���<br/>8���������һ�����֣����ദ��</html>");
		shouze.setFont(new Font("����",0,20));
//		shouze.setBounds(0, 220, 160, 200);
		p2.add(shouze1);
		p2.add(shouze);
		p2.setOpaque(false);
		this.add(p2);
	}
	
}
