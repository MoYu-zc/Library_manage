package my_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import org.apache.poi.ss.util.ImageUtils;

import Tchat.Chat;
import Tchat.Chatserver;


public class NewTest_InterFace_View implements TreeSelectionListener,ActionListener {
	//��ʼ����ǩ  ���⣬�������������ͷ�񣬰�Ȩ��ʱ�䣬�ܣ���ӭ�ʣ��ͷ�
	private JLabel bt,bqb,manage,bq1,bq2,timel,week,welcome,kf,background;
	private JButton submit,clear,service,exit;
	private JPanel p5;
	private JFrame app;
	private static 	ServerSocket server;
	
	public NewTest_InterFace_View(){
		app=new JFrame();
		app.setTitle("ͼ����������ϵͳ");
		Container c=app.getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		
		//���ô���ͼ��
		Image img0 = new ImageIcon("icon_001.png").getImage();
		app.setIconImage(img0);
		
		//���ñ���ͼƬ
		bt=new JLabel();
		Image btimg=new ImageIcon("res/����.png").getImage();
		bt.setIcon(new ImageIcon(btimg));
		bt.setBounds(0, 0, 433, 75);
		p1.add(bt);
		
		JPanel pguanli=new JPanel();
		pguanli.setBorder(BorderFactory.createTitledBorder(""));
		pguanli.setLayout(null);
		pguanli.setBounds(400, 10, 500, 65);
		//��ӹ���Աͷ��
		manage=new JLabel();
		Image manager=new ImageIcon("res/manager_main.png").getImage();
		manage.setIcon(new ImageIcon(manager));
		manage.setBounds(10, 6, 70, 50);
		pguanli.add(manage);
		//����ʺ���
		String Welcome=null;
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("HH");//ֻ��ʱ
		String time=sdf.format(date);
		if(Integer.valueOf(time)>=0&&Integer.valueOf(time)<8)
			Welcome="���Ϻã�";
		else if(Integer.valueOf(time)>=8&&Integer.valueOf(time)<12)
			Welcome="����ã�";
		else if(Integer.valueOf(time)>=12&&Integer.valueOf(time)<20)
			Welcome="����ã�";
		else if(Integer.valueOf(time)>=20&&Integer.valueOf(time)<24)
			Welcome="���Ϻã�";
		welcome=new JLabel(Welcome);
		welcome.setFont(new Font("���ķ���", Font.BOLD, 16));
		welcome.setForeground(Color.BLACK);
		welcome.setBounds(75, 37, 115, 20);
		pguanli.add(welcome);
		//��ӱ����
		bqb=new JLabel();
		Image bqbicon=new ImageIcon("res/emm.png").getImage();
		bqb.setIcon(new ImageIcon(bqbicon));
		bqb.setBounds(195, 3, 110, 58);
		pguanli.add(bqb);
		//���ϵͳʱ��
		timel = new JLabel();
		timel.setFont(new Font("���ķ���", Font.BOLD, 16));
		timel.setForeground(Color.BLACK);
		timel.setBounds(300, 12, 162, 25);
		pguanli.add(timel);
		week=new JLabel();
		week.setFont(new Font("���ķ���", Font.BOLD, 14));
		week.setForeground(Color.BLACK);
		week.setBounds(300, 32, 164, 25);
		pguanli.add(week);
		TimerTask task = new TimerTask(){
        	public void run(){
        		String sdate,tdate;
	        	sdate = (new SimpleDateFormat("yyyy "+"��"+" MM "+"��"+" dd "+"��")).format(new Date());
	        	timel.setText(sdate);
	        	tdate = (new SimpleDateFormat("HH : mm : ss     EEEE")).format(new Date());
	        	week.setText(tdate);
        	}
        };
		Timer t = new Timer();
        t.scheduleAtFixedRate(task, new Date(), 1000);
		//��ӿͷ���ǩ
        JPanel p3=new JPanel();
        p3.setLayout(null);
        p3.setBounds(920, 10, 200, 65);
        p3.setBorder(BorderFactory.createTitledBorder(""));
		kf=new JLabel();
		Image kficon=new ImageIcon("res/�ͷ�.png").getImage();
		kf.setIcon(new ImageIcon(kficon));
		kf.setBounds(5, 8, 150, 50);
		p3.add(kf);
        //��ӿͷ���ť
        service=new JButton("�ͷ�");
        service.setForeground(Color.BLACK);
        service.setFont(new Font("���ķ���",Font.BOLD,15));
        service.setBounds(100, 12, 67, 42);
        service.addActionListener(this);
        p3.add(service);
        
        exit=new JButton("�˳�");
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("���ķ���",Font.BOLD,15));
        exit.setBounds(1130, 22, 67, 42);
        exit.addActionListener(this);
        p1.add(exit);
        
        //��������
        JPanel pshu=new JPanel();
        pshu.setBounds(-5, 120, 260, 650);
        //������
      	DefaultMutableTreeNode root=new DefaultMutableTreeNode("ͼ����������ϵͳ");
      	DefaultMutableTreeNode node7=new DefaultMutableTreeNode("��ҳ");
      	DefaultMutableTreeNode node1=new DefaultMutableTreeNode("�ɹ�����");
      	DefaultMutableTreeNode node2=new DefaultMutableTreeNode("���۹���");
      	DefaultMutableTreeNode node3=new DefaultMutableTreeNode("������");
      	DefaultMutableTreeNode node4=new DefaultMutableTreeNode("��Ա����");
      
      	
      	DefaultMutableTreeNode n1=new DefaultMutableTreeNode("�����̹���");
      	DefaultMutableTreeNode n2=new DefaultMutableTreeNode("�����̹���");
      	
      	DefaultMutableTreeNode node5=new DefaultMutableTreeNode("�˿����");
      	DefaultMutableTreeNode node6=new DefaultMutableTreeNode("��������");
      	DefaultTreeModel treeModel=new DefaultTreeModel(root);
      	treeModel.insertNodeInto(node7, root, root.getChildCount());
      	treeModel.insertNodeInto(node1, root, root.getChildCount());
      	treeModel.insertNodeInto(node2, root, root.getChildCount());
      	treeModel.insertNodeInto(node3, root, root.getChildCount());
      	treeModel.insertNodeInto(node4, root, root.getChildCount());
      	
      	treeModel.insertNodeInto(n1, node4, node4.getChildCount());
      	treeModel.insertNodeInto(n2, node4, node4.getChildCount());
      	
      	treeModel.insertNodeInto(node5, root, root.getChildCount());
      	treeModel.insertNodeInto(node6, root, root.getChildCount());
      	DefaultMutableTreeNode leafnode=new DefaultMutableTreeNode ("");
      	leafnode=new DefaultMutableTreeNode ("����²ɹ�");
      	treeModel.insertNodeInto(leafnode,node1,node1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("��ʷ�ɹ���ѯ");
      	treeModel.insertNodeInto(leafnode,node1,node1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("���������");
      	treeModel.insertNodeInto(leafnode,node2,node2.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("��ʷ���۲�ѯ");
      	treeModel.insertNodeInto(leafnode,node2,node2.getChildCount());
      	leafnode=new DefaultMutableTreeNode("�����Ϣ��ѯ");
      	treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
      	
      	leafnode=new DefaultMutableTreeNode ("��ӹ�����");
      	treeModel.insertNodeInto(leafnode,n1,n1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("�����̲鿴");
      	treeModel.insertNodeInto(leafnode,n1,n1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("���������");
      	treeModel.insertNodeInto(leafnode,n2,n2.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("�����̲鿴");
      	treeModel.insertNodeInto(leafnode,n2,n2.getChildCount());
      	
      	leafnode=new DefaultMutableTreeNode ("�ɹ��˿��ѯ");
      	treeModel.insertNodeInto(leafnode,node5,node5.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("�����˿��ѯ");
      	treeModel.insertNodeInto(leafnode,node5,node5.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("������Ϣ����");
      	treeModel.insertNodeInto(leafnode,node6,node6.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("������Ϣ�鿴");
      	treeModel.insertNodeInto(leafnode,node6,node6.getChildCount());
      		
      	JTree tree=new JTree(treeModel);
      	tree.addTreeSelectionListener(this);
      	tree.setFont(new Font("����",0,20));
      	//�ı�JTree�����
      	tree.putClientProperty("JTree.lineStyle", "Horizontal");
      	
//      	Icon EIcon=new ImageIcon("res/111.jpg");
//      	
//      	BasicTreeUI ui=(BasicTreeUI)(tree.getUI());
//      	ui.setExpandedIcon(EIcon);
//      	tree.setShowsRootHandles(true);
//      	
//    	DefaultTreeCellRenderer  r=(DefaultTreeCellRenderer )tree.getCellRenderer(); 
//      	 r.setOpenIcon(new ImageIcon(this.getClass().getResource("res/111.png")));
      	
      	JScrollPane scrollPane=new JScrollPane();
      	scrollPane.setViewportView(tree);
      	scrollPane.setBounds(60, 160, 140, 450);
        pshu.add(scrollPane);
      	
       
        JPanel pbq1=new JPanel();
        pbq1.setBounds(50,690,1200,35);
        JPanel pbq2=new JPanel();
        pbq2.setBounds(40,720,1200,40);
        
   
        //��Ӵ����
        p5=new JPanel();
        p5.setLayout(null);
        p5.setBounds(258, 125, 924, 541);
        p5.setOpaque(false);        //�������͸��
        //���͸������
        background=new JLabel();
        Image testicon=new ImageIcon("res/����.png").getImage();
        background.setIcon(new ImageIcon(testicon));
        background.setBounds(240,0,920,540);
       
        
        JLabel wel=new JLabel("��ӭʹ��ͼ����������ϵͳ");
        wel.setBounds(130, 0, 920, 540);
        wel.setFont(new Font("���ķ���",0,50));
        wel.setOpaque(false);
        p5.add(wel);     
        p5.add(background);
        
        
        p1.add(pshu);
        p1.add(pguanli);
		p1.add(p3);
		p1.add(pbq1);p1.add(pbq2);
		p1.add(p5);
		c.add(p1);
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(1235, 800);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		app.setResizable(false);
	}
	

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO �Զ����ɵķ������
		JTree tree=(JTree)e.getSource();
		if(e.getSource()==tree){
		DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		   if(selectionNode.isLeaf()){ 
			   String nodeName=selectionNode.toString();
			   if(nodeName.equals("��ҳ"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Index_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("����²ɹ�"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new NewTest_Purchase_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("��ʷ�ɹ���ѯ"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Purchasehistory_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("���������"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Sell_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("��ʷ���۲�ѯ"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Sellhistory_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("�����Ϣ��ѯ"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Stock_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("��ӹ�����"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_purchase_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("�����̲鿴"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_purchase_watch_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("���������"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_sell_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("�����̲鿴"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_sell_watch_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("�ɹ��˿��ѯ"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Money_purchase_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("�����˿��ѯ"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Money_sell_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("������Ϣ����"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Clarm_manage_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("������Ϣ�鿴"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Clarm_watch_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
	        }
        }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==service){
			 try {
		            server = new ServerSocket(8888);
		            new Thread(new Chatserver(server)).start();
		            new Thread(new Chat()).start();

		        }catch(Exception e1){
		            e1.printStackTrace();
		        }
		}
		if(e.getSource()==exit){
			app.setVisible(false);
			new Login_View();
		}
	}

}
