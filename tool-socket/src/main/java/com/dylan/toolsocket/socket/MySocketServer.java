package com.dylan.toolsocket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer
{
    ServerSocket ss=null;
    Socket s=null;
    DataInputStream inStream=null;
    DataOutputStream outStream=null;
    FileInputStream fin = null;
    public MySocketServer() {
        try{
            ss=new ServerSocket(7080);
            s.setSoTimeout(3000);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    void waitForClient(){
        try{
            while(true){
                s=ss.accept();
                MyThreadServer thread = new MyThreadServer(s);
                thread.start();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args) {
        MySocketServer socketServer1 = new MySocketServer();
        socketServer1.waitForClient();
    }
}
