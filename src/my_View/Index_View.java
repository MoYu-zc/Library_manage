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
		this.setOpaque(false);        //设置面板透明
		
		p1=new JPanel();
		p1.setBounds(5, 10, 899, 160);
		JLabel introduce1=new JLabel("<html> <h1>图书进销存系统简介<h1> </html>");
		introduce1.setBounds(-20, -15, 100, 30);
		JLabel introduce=new JLabel("<html>&nbsp;&nbsp;&nbsp;图书进销存管理系统（The Books Invoicing System）简写为BIS，主要是反应书店在经营过程<br/>&nbsp;中采购、销售、库存、报警以及往来账款管理方面的情况。本系统主要是图书的进销存管理，并不<br/>&nbsp;是网上书店的形式。本书点的实际采购和销售都是现实中已存在的事实。本系统主要是登记已采购<br/>&nbsp;或已销售图书的信息情况，对报警信息只提示，不予以处理。</html>");
		introduce.setFont(new Font("宋体",0,20));
		introduce.setBounds(0, 0, 160, 100);
		p1.add(introduce1);
		p1.add(introduce);
		p1.setOpaque(false);
		this.add(p1);
		
		p2=new JPanel();
		p2.setBounds(5, 200, 800, 280);
		JLabel shouze1=new JLabel("<html><h1>管理员守则<h1></html>");
		shouze1.setFont(new Font("宋体",0,20));
//		shouze1.setBounds(5, 185, 100,30);
		JLabel shouze=new JLabel("<html>1、管理员严格遵守书店的相关规章制度；<br/>2、管理员不得向他人透露系统的登录用户名和密码；<br/>3、管理员要本着严谨仔细的态度完善相关数据；<br/>4、管理员对涉及到的人员信息要严格保密；<br/>5、管理员要严格审查图书采购入库单和销售单，并记录相关数据；<br/>6、管理员不得擅自改动图书的相关信息以及图书采购、销售、库存等信息；<br/>7、管理员不得擅自添加空无的订单或销售单；<br/>8、以上情况一经发现，严肃处理。</html>");
		shouze.setFont(new Font("宋体",0,20));
//		shouze.setBounds(0, 220, 160, 200);
		p2.add(shouze1);
		p2.add(shouze);
		p2.setOpaque(false);
		this.add(p2);
	}
	
}
