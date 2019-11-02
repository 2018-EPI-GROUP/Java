package 聊天室;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 * java.net.ServerSocket
 * ServerSocket是运行在服务端的,其作用是向系统
 * 申请服务端口,以便监听该端口,等待客户端的连接.
 * 一旦一个客户端连接,就会创建一个Socket与
 * 该客户端进行通信.
 */
class Server {
    //运行在服务端的ServerSocket
    private ServerSocket server;

    //存放所有输出流的集合,用于广播消息
    private List<PrintWriter> allOut;

    /**
     * 构造方法,用来初始化服务端
     */
    public Server() {
        try {
            allOut = new ArrayList<PrintWriter>();

            /*
             * 初始化ServerSocket的同时需要指定服务端口,该端口不能与当前系统
             * 使用TCP协议的其他程序申请的端口冲突,否则会抛出端口被占用的异常.
             */
            server = new ServerSocket(8088);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void addOut(PrintWriter pw) {
        allOut.add(pw);
    }

    private synchronized void removeOut(PrintWriter pw) {
        allOut.remove(pw);
    }

    private synchronized void sendMessageToAllClient(String m) {
        for (PrintWriter pw : allOut) {
            pw.println(m);
        }
    }


    /**
     * 服务端开始工作的方法
     */
    public void start() {
        try {

            /*
             * Socket accept()
             * ServerSocket提供的该方法用来监听打开的服务端口(8088),
             * 该方法是一个阻塞方法,直到一个客户端尝试连接才会解除阻塞,
             * 并创建一个Socket与刚才连接的客户端进行通讯.
             * accept方法每次调用都会等待一个客户端连接,所以若希望服务端
             * 能够接受若干客户端的连接,就需要多次调用该方法,来分别获取对应
             * 这些客户端的Socket与他们通讯.
             */
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = server.accept();
                System.out.println("一个客户端连接了！");

                /*
                 * 当一个客户端连接后,启动一个线程,来负责与该客户端交互.
                 */
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 该线程用来与一个指定的客户端进行交互.
     * 每当一个客户端连接服务端后,都会启动当前线程来负责与之交互工作.
     */
    private class ClientHandler implements Runnable {
        //当前线程交互的客户端的Socket
        private Socket socket;

        //客户端的地址信息
        private String host;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            //通过socket可以得到远端计算机信息
            InetAddress address = socket.getInetAddress();
            //获取远端计算机IP
            host = address.getHostAddress();
        }

        public void run() {
            PrintWriter pw = null;
            try {

                /*
                 * InputStream getInputStream()
                 * Socket提供的该方法用来获取输入流,读取远端计算机
                 * 发送过来的数据.
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                /*
                 * 通过客户端的Socket获取输出流，以便将消息
                 * 发送给客户端.
                 */
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
                pw = new PrintWriter(osw, true);

                //共享该客户端的输出流
                addOut(pw);

                //广播该用户上线.
                sendMessageToAllClient(host + "上线了");
                String str = null;
                while ((str = br.readLine()) != null) {
                    sendMessageToAllClient(host + "说:" + str);
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                /*
                 * 当该客户端与服务器断开时，应当将该客户端从输出流
                 * 共享集合中删除.
                 */
                removeOut(pw);

                //广播该用户下线.
                sendMessageToAllClient(host + "下线了");

                /*
                 * 无论时linux的客户端,还是windows的客户端，当与
                 * 服务端断开连接后,都应当将与该客户端交互的Socket
                 * 关闭,来释放底层资源.
                 */
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

