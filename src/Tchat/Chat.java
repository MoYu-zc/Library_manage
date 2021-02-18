package Tchat;


import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Chat extends JFrame implements ActionListener,Runnable {

    JTextArea t1;
    JTextField t2;
    JButton b1,b2;
    Socket socket ;
    DataOutputStream dos;
    DataInputStream dis;

    public Chat() throws IOException {

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("客户端");
        this.setResizable(false);

        Container c = this.getContentPane();
        JLabel Big = new JLabel();
        
        
        t1=new JTextArea();
        t1.setBounds(1,2,790,450);
      //设置自动换行
      		t1.setLineWrap(true);
      		//字边界换行
      		t1.setWrapStyleWord(true);
         	t1.setFont(new Font("楷书",Font.BOLD,20));
         	JScrollPane jsp=new JScrollPane(t1);
         	jsp.setBounds(1,2,790,450);
         	c.add(jsp);

        t2 = new JTextField();
        t2.setFont(new Font("楷书", Font.BOLD, 20));
        t2.setBounds(10, 500, 500, 35);
        Big.add(t2);

        b1 = new JButton("发送");
        b1.setBounds(530, 500, 100, 35);
        b1.setFont(new Font("楷书", Font.BOLD, 20));
        b1.addActionListener(this);
        Big.add(b1);
        
        b2=new JButton("接收文件");
        b2.setBounds(650, 500, 100, 35);
        b2.setFont(new Font("楷书", Font.BOLD, 15));
        b2.addActionListener(this);
        Big.add(b2);

        c.add(Big);
        this.setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("客户端：" + t2.getText());
                t1.append("客户端：" + t2.getText() + "\n");
                t2.setText("");
            }catch (Exception e1){
                e1.printStackTrace();
            }
            }
        
        if(e.getSource()==b2)
		{
			new Thread(new ReceiveFile()).start();
			
		}

        }

    @Override
    public void run() {
try {
    socket = new Socket("127.0.0.1", 8888);
    dis = new DataInputStream(socket.getInputStream());

    while (true) {
        String s = dis.readUTF();
        t1.append(s + "\n");

    }
} catch (UnknownHostException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}finally {
	try {
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
    }
}
