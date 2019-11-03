package wangluo.手写聊天室.聊天室;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Chat {
    //一个容器，修改便利（并发）比方便
    private static CopyOnWriteArrayList<Channel>all=new CopyOnWriteArrayList<Channel>();
    public static void main(String[] args) throws IOException {
        boolean flag=true;
        System.out.println("Server------------------");
        ServerSocket server=new ServerSocket(22222);
        while (flag){
            Socket client=server.accept();
            System.out.println("一个客户端建立了连接");
            Channel c =new Channel(client);
            all.add(c);//交给容器管理所有成员
            new Thread(c).start();
            if(client==null){
                flag=false;
            }
        }
    }
    //一个客户代表一个Channel
    static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String name;
        private boolean flag=true;
        @Override
        public void run() {
            while (flag){
                String msg=receive();
                if(msg!=null){
                    sendOthers(name+":"+msg);
                }else flag=false;
            }
        }
        public Channel(Socket client){
            this.client=client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                //获取名称
                this.name=receive();
                sendOthers(name+"已经上线");
            } catch (IOException e) {
                System.out.println("Chat构建Channel出错-------------");
                release();
            }
        }
        private String receive(){
            String datas=null;
            try {
                datas=dis.readUTF();
            } catch (IOException e) {
                System.out.println("Chat接收出错--------------");
                release();
            }
            return datas;
        }
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("Chat发送出错-------------------");
                release();
            }
        }
        //群聊 获取自己的消息，发给其他人
        private void sendOthers(String msg){
            for(Channel other:all){
                if(other==this){
                    continue;
                }
                    other.send(msg);
            }
        }
        //释放资源
        private void release(){
            Release.close(dis,dos,client);
        }
    }
}
