package my_View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import my_Link.JDBCLink;
import my_excel.People_Sell_excel;
import my_excel.Purchase_history_excel;

public class People_sell_watch_View extends JPanel implements ActionListener {
	private JTextField search;
	private JButton Search,output;
	private JLabel searchl,bt;   //��ǩ�����²�ѯ������
	private JPanel p1,p2;
	
	
	private JTable stock;
	
	public People_sell_watch_View(){
		this.setLayout(null);
		this.setBounds(0, 0, 924, 541);
		
		this.setVisible(true);
		this.setOpaque(false);     //�������͸��
		
		//������
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 919, 536);
		p1.setOpaque(false);
//		p1.setBorder(BorderFactory.createTitledBorder(""));
		
		bt=new JLabel("��������Ϣ�鿴");
		bt.setFont(new Font("���ķ���",Font.BOLD,22));
		bt.setBounds(405, 0, 250, 25);
		p1.add(bt);
		
		//��Ӳ�ѯ��ʾ
		searchl=new JLabel("��������Ҫ��ѯ�Ĺ�˾���ƣ�");
		searchl.setFont(new Font("���ķ���",Font.BOLD,20));
		searchl.setBounds(1, 40, 375, 25);
		p1.add(searchl);
		
		search=new JTextField();
		search.setFont(new Font("���ķ���",Font.BOLD,20));
		search.setBounds(310, 40, 180, 29);
		p1.add(search);
		
		Search=new JButton("��ѯ");
		Search.setFont(new Font("���ķ���",Font.BOLD,16));
		Search.setBounds(511, 38, 80, 30);
		Search.addActionListener(this);
		p1.add(Search);
		
		output=new JButton("����");
		output.setFont(new Font("���ķ���",Font.BOLD,16));
		output.setBounds(621, 38, 80, 30);
		output.addActionListener(this);
		p1.add(output);
		this.add(p1);

	}
	
	//���������������п�
	public  void setColumnSize(JTable table, int i, int preferedWidth){
		//������ģ��
		TableColumnModel cm = table.getColumnModel();
		//�õ���i���ж��� 
		TableColumn column = cm.getColumn(i);  
		column.setPreferredWidth(preferedWidth);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==Search){
			Connection userconn=null;
			Statement statement=null;
			ResultSet rs =null;
			userconn=JDBCLink.getConn();
			try {
				statement=userconn.createStatement();
				String sql="select *from t_sell where companyname="+"'"+search.getText()+"'";
				rs=statement.executeQuery(sql);
				while(rs.next()){
					rs.last();
					int n=rs.getRow();
					if(n==0){
						JOptionPane.showMessageDialog(this, "�޴˵��ţ�");
					}
					rs.beforeFirst();
					String ob[][]=new String[n][6];
					for(int i=0;i<n&&rs.next();i++){
						ob[i][0]=rs.getString(1);
						ob[i][1]=rs.getString(2);
						ob[i][2]=rs.getString(3);
						ob[i][3]=rs.getString(4);
						ob[i][4]=rs.getString(5);
					}
					String s[]={"��˾����","������","�Ա�","�绰","��˾��ַ"};
					stock=new JTable(ob,s);
					stock.setSize(900, 400);
					stock.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					stock.setRowHeight(25);               //�����и�
					JScrollPane jspane=new JScrollPane(stock);
					jspane.setBounds(0, 90, 916, 450);
					//�����п�
					this.setColumnSize(stock,0,224);
					this.setColumnSize(stock,1,90);
					this.setColumnSize(stock,2,90);
					this.setColumnSize(stock,3,125);
					this.setColumnSize(stock,4,384);
					
					
					this.add(jspane);
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
		if(e.getSource()==output){
			try {
				People_Sell_excel.main_export();
				JOptionPane.showMessageDialog(this, "��������Ϣ���ѵ�����D�̣�");
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
	}
}
