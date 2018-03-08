package com.dylan.toolsocket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

class MyThreadServer extends Thread{
    private Socket socket;
    private DataInputStream inStream=null;
    private DataOutputStream outStream=null;
    private FileInputStream fin = null;
    public MyThreadServer(Socket sock){
        this.socket = sock;
    }
    public void run(){
        boolean bool = false;
        //while(!bool){
        try{
            inStream=new DataInputStream(socket.getInputStream());
            outStream=new DataOutputStream(socket.getOutputStream());
            fin = new FileInputStream("D:/temp/tool/tttt.txt");
            //socket.setSoTimeout(3000);
            byte[] b = new byte[200];
            int i;
            while((i=fin.read(b))!=-1){
                outStream.write(b);
            }
            fin.close();
            socket.close();
            //bool = true;
        }catch(IOException ex){
            System.out.println(ex);
        }
        //}
    }
}
