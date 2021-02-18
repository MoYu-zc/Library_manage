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
	//初始化标签  标题，表情包，管理者头像，版权，时间，周，欢迎词，客服
	private JLabel bt,bqb,manage,bq1,bq2,timel,week,welcome,kf,background;
	private JButton submit,clear,service,exit;
	private JPanel p5;
	private JFrame app;
	private static 	ServerSocket server;
	
	public NewTest_InterFace_View(){
		app=new JFrame();
		app.setTitle("图书进销存管理系统");
		Container c=app.getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		
		//设置窗体图标
		Image img0 = new ImageIcon("icon_001.png").getImage();
		app.setIconImage(img0);
		
		//设置标题图片
		bt=new JLabel();
		Image btimg=new ImageIcon("res/标题.png").getImage();
		bt.setIcon(new ImageIcon(btimg));
		bt.setBounds(0, 0, 433, 75);
		p1.add(bt);
		
		JPanel pguanli=new JPanel();
		pguanli.setBorder(BorderFactory.createTitledBorder(""));
		pguanli.setLayout(null);
		pguanli.setBounds(400, 10, 500, 65);
		//添加管理员头像
		manage=new JLabel();
		Image manager=new ImageIcon("res/manager_main.png").getImage();
		manage.setIcon(new ImageIcon(manager));
		manage.setBounds(10, 6, 70, 50);
		pguanli.add(manage);
		//添加问候语
		String Welcome=null;
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("HH");//只有时
		String time=sdf.format(date);
		if(Integer.valueOf(time)>=0&&Integer.valueOf(time)<8)
			Welcome="早上好！";
		else if(Integer.valueOf(time)>=8&&Integer.valueOf(time)<12)
			Welcome="上午好！";
		else if(Integer.valueOf(time)>=12&&Integer.valueOf(time)<20)
			Welcome="下午好！";
		else if(Integer.valueOf(time)>=20&&Integer.valueOf(time)<24)
			Welcome="晚上好！";
		welcome=new JLabel(Welcome);
		welcome.setFont(new Font("华文仿宋", Font.BOLD, 16));
		welcome.setForeground(Color.BLACK);
		welcome.setBounds(75, 37, 115, 20);
		pguanli.add(welcome);
		//添加表情包
		bqb=new JLabel();
		Image bqbicon=new ImageIcon("res/emm.png").getImage();
		bqb.setIcon(new ImageIcon(bqbicon));
		bqb.setBounds(195, 3, 110, 58);
		pguanli.add(bqb);
		//添加系统时间
		timel = new JLabel();
		timel.setFont(new Font("华文仿宋", Font.BOLD, 16));
		timel.setForeground(Color.BLACK);
		timel.setBounds(300, 12, 162, 25);
		pguanli.add(timel);
		week=new JLabel();
		week.setFont(new Font("华文仿宋", Font.BOLD, 14));
		week.setForeground(Color.BLACK);
		week.setBounds(300, 32, 164, 25);
		pguanli.add(week);
		TimerTask task = new TimerTask(){
        	public void run(){
        		String sdate,tdate;
	        	sdate = (new SimpleDateFormat("yyyy "+"年"+" MM "+"月"+" dd "+"日")).format(new Date());
	        	timel.setText(sdate);
	        	tdate = (new SimpleDateFormat("HH : mm : ss     EEEE")).format(new Date());
	        	week.setText(tdate);
        	}
        };
		Timer t = new Timer();
        t.scheduleAtFixedRate(task, new Date(), 1000);
		//添加客服标签
        JPanel p3=new JPanel();
        p3.setLayout(null);
        p3.setBounds(920, 10, 200, 65);
        p3.setBorder(BorderFactory.createTitledBorder(""));
		kf=new JLabel();
		Image kficon=new ImageIcon("res/客服.png").getImage();
		kf.setIcon(new ImageIcon(kficon));
		kf.setBounds(5, 8, 150, 50);
		p3.add(kf);
        //添加客服按钮
        service=new JButton("客服");
        service.setForeground(Color.BLACK);
        service.setFont(new Font("华文仿宋",Font.BOLD,15));
        service.setBounds(100, 12, 67, 42);
        service.addActionListener(this);
        p3.add(service);
        
        exit=new JButton("退出");
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("华文仿宋",Font.BOLD,15));
        exit.setBounds(1130, 22, 67, 42);
        exit.addActionListener(this);
        p1.add(exit);
        
        //添加树面板
        JPanel pshu=new JPanel();
        pshu.setBounds(-5, 120, 260, 650);
        //创建树
      	DefaultMutableTreeNode root=new DefaultMutableTreeNode("图书进销存管理系统");
      	DefaultMutableTreeNode node7=new DefaultMutableTreeNode("首页");
      	DefaultMutableTreeNode node1=new DefaultMutableTreeNode("采购管理");
      	DefaultMutableTreeNode node2=new DefaultMutableTreeNode("销售管理");
      	DefaultMutableTreeNode node3=new DefaultMutableTreeNode("库存管理");
      	DefaultMutableTreeNode node4=new DefaultMutableTreeNode("人员管理");
      
      	
      	DefaultMutableTreeNode n1=new DefaultMutableTreeNode("供货商管理");
      	DefaultMutableTreeNode n2=new DefaultMutableTreeNode("销售商管理");
      	
      	DefaultMutableTreeNode node5=new DefaultMutableTreeNode("账款管理");
      	DefaultMutableTreeNode node6=new DefaultMutableTreeNode("报警管理");
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
      	leafnode=new DefaultMutableTreeNode ("添加新采购");
      	treeModel.insertNodeInto(leafnode,node1,node1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("历史采购查询");
      	treeModel.insertNodeInto(leafnode,node1,node1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("添加新销售");
      	treeModel.insertNodeInto(leafnode,node2,node2.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("历史销售查询");
      	treeModel.insertNodeInto(leafnode,node2,node2.getChildCount());
      	leafnode=new DefaultMutableTreeNode("库存信息查询");
      	treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
      	
      	leafnode=new DefaultMutableTreeNode ("添加供货商");
      	treeModel.insertNodeInto(leafnode,n1,n1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("供货商查看");
      	treeModel.insertNodeInto(leafnode,n1,n1.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("添加销售商");
      	treeModel.insertNodeInto(leafnode,n2,n2.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("销售商查看");
      	treeModel.insertNodeInto(leafnode,n2,n2.getChildCount());
      	
      	leafnode=new DefaultMutableTreeNode ("采购账款查询");
      	treeModel.insertNodeInto(leafnode,node5,node5.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("销售账款查询");
      	treeModel.insertNodeInto(leafnode,node5,node5.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("报警信息设置");
      	treeModel.insertNodeInto(leafnode,node6,node6.getChildCount());
      	leafnode=new DefaultMutableTreeNode ("报警信息查看");
      	treeModel.insertNodeInto(leafnode,node6,node6.getChildCount());
      		
      	JTree tree=new JTree(treeModel);
      	tree.addTreeSelectionListener(this);
      	tree.setFont(new Font("楷书",0,20));
      	//改变JTree的外观
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
        
   
        //添加大面板
        p5=new JPanel();
        p5.setLayout(null);
        p5.setBounds(258, 125, 924, 541);
        p5.setOpaque(false);        //设置面板透明
        //添加透明背景
        background=new JLabel();
        Image testicon=new ImageIcon("res/背景.png").getImage();
        background.setIcon(new ImageIcon(testicon));
        background.setBounds(240,0,920,540);
       
        
        JLabel wel=new JLabel("欢迎使用图书进销存管理系统");
        wel.setBounds(130, 0, 920, 540);
        wel.setFont(new Font("华文仿宋",0,50));
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
		// TODO 自动生成的方法存根
		JTree tree=(JTree)e.getSource();
		if(e.getSource()==tree){
		DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		   if(selectionNode.isLeaf()){ 
			   String nodeName=selectionNode.toString();
			   if(nodeName.equals("首页"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Index_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("添加新采购"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new NewTest_Purchase_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("历史采购查询"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Purchasehistory_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("添加新销售"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Sell_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("历史销售查询"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Sellhistory_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("库存信息查询"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Stock_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("添加供货商"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_purchase_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("供货商查看"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_purchase_watch_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("添加销售商"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_sell_new_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("销售商查看"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new People_sell_watch_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("采购账款查询"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Money_purchase_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("销售账款查询"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Money_sell_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("报警信息设置"))
               {
				  p5.setVisible(false);
				  p5.removeAll();
				  p5.add(new Clarm_manage_View());
				  p5.add(background);
				  p5.setVisible(true);
		       }
			   if(nodeName.equals("报警信息查看"))
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
		// TODO 自动生成的方法存根
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
