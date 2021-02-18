package Tchat;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class ReceiveFile implements Runnable{
	private Socket socket;
	private  DataInputStream dis;
	private  FileOutputStream fos;

	@Override
	public void run() {
		Frame jframe = new JFrame();
		FileDialog fd = new FileDialog(jframe, "保存文件", FileDialog.SAVE);
		fd.setLocation(400, 250);
		fd.setSize(500, 450);
		fd.setVisible(true);
		try {

		String stringFile = fd.getDirectory() + fd.getFile();
		System.out.println(stringFile);
		File file = new File(stringFile);
	
			 socket = new Socket("127.0.0.1", 6666);
			 dis = new DataInputStream(socket.getInputStream());
     
			 fos = new FileOutputStream(file);

             // 开始接收文件
             byte[] bytes = new byte[1024];
             int length = 0;
             while((length = dis.read(bytes, 0, bytes.length)) != -1) {
                 fos.write(bytes, 0, length);
                 fos.flush();
             }
             socket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(fos != null)
                    fos.close();
                if(dis != null)
                    dis.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
