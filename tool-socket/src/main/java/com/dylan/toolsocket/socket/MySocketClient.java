package com.dylan.toolsocket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class MySocketClient
{
    Socket s=null;
    DataInputStream inStream=null;
    DataOutputStream outStream=null;
    FileOutputStream fout = null;
    public MySocketClient() {
        try{
            s=new Socket("192.9.207.52",765); //把这里的IP改成你运行SocketServer.class的IP
            inStream=new DataInputStream(s.getInputStream());
            outStream=new DataOutputStream(s.getOutputStream());
            fout = new FileOutputStream("C:/temp/socket/test11.zip");
            s.setSoTimeout(3000);
            waitData();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    void init() throws Exception{
    }
    void waitData(){
        try{
            byte[] b = new byte[200];
            int i;
            while((i=inStream.read(b))!=-1){
                fout.write(b);
            }
            fout.flush();
            fout.close();
            s.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args) {
        MySocketClient socketClient1 = new MySocketClient();
    }
}
