package wangluo.手写聊天室.聊天室;

import java.io.Closeable;
import java.io.IOException;

public class Release {
    public static void close(Closeable... targeets){
        for (Closeable target:targeets){
            if(target!=null) {
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
