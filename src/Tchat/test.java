package Tchat;

import java.net.ServerSocket;


public class test {

    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(8888);
            new Thread(new Chatserver(server)).start();
            new Thread(new Chat()).start();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
