package Tchat;

import java.awt.FileDialog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class SendFile  implements Runnable{
	public boolean flag = true;
	private ServerSocket fileServer ;
	private Socket socket;
	private FileInputStream fis;
	private DataOutputStream dos;
	@Override
	public void run() {
		
		try {
			fileServer= new ServerSocket(6666);
			JFrame jframe = new JFrame();
			FileDialog fd = new FileDialog(jframe, "选择文件", FileDialog.LOAD);
			fd.setLocation(400, 250);
			fd.setSize(500, 450);
			fd.setVisible(true);
			String filePath = fd.getDirectory()+fd.getFile();
			System.out.println(filePath);
			File file = new File(filePath);
			try {
				 socket = fileServer.accept();
			fis = new FileInputStream(file);
				 dos = new DataOutputStream(socket.getOutputStream());
				
                // 开始传输文件
               
                byte[] bytes = new byte[1024];
                int length = 0;
                while((length = fis.read(bytes, 0, bytes.length))!=-1) {
                    dos.write(bytes, 0, length);
                    dos.flush();           
                }    
                socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}finally {
			 
			try {
				 if(fis != null)
		                fis.close();
		            if(dos != null)
		                dos.close();
                    
				    fileServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
