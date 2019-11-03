package wangluo.手写聊天室.聊天室;

import java.io.*;
import java.net.Socket;

public class Num1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Client--------------------");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name=br.readLine();
        Socket client=new Socket("localhost",22222);
        //客户端发送消息
        new Thread(new Send(client,name)).start();
        new Thread(new Receive(client)).start();
    }
}
