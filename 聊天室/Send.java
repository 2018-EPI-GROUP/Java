package wangluo.手写聊天室.聊天室;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
    private BufferedReader console;
    private Socket client;
    private DataOutputStream dos;
    private String name;
    @Override
    public void run(){
        while (true){
            String msg=getinformation();
            if (msg!=null){
                send(msg);
            }
        }
    }
    public Send(Socket client,String name){
        this.client=client;
        this.name=name;
        console=new BufferedReader(new InputStreamReader(System.in));
        try {
            dos=new DataOutputStream(client.getOutputStream());
            //发送名称
            send(name);
        } catch (IOException e) {
            System.out.println("Send构造出错------");
            release();
        }
    }
    //从控制台获取信息
    private String getinformation(){
        try {
            return console.readLine();
        } catch (IOException e) {
            System.out.println("获取信息出错--------------");
            return null;
        }
    }
    //发送信息
    public void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("Send发送出错-------------------");
            release();
        }
    }
    private void release(){
        Release.close(dos,client);
    }
}
