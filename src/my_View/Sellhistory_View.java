package my_View;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
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
import my_excel.Purchase_history_excel;
import my_excel.Sell_history_excel;

public class Sellhistory_View extends JPanel implements ActionListener {
	private JTextField search;
	private JButton Search,output,print;
	private JLabel searchl,bt;   //��ǩ�����²�ѯ������
	private JPanel p1,p2;
	
	private String[]s1={};
	private JTable sell_history;
	
	public Sellhistory_View(){
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
		
		bt=new JLabel("��ʷ���۲�ѯ");
		bt.setFont(new Font("���ķ���",Font.BOLD,22));
		bt.setBounds(405, 0, 150, 25);
		p1.add(bt);
		
		//��Ӳ�ѯ��ʾ
		searchl=new JLabel("��������Ҫ��ѯ���·ݣ�");
		searchl.setFont(new Font("���ķ���",Font.BOLD,20));
		searchl.setBounds(140, 40, 370, 25);
		p1.add(searchl);
		
		search=new JTextField();
		search.setFont(new Font("���ķ���",Font.BOLD,20));
		search.setBounds(380, 40, 180, 29);
		p1.add(search);
		
		Search=new JButton("��ѯ");
		Search.setFont(new Font("���ķ���",Font.BOLD,16));
		Search.setBounds(611, 38, 80, 30);
		Search.addActionListener(this);
		p1.add(Search);
		
		output=new JButton("����");
		output.setFont(new Font("���ķ���",Font.BOLD,16));
		output.setBounds(741, 38, 80, 30);
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
				String sql="select *from t_sellbook where selldate like '_____"+search.getText()+"%'";
				rs=statement.executeQuery(sql);
				while(rs.next()){
					rs.last();
					int n=rs.getRow();
					if(n==0){
						JOptionPane.showMessageDialog(this, "��������Ϣ��");
					}
					rs.beforeFirst();
					String s1[][]=new String[n][13];
					for(int i=0;i<n&&rs.next();i++){
						s1[i][0]=rs.getString(1);
						s1[i][1]=rs.getString(2);
						s1[i][2]=rs.getString(3);
						s1[i][3]=rs.getString(4);
						s1[i][4]=rs.getString(5);
						s1[i][5]=rs.getString(6);
						s1[i][6]=rs.getString(7);
						s1[i][7]=rs.getString(8);
						s1[i][8]=rs.getString(9);
						s1[i][9]=rs.getString(10);
						s1[i][10]=rs.getString(11);
						s1[i][11]=rs.getString(12);
					}
					String s[]={"���۵���","ͼ��ISBN","ͼ������","����","������","������","ͼ�����","����","����","�ܶ�","�ɹ�ʱ��","������"};
					sell_history=new JTable(s1,s);
					sell_history.setSize(900, 400);
					sell_history.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					sell_history.setRowHeight(25);               //�����и�
					JScrollPane jspane=new JScrollPane(sell_history);
					jspane.setBounds(0, 90, 916, 450);
					//�����п�
					this.setColumnSize(sell_history,0,75);
					this.setColumnSize(sell_history,1,109);
					this.setColumnSize(sell_history,2,125);
					this.setColumnSize(sell_history,3,60);
					this.setColumnSize(sell_history,4,60);
					this.setColumnSize(sell_history,5,110);
				
					this.setColumnSize(sell_history,7,70);
					this.setColumnSize(sell_history,8,42);
				
					this.setColumnSize(sell_history,10,57);
					this.setColumnSize(sell_history,11,55);

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
				Sell_history_excel.main_export();
				JOptionPane.showMessageDialog(this, "��ʷ���۱��ѵ�����D�̣�");
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
//		if(e.getSource()==print){
//			File file = new File("d:/��ʷ������Ϣ��.xls"); //��ȡѡ����ļ�  
//		    //������ӡ�������Լ�  
//		    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
//		    //���ô�ӡ��ʽ����Ϊδȷ�����ͣ�����ѡ��autosense  
//		    DocFlavor flavor = DocFlavor.INPUT_STREAM.PNG;
//		    //��λĬ�ϵĴ�ӡ����  
//		    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
//		    //�������ӡ���ļ���  
//		    InputStream fis = null;
//		    if(defaultService != null){
//		        try {  
//		            DocPrintJob job = defaultService.createPrintJob(); //������ӡ��ҵ  
//		            fis = new FileInputStream(file);
//		            DocAttributeSet das = new HashDocAttributeSet();
//		            Doc doc = new SimpleDoc(fis, flavor, das);  //ָ����ӡ����
//		            job.print(doc, pras);
//		        } catch (Exception e2) {  
//		            e2.printStackTrace();  
//		        }  finally {
//		            try {
//		                fis.close();
//		            } catch (IOException e3) {
//		                // TODO Auto-generated catch block
//		                e3.printStackTrace();
//		            }
//		        }
//		    }
//		}
	}
}
