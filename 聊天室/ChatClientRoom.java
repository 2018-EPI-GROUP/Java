package 聊天室;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室客户端
 *
 * java.net.Socket
 * 封装了TCP协议的Socket.通过它来连接服务端的ServerSocket,
 * 并创建输入输出流来与服务器通信.
 */
class Client {
    //用来与服务端通信的Socket
    private Socket socket;

    /**
     * 构造方法,用来初始化客户端
     * 构造方法通常用来初始化对象属性等操作
     */
    public Client(){
        try{

            /*
             * 初始化Socket时需要传入两个参数
             * 1：服务端的IP地址
             * 2：服务端的端口号
             * IP地址的作用是让我们通过网络可以找到服务器
             * 而端口可以让我们找到运行在服务器上的服务端应用程序.
             * 创建Socket实例的过程就是与服务端连接的过程,若可以
             * 成功与服务器连接上，则会创建Socket实例,否则构造
             * 方法会抛异常.
             */
            System.out.println("正在尝试连接服务端...");
            socket = new Socket("localhost",8088);
            System.out.println("与服务端连接成功!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 客户端开始工作的方法
     */
    public void start(){

        try{
            /*
             * 当客户端启动后，就启动接收服务段发送过来
             * 消息的线程.
             */
            GetServerMessageHandler handler = new GetServerMessageHandler();
            Thread t = new Thread(handler);
            t.start();

            /*
             * OutputStream getOutputStream()
             * Socket提供了该方法,用来获取输出流来向服务端发送数据.
             */
            OutputStream out = socket.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");

            PrintWriter pw = new PrintWriter(osw,true);

            Scanner scan = new Scanner(System.in);
            String str = "";
            System.out.println("请输入...");
            while(!str.equalsIgnoreCase("exit")){
                str = scan.nextLine().trim();
                pw.println(str);
                //System.out.println(br.readLine());
            }

            pw.close();

        }catch(Exception e){

        }
    }


    public static void main(String[] args){
        Client client = new Client();
        client.start();
    }

    /**
     * 由于接收服务端发送过来的消息,与我们给定服务端发送消息
     * 没有必然关系,所以两者应当在两个不同的线程上完成,各做
     * 各的,互不干涉.
     */
    private class GetServerMessageHandler implements Runnable{

        public void run() {
            try{

                /*
                 * 该线程的职责就是读取服务端发送过来的
                 * 每一条消息,并输出到控制台.
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String message = null;
                while((message=br.readLine())!=null){
                    System.out.println(message);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
