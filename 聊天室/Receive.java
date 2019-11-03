package wangluo.手写聊天室.聊天室;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
    private Socket client;
    private DataInputStream dis;
    private boolean flag=true;
    String msg=null;

    @Override
    public void run() {
        while (flag) {
            msg= receive();
            if (msg!=null){
                System.out.println(msg);
            }else flag=false;
            qingkong();
        }
    }
    public Receive(Socket client){
        this.client=client;
        try {
            dis=new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("Receive构造方法出错------------");
            release();
        }
    }
    public String receive(){
        try {
            String datas=dis.readUTF();
            return datas;
        } catch (IOException e) {
            System.out.println("Receive接收失败-------------------");
            release();
        }
        return null;
    }
    public void release(){
        Release.close(dis,client);
    }
    public void qingkong(){
        this.msg=null;
    }
}
